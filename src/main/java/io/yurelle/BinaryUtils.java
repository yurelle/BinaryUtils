package io.yurelle;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 *
 */
public class BinaryUtils {
    public static <T> void reverseArray(final T[] arr) {
        doReverse(
                arr.length,
                (x,y) -> {
                    T tmp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = tmp;
                }
        );
    }

    public static void reverseArray(final boolean[] arr) {
        doReverse(
                arr.length,
                (x,y) -> {
                    boolean tmp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = tmp;
                }
        );
    }

    public static void reverseArray(final byte[] arr) {
        doReverse(
                arr.length,
                (x,y) -> {
                    byte tmp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = tmp;
                }
        );
    }

    public static void reverseArray(final char[] arr) {
        doReverse(
                arr.length,
                (x,y) -> {
                    char tmp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = tmp;
                }
        );
    }

    public static void reverseArray(final short[] arr) {
        doReverse(
                arr.length,
                (x,y) -> {
                    short tmp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = tmp;
                }
        );
    }

    public static void reverseArray(final int[] arr) {
        doReverse(
                arr.length,
                (x,y) -> {
                    int tmp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = tmp;
                }
        );
    }

    public static void reverseArray(final long[] arr) {
        doReverse(
                arr.length,
                (x,y) -> {
                    long tmp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = tmp;
                }
        );
    }

    public static void reverseArray(final float[] arr) {
        doReverse(
                arr.length,
                (x,y) -> {
                    float tmp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = tmp;
                }
        );
    }

    public static void reverseArray(final double[] arr) {
        doReverse(
                arr.length,
                (x,y) -> {
                    double tmp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = tmp;
                }
        );
    }

    public static void doReverse(int arrayLength, BiConsumer<Integer, Integer> swapper) {
        //Constants
        int mid = arrayLength / 2;
        int last = arrayLength - 1;

        //Do It
        for(int i = 0; i < mid; i++)
        {
            //Calc Pair Index
            int otherIndex = last - i;

            //Do Swap
            swapper.accept(i, otherIndex);
        }
    }

    /**
     * <p>
     * Inverts the order of the bits. Ex: A byte indexed as (0,1,2,3,4,5,6,7),
     * is returned as (7,6,5,4,3,2,1,0)
     * </p>
     *
     * @param b The byte to invert
     * @return The given byte with the bits reversed.
     */
    public static byte invertBitOrder(final byte b) {
        return (byte) (
                ((b >> 7) & 1) |
                ((b >> 5) & 2) |
                ((b >> 3) & 4) |
                ((b >> 1) & 8) |
                ((b << 1) & 16) |
                ((b << 3) & 32) |
                ((b << 5) & 64) |
                ((b << 7) & 128)
        );
    }

    /**
     * <p>
     * Inverts the order of the bits. Ex: A binary array indexed as [0,1,2,3,4,5,6,7],
     * is returned as [7,6,5,4,3,2,1,0]
     * </p>
     *
     * <p>
     * Note: There is no limit on input length.
     * </p>
     *
     * @param bits The binary array to invert.
     * @return The given bit array with in reverse order.
     */
    public static boolean[] invertBitOrder(final boolean[] bits) {
        if (bits == null || bits.length == 0) {
            return new boolean[0];
        }
        boolean[] out = bits.clone();
        reverseArray(out);
        return out;
    }

    /**
     * <p>
     * Inverts the order of the bits. Ex: A bitString indexed as "01234567"
     * is returned as "76543210"
     * </p>
     *
     * <p>
     * Note: There is no limit on input length.
     * </p>
     *
     * @param bitString The bit string to convert.
     * @return The given bit string in reverse order.
     */
    public static String invertBitOrder(final String bitString) {
        if (bitString == null || bitString.length() == 0) {
            return "";
        }
        char[] out = bitString.toCharArray();
        reverseArray(out);
        return new String(out);
    }

    /**
     * <p>
     * Converts a byte into an array of booleans using the default Lsb0 bit ordering.
     * Ex: a byte indexed as (01234567) is returned as [7,6,5,4,3,2,1,0]
     * </p>
     *
     * @param b The byte to convert.
     * @return The bit array equivalent of the given byte; using Lsb0 bit ordering.
     */
    public static boolean[] byteToBinary(final byte b) {
        boolean[] bits = new boolean[8];
        for (int x=0; x<8; x++) {
            bits[x] = ((b >> x) & 1) == 1;
        }
        return bits;
    }

    /**
     * <p>
     * Converts a byte into an array of booleans "as-is". Bit order is maintained, when
     * read from left to right.
     * Ex: a byte indexed as (01234567) is returned as [0,1,2,3,4,5,6,7]
     * </p>
     *
     * @param b the byte to convert.
     * @return The bit array equivalent of the given byte; using "as-is" bit ordering.
     */
    public static boolean[] byteToBinaryRaw(final byte b) {
        return byteToBinaryMsb0(b);
    }

    /**
     * <p>
     * Converts a byte into an array of booleans using the Msb0 bit ordering.
     * Ex: a byte indexed as (01234567) is returned as [0,1,2,3,4,5,6,7]
     * </p>
     *
     * @param b the byte to convert.
     * @return The bit array equivalent of the given byte; using Msb0 bit ordering.
     */
    public static boolean[] byteToBinaryMsb0(final byte b) {
        boolean[] bits = new boolean[8];
        for (int x=0; x<8; x++) {
            bits[7-x] = ((b >> x) & 1) == 1;
        }
        return bits;
    }

    /**
     * <p>
     * Converts binary (represented as boolean array) into a byte using the default Lsb0 bit ordering.
     * Ex: A bit array indexed as [0,1,2,3,4,5,6,7], is returned as (76543210)
     * </p>
     *
     * <p>
     * Note: The input array <code>bits</code> cannot be longer than 8 elements.
     * </p>
     *
     * @param bits The bits to convert.
     * @return The byte equivalent of the given bit array; using Lsb0 bit ordering.
     */
    public static byte binaryToByte(final boolean[] bits) {
        if (bits == null || bits.length == 0) {
            return 0;
        }
        int len = bits.length;
        if (len > 8) {
            throw new IllegalArgumentException("Binary data is longer than 1 byte (8 digits)");
        }

        byte byteOut = 0;
        for (int x=0; x<len; x++) {
            byte bitVal = (byte) ((bits[x])?1:0);
            byteOut |= (byte) ((bitVal) << x);
        }
        return byteOut;
    }

    /**
     * <p>
     * Converts binary (represented as boolean array) into a byte "as-is". Bit order is maintained
     * when read from left to right.
     * Ex: a bit array indexed as [0,1,2,3,4,5,6,7] is returned as (01234567)
     * </p>
     *
     * <p>
     * Note: The input array <code>bits</code> cannot be longer than 8 elements.
     * </p>
     *
     * @param bits The bits to convert.
     * @return The byte equivalent of the given bit array; using "as-is" bit ordering.
     */
    public static byte binaryToByteRaw(final boolean[] bits) {
        return binaryToByteMsb0(bits);
    }

    /**
     * <p>
     * Converts binary (represented as boolean array) into a byte using Msb0 bit ordering.
     * Ex: a bit array indexed as [0,1,2,3,4,5,6,7] is returned as (01234567)
     * </p>
     *
     * <p>
     * Note: The input array <code>bits</code> cannot be longer than 8 elements.
     * </p>
     *
     * @param bits The bits to convert.
     * @return The byte equivalent of the given bit array; using Msb0 bit ordering.
     */
    public static byte binaryToByteMsb0(final boolean[] bits) {
        if (bits == null || bits.length == 0) {
            return 0;
        }
        int len = bits.length;
        if (len > 8) {
            throw new IllegalArgumentException("Binary data is longer than 1 byte (8 digits)");
        }

        byte byteOut = 0;
        for (int x=0; x<len; x++) {
            byte bitVal = (byte) ((bits[x])?1:0);
            byteOut |= (byte) ((bitVal) << (7-x));
        }
        return byteOut;
    }

    /**
     * Strips out all accepted bitString/hexString delimiters, and returns a pure bitString, containing
     * only 1 (one)'s and 0 (zero)'s.
     *
     * @param dataString The source bitString or hexString to parse.
     * @return The given data string with all supported delimiters removed.
     */
    public static String stripStringDelimiters(String dataString) {
        if (dataString == null) {
            return "";
        }
        return dataString.replaceAll("[-_\t\\. ]", "");
    }

    /**
     * <p>
     * Converts a bitString (represented as a String of 1 (one)'s and 0 (zero)'s) into binary
     * (represented as boolean array) "as-is". Bit order is maintained, when read from left
     * to right. Ex: A bitString indexed as "01234567" is returned as [0,1,2,3,4,5,6,7]
     * </p>
     *
     * <p>
     * Note: There is no limit on input length. You may break up the bitString using any of the
     * following delimiters: (delimiters are ignored and have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param bitString The bitString array to convert.
     * @return The bit array equivalent of the given bit string; using "as-is" bit ordering.
     */
    public static boolean[] bitStringToBinaryRaw(final String bitString) {
        if (bitString == null) {
            return new boolean[0];
        }
        final String cleanBitString = stripStringDelimiters(bitString);
        if (cleanBitString.length() == 0) {
            return new boolean[0];
        }
        char[] digits = cleanBitString.toCharArray();
        int len = digits.length;
        boolean[] bits = new boolean[len];
        for (int x=0; x<len; x++) {
            char digit = digits[x];
            if (digit == '0') {
                bits[x] = false;
            } else if (digit == '1') {
                bits[x] = true;
            } else {
                throw new IllegalArgumentException("Bit String can only contain one's (1) and zero's (0) and approved delimiters");
            }
        }
        return bits;
    }

    /**
     * <p>
     * Converts binary (represented as boolean array) into a bitString (represented as a String of
     * 1 (one)'s and 0 (zero)'s) "as-is". Bit order is maintained, when read from left to right.
     * Ex: A bit array indexed as [0,1,2,3,4,5,6,7] is returned as "01234567"
     * </p>
     *
     * <p>
     * Note: There is no limit on input length.
     * </p>
     *
     * @param bits The bit array to convert.
     * @return the bit string equivalent of the given bit array; using "as-is" bit ordering.
     */
    public static String binaryToBitStringRaw(final boolean[] bits) {
        if (bits == null || bits.length == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int len = bits.length;
        for (int x=0; x<len; x++) {
            builder.append(bits[x]?'1':'0');
        }
        return builder.toString();
    }

    /**
     * <p>
     * Converts a byte into binary (represented as boolean array) using the default Lsb0 bit ordering.
     * Ex: A byte indexed as (01234567) is returned as "76543210"
     * </p>
     *
     * @param b The byte to convert.
     * @return The bit string equivalent of the given byte; using Lsb0 bit ordering.
     */
    public static String byteToBitString(final byte b) {
        StringBuilder builder = new StringBuilder();
        for (int x=0; x<8; x++) {
            builder.append( (((b >> x) & 1) == 1)?'1':'0');
        }
        return builder.toString();
    }

    /**
     * <p>
     * Converts a byte into binary (represented as boolean array) "as-is". Bit order is maintained
     * when read from left to right.
     * Ex: A byte indexed as (01234567) is returned as "01234567"
     * </p>
     *
     * @param b The byte to convert.
     * @return The bit string equivalent of the given byte; using "as-is"" bit ordering.
     */
    public static String byteToBitStringRaw(final byte b) {
        return byteToBitStringMsb0(b);
    }

    /**
     * <p>
     * Converts a byte into binary (represented as boolean array) using Msb0 bit ordering.
     * Ex: A byte indexed as (01234567) is returned as "01234567"
     * </p>
     *
     * @param b The byte to convert.
     * @return The bit string equivalent of the given byte; using Msb0 bit ordering.
     */
    public static String byteToBitStringMsb0(final byte b) {
        StringBuilder builder = new StringBuilder();
        for (int x=0; x<8; x++) {
            builder.append( (((b >> (7-x)) & 1) == 1)?'1':'0');
        }
        return builder.toString();
    }

    /**
     * <p>
     * Converts a bitString (represented as a String of 1 (one)'s and 0 (zero)'s) into a byte
     * using the default Lsb0 bit ordering.
     * Ex: A bitString indexed as "01234567" is returned as (76543210)
     * </p>
     *
     * <p>
     * Note: The input String <code>bitString</code> cannot be longer than 8 digits.
     * You may break up the bitString using any of the following delimiters: (delimiters
     * are ignored and have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param bitString The String of bits to convert.
     * @return The byte equivalent of the given bit string; using Lsb0 bit ordering.
     */
    public static byte bitStringToByte(final String bitString) {
        if (bitString == null) {
            return 0;
        }
        final String cleanBitString = stripStringDelimiters(bitString);
        if (cleanBitString.length() == 0) {
            return 0;
        }
        char[] bits = cleanBitString.toCharArray();
        int len = bits.length;
        if (len > 8) {
            throw new IllegalArgumentException("Bit String is longer than 1 byte (8 digits)");
        }

        byte byteOut = 0;
        for (int x=0; x<len; x++) {
            char bit = bits[x];
            if (bit == '1') {
                byte bitVal = (byte) ((bits[x] == '1')?1:0);
                byteOut = (byte) (byteOut | ((bitVal) << x));
            } else if (bit != '0') {
                throw new IllegalArgumentException("Bit String can only contain one's (1) and zero's (0) and approved delimiters");
            }
        }
        return byteOut;
    }

    /**
     * <p>
     * Converts a bitString (represented as a String of 1 (one)'s and 0 (zero)'s) into a byte
     * "as-is". Bit order is maintained, when read from left to right.
     * Ex: A bitString indexed as "01234567" is returned as (01234567)
     * </p>
     *
     * <p>
     * Note: The input String <code>bitString</code> cannot be longer than 8 digits. You may
     * break up the bitString using any of the delimiters: (delimiters are ignored and have
     * no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param bitString The String of bits to convert.
     * @return The byte equivalent of the given bit string; using "as-is" bit ordering.
     */
    public static byte bitStringToByteRaw(final String bitString) {
        return bitStringToByteMsb0(bitString);
    }

    /**
     * <p>
     * Converts a bitString (represented as a String of 1 (one)'s and 0 (zero)'s) into a byte
     * using Msb0 bit ordering.
     * Ex: A bitString indexed as "01234567" is returned as (01234567)
     * </p>
     *
     * <p>
     * Note: The input String <code>bitString</code> cannot be longer than 8 digits. You may
     * break up the bitString using any of the following delimiters: (delimiters are ignored
     * and have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param bitString The String of bits to convert.
     * @return The byte equivalent of the given bit string; using Msb0 bit ordering.
     */
    public static byte bitStringToByteMsb0(final String bitString) {
        if (bitString == null) {
            return 0;
        }
        final String cleanBitString = stripStringDelimiters(bitString);
        if (cleanBitString.length() == 0) {
            return 0;
        }
        char[] bits = cleanBitString.toCharArray();
        int len = bits.length;
        if (len > 8) {
            throw new IllegalArgumentException("Bit String is longer than 1 byte (8 digits)");
        }

        byte byteOut = 0;
        for (int x=0; x<len; x++) {
            char bit = bits[x];
            if (bit == '1') {
                byte bitVal = (byte) ((bits[x] == '1')?1:0);
                byteOut = (byte) (byteOut | ((bitVal) << (7-x)));
            } else if (bit != '0') {
                throw new IllegalArgumentException("Bit String can only contain one's (1) and zero's (0) and approved delimiters");
            }
        }
        return byteOut;
    }

    /**
     * <p>
     * Converts a short into an array of bytes using the default little-endian byte ordering.
     * </p>
     *
     * @param s The value to convert.
     * @return The byte array equivalent of the given short; using little-endian byte ordering.
     */
    public static byte[] toByteArray(short s) {
        return new byte[] {
                (byte) ((s >> 0) & 0xFF),
                (byte) ((s >> 8) & 0xFF)
        };
    }


    /**
     * <p>
     * Converts a short into an array of bytes using big-endian byte ordering.
     * </p>
     *
     * @param s The value to convert.
     * @return The byte array equivalent of the given short; using big-endian byte ordering.
     */
    public static byte[] toByteArrayBe(short s) {
        return new byte[] {
                (byte) ((s >> 8) & 0xFF),
                (byte) ((s >> 0) & 0xFF)
        };
    }

    /**
     * <p>
     * Converts an array of bytes into a short using the default little-endian byte ordering.
     * </p>
     *
     * @param inputBytes The bytes to convert.
     * @return The short equivalent of the given byte array; using little-endian byte ordering.
     */
    public static short toShort(byte[] inputBytes) {
        if (inputBytes == null || inputBytes.length == 0) {
            return 0;
        }
        final int SIZE = Short.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'short' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'short' primitive ("+SIZE+" bytes)");
        }
        return (short) (
                ( (((short) inputBytes[0]) & 0xFF) << 0) |
                ( (((short) inputBytes[1]) & 0xFF) << 8)
        );
    }

    /**
     * <p>
     * Converts an array of bytes into a short using big-endian byte ordering.
     * </p>
     *
     * @param inputBytes The bytes to convert.
     * @return The short equivalent of the given byte array; using big-endian byte ordering.
     */
    public static short toShortBe(byte[] inputBytes) {
        if (inputBytes == null || inputBytes.length == 0) {
            return 0;
        }
        final int SIZE = Short.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'short' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'short' primitive ("+SIZE+" bytes)");
        }
        return (short) (
                ( (((short) inputBytes[0]) & 0xFF) << 8) |
                ( (((short) inputBytes[1]) & 0xFF) << 0)
        );
    }

    /**
     * <p>
     * Converts an int into an array of bytes using the default little-endian byte ordering.
     * </p>
     *
     * @param i The value to convert.
     * @return The byte array equivalent of the given integer; using little-endian byte ordering.
     */
    public static byte[] toByteArray(int i) {
        return new byte[] {
                (byte) ((i >> 0) & 0xFF),
                (byte) ((i >> 8) & 0xFF),
                (byte) ((i >> 16) & 0xFF),
                (byte) ((i >> 24) & 0xFF)
        };
    }

    /**
     * <p>
     * Converts an int into an array of bytes using big-endian byte ordering.
     * </p>
     *
     * @param i The value to convert.
     * @return The byte array equivalent of the given integer; using big-endian byte ordering.
     */
    public static byte[] toByteArrayBe(int i) {
        return new byte[] {
                (byte) ((i >> 24) & 0xFF),
                (byte) ((i >> 16) & 0xFF),
                (byte) ((i >> 8) & 0xFF),
                (byte) ((i >> 0) & 0xFF)
        };
    }

    /**
     * <p>
     * Converts an array of bytes into an int using the default little-endian byte ordering.
     * </p>
     *
     * @param inputBytes The bytes to convert.
     * @return The integer equivalent of the given byte array; using little-endian byte ordering.
     */
    public static int toInt(byte[] inputBytes) {
        if (inputBytes == null || inputBytes.length == 0) {
            return 0;
        }
        final int SIZE = Integer.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'int' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'int' primitive ("+SIZE+" bytes)");
        }
        return (int) (
                ( (((int) inputBytes[0]) & 0xFF) << 0) |
                ( (((int) inputBytes[1]) & 0xFF) << 8) |
                ( (((int) inputBytes[2]) & 0xFF) << 16) |
                ( (((int) inputBytes[3]) & 0xFF) << 24)
        );
    }

    /**
     * <p>
     * Converts an array of bytes into an int using big-endian byte ordering.
     * </p>
     *
     * @param inputBytes The bytes to convert.
     * @return The integer equivalent of the given byte array; using big-endian byte ordering.
     */
    public static int toIntBe(byte[] inputBytes) {
        if (inputBytes == null || inputBytes.length == 0) {
            return 0;
        }
        final int SIZE = Integer.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'int' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'int' primitive ("+SIZE+" bytes)");
        }
        return (int) (
                ( (((int) inputBytes[0]) & 0xFF) << 24) |
                ( (((int) inputBytes[1]) & 0xFF) << 16) |
                ( (((int) inputBytes[2]) & 0xFF) << 8) |
                ( (((int) inputBytes[3]) & 0xFF) << 0)
        );
    }

    /**
     * <p>
     * Converts a long into an array of bytes using the default little-endian byte ordering.
     * </p>
     *
     * @param l The value to convert.
     * @return The byte array equivalent of the given long; using little-endian byte ordering.
     */
    public static byte[] toByteArray(long l) {
        return new byte[] {
                (byte) ((l >> 0) & 0xFFL),
                (byte) ((l >> 8) & 0xFFL),
                (byte) ((l >> 16) & 0xFFL),
                (byte) ((l >> 24) & 0xFFL),
                (byte) ((l >> 32) & 0xFFL),
                (byte) ((l >> 40) & 0xFFL),
                (byte) ((l >> 48) & 0xFFL),
                (byte) ((l >> 56) & 0xFFL)
        };
    }

    /**
     * <p>
     * Converts a long into an array of bytes using big-endian byte ordering.
     * </p>
     *
     * @param l The value to convert.
     * @return The byte array equivalent of the given long; using big-endian byte ordering.
     */
    public static byte[] toByteArrayBe(long l) {
        return new byte[] {
                (byte) ((l >> 56) & 0xFFL),
                (byte) ((l >> 48) & 0xFFL),
                (byte) ((l >> 40) & 0xFFL),
                (byte) ((l >> 32) & 0xFFL),
                (byte) ((l >> 24) & 0xFFL),
                (byte) ((l >> 16) & 0xFFL),
                (byte) ((l >> 8) & 0xFFL),
                (byte) ((l >> 0) & 0xFFL)
        };
    }

    /**
     * <p>
     * Converts an array of bytes into a long using the default little-endian byte ordering.
     * </p>
     *
     * @param inputBytes The bytes to convert.
     * @return The long equivalent of the given byte array; using little-endian byte ordering.
     */
    public static long toLong(byte[] inputBytes) {
        if (inputBytes == null || inputBytes.length == 0) {
            return 0;
        }
        final long SIZE = Long.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'long' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'long' primitive ("+SIZE+" bytes)");
        }
        return (long) (
                ( (((long) inputBytes[0]) & 0xFFL) << 0) |
                ( (((long) inputBytes[1]) & 0xFFL) << 8) |
                ( (((long) inputBytes[2]) & 0xFFL) << 16) |
                ( (((long) inputBytes[3]) & 0xFFL) << 24) |
                ( (((long) inputBytes[4]) & 0xFFL) << 32) |
                ( (((long) inputBytes[5]) & 0xFFL) << 40) |
                ( (((long) inputBytes[6]) & 0xFFL) << 48) |
                ( (((long) inputBytes[7]) & 0xFFL) << 56)
        );
    }

    /**
     * <p>
     * Converts an array of bytes into a long using big-endian byte ordering.
     * </p>
     *
     * @param inputBytes The bytes to convert.
     * @return The long equivalent of the given byte array; using bit-endian byte ordering.
     */
    public static long toLongBe(byte[] inputBytes) {
        if (inputBytes == null || inputBytes.length == 0) {
            return 0;
        }
        final long SIZE = Long.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'long' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'long' primitive ("+SIZE+" bytes)");
        }
        return (long) (
                ( (((long) inputBytes[0]) & 0xFFL) << 56) |
                ( (((long) inputBytes[1]) & 0xFFL) << 48) |
                ( (((long) inputBytes[2]) & 0xFFL) << 40) |
                ( (((long) inputBytes[3]) & 0xFFL) << 32) |
                ( (((long) inputBytes[4]) & 0xFFL) << 24) |
                ( (((long) inputBytes[5]) & 0xFFL) << 16) |
                ( (((long) inputBytes[6]) & 0xFFL) << 8) |
                ( (((long) inputBytes[7]) & 0xFFL) << 0)
        );
    }

    /**
     * <p>
     * Converts a float into an array of bytes using the default little-endian byte ordering.
     * </p>
     *
     * @param f The value to convert.
     * @return The byte array equivalent of the given float; using little-endian byte ordering.
     */
    public static byte[] toByteArray(float f) {
        return toByteArray(Float.floatToIntBits(f));
    }

    /**
     * <p>
     * Converts a float into an array of bytes using big-endian byte ordering.
     * </p>
     *
     * @param f The value to convert.
     * @return The byte array equivalent of the given float; using big-endian byte ordering.
     */
    public static byte[] toByteArrayBe(float f) {
        return toByteArrayBe(Float.floatToIntBits(f));
    }

    /**
     * <p>
     * Converts an array of bytes into a float using the default little-endian byte ordering.
     * </p>
     *
     * @param inputBytes The bytes to convert.
     * @return The float equivalent of the given byte array; using little-endian byte ordering.
     */
    public static float toFloat(byte[] inputBytes) {
        if (inputBytes == null || inputBytes.length == 0) {
            return 0;
        }
        return Float.intBitsToFloat(toInt(inputBytes));
    }

    /**
     * <p>
     * Converts an array of bytes into a float using big-endian byte ordering.
     * </p>
     *
     * @param inputBytes The bytes to convert.
     * @return The float equivalent of the given byte array; using big-endian byte ordering.
     */
    public static float toFloatBe(byte[] inputBytes) {
        if (inputBytes == null || inputBytes.length == 0) {
            return 0;
        }
        return Float.intBitsToFloat(toIntBe(inputBytes));
    }

    /**
     * <p>
     * Converts a double into an array of bytes using the default little-endian byte ordering.
     * </p>
     *
     * @param d The value to convert.
     * @return The byte array equivalent of the given double; using little-endian byte ordering.
     */
    public static byte[] toByteArray(double d) {
        return toByteArray(Double.doubleToLongBits(d));
    }

    /**
     * <p>
     * Converts a double into an array of bytes using big-endian byte ordering.
     * </p>
     *
     * @param d The value to convert.
     * @return The byte array equivalent of the given double; using big-endian byte ordering.
     */
    public static byte[] toByteArrayBe(double d) {
        return toByteArrayBe(Double.doubleToLongBits(d));
    }

    /**
     * <p>
     * Converts an array of bytes into a double using the default little-endian byte ordering.
     * </p>
     *
     * @param inputBytes The bytes to convert.
     * @return The double equivalent of the given byte array; using little-endian byte ordering.
     */
    public static double toDouble(byte[] inputBytes) {
        if (inputBytes == null || inputBytes.length == 0) {
            return 0;
        }
        return Double.longBitsToDouble(toLong(inputBytes));
    }

    /**
     * <p>
     * Converts an array of bytes into a double using big-endian byte ordering.
     * </p>
     *
     * @param inputBytes The bytes to convert.
     * @return The double equivalent of the given byte array; using big-endian byte ordering.
     */
    public static double toDoubleBe(byte[] inputBytes) {
        if (inputBytes == null || inputBytes.length == 0) {
            return 0;
        }
        return Double.longBitsToDouble(toLongBe(inputBytes));
    }

    /**
     * Converts a byte's unsigned value to the equivalent 2 digit hex value.
     *
     * @param b The byte to convert.
     * @return The hex string equivalent of the given byte.
     */
    public static String toHex(byte b) {
        return toHexRaw(new byte[]{b});
    }

    /**
     * Splits a short into its constituent bytes (using little-endian byte ordering), and
     * then converts each of these bytes (using their unsigned value) into the equivalent 2
     * digit hex value.
     *
     * @param s The short to convert.
     * @return The hex string equivalent of the given short; using little-endian byte ordering.
     */
    public static String toHex(short s) {
        byte[] chunks = toByteArray(s);
        return toHexRaw(chunks);
    }

    /**
     * Splits a short into its constituent bytes (using big-endian byte ordering), and
     * then converts each of these bytes (using their unsigned value) into the equivalent 2
     * digit hex value.
     *
     * @param s The short to convert.
     * @return The hex string equivalent of the given short; using big-endian byte ordering.
     */
    public static String toHexBe(short s) {
        byte[] chunks = toByteArrayBe(s);
        return toHexRaw(chunks);
    }

    /**
     * Splits an int into its constituent bytes (using little-endian byte ordering), and
     * then converts each of these bytes (using their unsigned value) into the equivalent 2
     * digit hex value.
     *
     * @param i The int to convert.
     * @return The hex string equivalent of the given integer; using little-endian byte ordering.
     */
    public static String toHex(int i) {
        byte[] chunks = toByteArray(i);
        return toHexRaw(chunks);
    }

    /**
     * Splits an int into its constituent bytes (using big-endian byte ordering), and
     * then converts each of these bytes (using their unsigned value) into the equivalent 2
     * digit hex value.
     *
     * @param i The int to convert.
     * @return The hex string equivalent of the given integer; using big-endian byte ordering.
     */
    public static String toHexBe(int i) {
        byte[] chunks = toByteArrayBe(i);
        return toHexRaw(chunks);
    }

    /**
     * Splits a long into its constituent bytes (using little-endian byte ordering), and
     * then converts each of these bytes (using their unsigned value) into the equivalent 2
     * digit hex value.
     *
     * @param l The long to convert.
     * @return The hex string equivalent of the given long; using little-endian byte ordering.
     */
    public static String toHex(long l) {
        byte[] chunks = toByteArray(l);
        return toHexRaw(chunks);
    }

    /**
     * Splits a long into its constituent bytes (using big-endian byte ordering), and
     * then converts each of these bytes (using their unsigned value) into the equivalent 2
     * digit hex value.
     *
     * @param l The long to convert.
     * @return The hex string equivalent of the given long; using big-endian byte ordering.
     */
    public static String toHexBe(long l) {
        byte[] chunks = toByteArrayBe(l);
        return toHexRaw(chunks);
    }

    /**
     * Splits a float into its constituent bytes (using little-endian byte ordering), and
     * then converts each of these bytes (using their unsigned value) into the equivalent 2
     * digit hex value.
     *
     * @param f The float to convert.
     * @return The hex string equivalent of the given float; using little-endian byte ordering.
     */
    public static String toHex(float f) {
        byte[] chunks = toByteArray(f);
        return toHexRaw(chunks);
    }

    /**
     * Splits a float into its constituent bytes (using big-endian byte ordering), and
     * then converts each of these bytes (using their unsigned value) into the equivalent 2
     * digit hex value.
     *
     * @param f The float to convert.
     * @return The hex string equivalent of the given float; using big-endian byte ordering.
     */
    public static String toHexBe(float f) {
        byte[] chunks = toByteArrayBe(f);
        return toHexRaw(chunks);
    }

    /**
     * Splits a double into its constituent bytes (using little-endian byte ordering), and
     * then converts each of these bytes (using their unsigned value) into the equivalent 2
     * digit hex value.
     *
     * @param d The double to convert.
     * @return The hex string equivalent of the given double; using little-endian byte ordering.
     */
    public static String toHex(double d) {
        byte[] chunks = toByteArray(d);
        return toHexRaw(chunks);
    }

    /**
     * Splits a double into its constituent bytes (using big-endian byte ordering), and
     * then converts each of these bytes (using their unsigned value) into the equivalent 2
     * digit hex value.
     *
     * @param d The double to convert.
     * @return The hex string equivalent of the given double; using big-endian byte ordering.
     */
    public static String toHexBe(double d) {
        byte[] chunks = toByteArrayBe(d);
        return toHexRaw(chunks);
    }

    /**
     * Converts an array of bytes into a String of hexadecimal octets (2 digit hex grouping).
     * Each byte is converted using its unsigned value into the equivalent 2 digit hex value.
     *
     * @param chunks The bytes to convert.
     * @return The hex string equivalent of the given byte array; using "as-is" byte ordering.
     */
    public static String toHexRaw(byte[] chunks) {
        //Null Check
        if (chunks == null) {
            return null;
        }

        //Empty Check
        if (chunks.length == 0) {
            return "";
        }

        //Encode
        return delimitString(encodeHex(chunks), 2, STANDARD_DELIMITER);
    }

    /**
     * <p>
     * Converts a String of hexadecimal octets (2 digit hex grouping) into an array of bytes.
     * Each octet is converted into its equivalent unsigned byte value.
     * </p>
     *
     * <p>
     * Note: there is no limit on the input length. You may break up the hexString using any of
     * the following delimiters: (delimiters are ignored and have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param hexString The byte to convert.
     * @return The byte array equivalent of the given hex string; using "as-is" byte ordering.
     */
    public static byte[] hexToByteArrayRaw(final String hexString) {
        //Null Check
        if (hexString == null) {
            return null;
        }

        //Check Empty (no delimiters)
        final String cleanHexString = stripStringDelimiters(hexString).trim();
        if (cleanHexString.length() == 0) {
            return new byte[0];
        }

        //Decode
        return decodeHex(cleanHexString);
    }

    public static final String STANDARD_DELIMITER = " ";
    public static String delimitString(final String str, final int chunkSize, final String delimiter) {
        //Null Check
        if (str == null) {
            return null;
        }

        //Delimit
        String hex = str.replaceAll("(.{" + chunkSize + "})", "$1" + delimiter);

        //Trim Trailing Delimiter
        final char lastChar = hex.charAt(hex.length()-1);
        if (STANDARD_DELIMITER.equals("" + lastChar)) {
            hex = hex.substring(0, hex.length()-1);
        }

        //Return
        return hex;
    }

    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    /**
     * Converts the given byte array into a continuous hex string, with no delimiters
     * or spaces. This is a simple version of hex encoding, intended to match the
     * behavior of the other encode/decode functions; ex: encodeB64. For a more
     * complicated hex encoding, which supports delimiters, See: hexToByteArrayRaw(String).
     *
     * @param data The bytes to be encoded
     *
     * @return An String of hex characters representing the given bytes.
     */
    public static String encodeHex(final byte[] data) {
        //Null Check
        if (data == null) {
            return null;
        }

        //Empty Check
        if (data.length == 0) {
            return "";
        }

        //Init
        final int len = data.length;
        final char[] hexChars = new char[len * 2];

        //Process
        for (int x = 0; x < len; x++) {
            //Current Record
            final byte curByte = data[x];
            final int curHexIndex = x * 2;

            //Translate
            hexChars[curHexIndex]     = HEX_DIGITS[(curByte >> 4) & 0x0F];
            hexChars[curHexIndex + 1] = HEX_DIGITS[(curByte >> 0) & 0x0F];
        }

        //Make String & Return
        return new String(hexChars);
    }

    /**
     * Converts the given continuous hex string into a byte array; assuming no delimiters
     * or spaces. This is a simple version of hex decoding, intended to match the
     * behavior of the other encode/decode functions; ex: decodeB64. For a more
     * complicated hex decoding, which supports delimiters, See: toHexRaw(byte[]).
     *
     * @param hex The hex string to be decoded
     *
     * @return A byte array representing the binary equivalent of the given hex string.
     */
    public static byte[] decodeHex(final String hex) {
        //Null Check
        if (hex == null) {
            return null;
        }

        //Empty Check
        if (hex.trim().equals("")) {
            return new byte[0];
        }

        //Init
        final char[] hexDigits = hex.toCharArray();
        final int numHexDigits = hexDigits.length;

        //Ensure 2 Hex Digits Per Byte
        if (numHexDigits % 2 != 0) {
            throw new IllegalArgumentException("Input hex String must have even number of digits (2 hex per byte).");
        }
        final int numBytes = numHexDigits / 2;
        final byte[] bytes = new byte[numBytes];

        //Process
        for (int x = 0; x < numBytes; x++) {
            final int digitIndex = x * 2;
            final char nibble1 = hexDigits[digitIndex];
            final char nibble2 = hexDigits[digitIndex + 1];

            bytes[x] = (byte) (
                    ((getHexDigitVal(nibble1) & 0x0F) << 4) |
                    ((getHexDigitVal(nibble2) & 0x0F) << 0)
            );

        }

        //Return
        return bytes;
    }

    private static byte getHexDigitVal(final char hexDigit) {
        if (hexDigit >= '0' && hexDigit <= '9') {
            return (byte) (hexDigit - '0');
        } else if (hexDigit >= 'A' && hexDigit <= 'F') {
            return (byte) (hexDigit - 'A' + 10); // +10 adjusts for 0-9
        } else {
            throw new IllegalArgumentException("Input string can only contain hex digits");
        }
    }

    /**
     * <p>
     * Converts a String of hexadecimal octets (2 digit hex grouping) into a short
     * using little-endian byte ordering. Each octet is converted into its equivalent
     * unsigned byte value.
     * </p>
     *
     * <p>
     * Note: A short is composed of 2 octets (4 Hex Digits). You may break up the
     * hexString using any of the following delimiters: (delimiters are ignored and
     * have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param hexString The String of hexadecimal octets to convert.
     * @return The short equivalent of the given hex string; using little-endian byte ordering.
     */
    public static short hexToShort(String hexString) {
        //Null Check
        if (hexString == null) {
            throw new IllegalArgumentException("Input String is null; primitives can't be null");
        }

        //Convert to Bytes
        byte[] inputBytes = hexToByteArrayRaw(hexString);
        if (inputBytes.length == 0) {
            return 0;
        }

        //Check Proper Length
        final long SIZE = Short.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'short' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'short' primitive ("+SIZE+" bytes)");
        }

        //Do conversion
        return toShort(inputBytes);
    }

    /**
     * <p>
     * Converts a String of hexadecimal octets (2 digit hex grouping) into a short
     * using big-endian byte ordering. Each octet is converted into its equivalent
     * unsigned byte value.
     * </p>
     *
     * <p>
     * Note: A short is composed of 2 octets (4 Hex Digits). You may break up the
     * hexString using any of the following delimiters: (delimiters are ignored and
     * have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param hexString The String of hexadecimal octets to convert.
     * @return The short equivalent of the given hex string; using big-endian byte ordering.
     */
    public static short hexToShortBe(String hexString) {
        //Null Check
        if (hexString == null) {
            throw new IllegalArgumentException("Input String is null; primitives can't be null");
        }

        //Convert to Bytes
        byte[] inputBytes = hexToByteArrayRaw(hexString);
        if (inputBytes.length == 0) {
            return 0;
        }

        //Check Proper Length
        final long SIZE = Short.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'short' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'short' primitive ("+SIZE+" bytes)");
        }

        //Do conversion
        return toShortBe(inputBytes);
    }

    /**
     * <p>
     * Converts a String of hexadecimal octets (2 digit hex grouping) into an int
     * using little-endian byte ordering. Each octet is converted into its equivalent
     * unsigned byte value.
     * </p>
     *
     * <p>
     * Note: An int is composed of 4 octets (8 Hex Digits). You may break up the
     * hexString using any of the following delimiters: (delimiters are ignored and
     * have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param hexString The String of hexadecimal octets to convert.
     * @return The integer equivalent of the given hex string; using little-endian byte ordering.
     */
    public static int hexToInt(String hexString) {
        //Null Check
        if (hexString == null) {
            throw new IllegalArgumentException("Input String is null; primitives can't be null");
        }

        //Convert to Bytes
        byte[] inputBytes = hexToByteArrayRaw(hexString);
        if (inputBytes.length == 0) {
            return 0;
        }

        //Check Proper Length
        final long SIZE = Integer.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'int' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'int' primitive ("+SIZE+" bytes)");
        }

        //Do conversion
        return toInt(inputBytes);
    }

    /**
     * <p>
     * Converts a String of hexadecimal octets (2 digit hex grouping) into an int
     * using big-endian byte ordering. Each octet is converted into its equivalent
     * unsigned byte value.
     * </p>
     *
     * <p>
     * Note: An int is composed of 4 octets (8 Hex Digits). You may break up the
     * hexString using any of the following delimiters: (delimiters are ignored and
     * have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param hexString The String of hexadecimal octets to convert.
     * @return The integer equivalent of the given hex string; using big-endian byte ordering.
     */
    public static int hexToIntBe(String hexString) {
        //Null Check
        if (hexString == null) {
            throw new IllegalArgumentException("Input String is null; primitives can't be null");
        }

        //Convert to Bytes
        byte[] inputBytes = hexToByteArrayRaw(hexString);
        if (inputBytes.length == 0) {
            return 0;
        }

        //Check Proper Length
        final long SIZE = Integer.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'int' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'int' primitive ("+SIZE+" bytes)");
        }

        //Do conversion
        return toIntBe(inputBytes);
    }

    /**
     * <p>
     * Converts a String of hexadecimal octets (2 digit hex grouping) into a long
     * using little-endian byte ordering. Each octet is converted into its equivalent
     * unsigned byte value.
     * </p>
     *
     * <p>
     * Note: A long is composed of 8 octets (16 Hex Digits). You may break up the
     * hexString using any of the following delimiters: (delimiters are ignored and
     * have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param hexString The String of hexadecimal octets to convert.
     * @return The long equivalent of the given hex string; using little-endian byte ordering.
     */
    public static long hexToLong(String hexString) {
        //Null Check
        if (hexString == null) {
            throw new IllegalArgumentException("Input String is null; primitives can't be null");
        }

        //Convert to Bytes
        byte[] inputBytes = hexToByteArrayRaw(hexString);
        if (inputBytes.length == 0) {
            return 0;
        }

        //Check Proper Length
        final long SIZE = Long.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'long' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'long' primitive ("+SIZE+" bytes)");
        }

        //Do conversion
        return toLong(inputBytes);
    }

    /**
     * <p>
     * Converts a String of hexadecimal octets (2 digit hex grouping) into a long
     * using big-endian byte ordering. Each octet is converted into its equivalent
     * unsigned byte value.
     * </p>
     *
     * <p>
     * Note: A long is composed of 8 octets (16 Hex Digits). You may break up the
     * hexString using any of the following delimiters: (delimiters are ignored and
     * have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param hexString The String of hexadecimal octets to convert.
     * @return The long equivalent of the given hex string; using big-endian byte ordering.
     */
    public static long hexToLongBe(String hexString) {
        //Null Check
        if (hexString == null) {
            throw new IllegalArgumentException("Input String is null; primitives can't be null");
        }

        //Convert to Bytes
        byte[] inputBytes = hexToByteArrayRaw(hexString);
        if (inputBytes.length == 0) {
            return 0;
        }

        //Check Proper Length
        final long SIZE = Long.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'long' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'long' primitive ("+SIZE+" bytes)");
        }

        //Do conversion
        return toLongBe(inputBytes);
    }

    /**
     * <p>
     * Converts a String of hexadecimal octets (2 digit hex grouping) into a float
     * using little-endian byte ordering. Each octet is converted into its equivalent
     * unsigned byte value.
     * </p>
     *
     * <p>
     * Note: A float is composed of 4 octets (8 Hex Digits). You may break up the
     * hexString using any of the following delimiters: (delimiters are ignored and
     * have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param hexString The String of hexadecimal octets to convert.
     * @return The float equivalent of the given hex string; using little-endian byte ordering.
     */
    public static float hexToFloat(String hexString) {
        //Null Check
        if (hexString == null) {
            throw new IllegalArgumentException("Input String is null; primitives can't be null");
        }

        //Convert to Bytes
        byte[] inputBytes = hexToByteArrayRaw(hexString);
        if (inputBytes.length == 0) {
            return 0;
        }

        //Check Proper Length
        final float SIZE = Float.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'float' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'float' primitive ("+SIZE+" bytes)");
        }

        //Do conversion
        return toFloat(inputBytes);
    }

    /**
     * <p>
     * Converts a String of hexadecimal octets (2 digit hex grouping) into a float
     * using big-endian byte ordering. Each octet is converted into its equivalent
     * unsigned byte value.
     * </p>
     *
     * <p>
     * Note: A float is composed of 4 octets (8 Hex Digits). You may break up the
     * hexString using any of the following delimiters: (delimiters are ignored and
     * have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param hexString The String of hexadecimal octets to convert.
     * @return The float equivalent of the given hex string; using big-endian byte ordering.
     */
    public static float hexToFloatBe(String hexString) {
        //Null Check
        if (hexString == null) {
            throw new IllegalArgumentException("Input String is null; primitives can't be null");
        }

        //Convert to Bytes
        byte[] inputBytes = hexToByteArrayRaw(hexString);
        if (inputBytes.length == 0) {
            return 0;
        }

        //Check Proper Length
        final float SIZE = Float.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'float' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'float' primitive ("+SIZE+" bytes)");
        }

        //Do conversion
        return toFloatBe(inputBytes);
    }

    /**
     * <p>
     * Converts a String of hexadecimal octets (2 digit hex grouping) into a double
     * using little-endian byte ordering. Each octet is converted into its equivalent
     * unsigned byte value.
     * </p>
     *
     * <p>
     * Note: A double is composed of 8 octets (16 Hex Digits). You may break up the
     * hexString using any of the following delimiters: (delimiters are ignored and
     * have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param hexString The String of hexadecimal octets to convert.
     * @return The double equivalent of the given hex string; using little-endian byte ordering.
     */
    public static double hexToDouble(String hexString) {
        //Null Check
        if (hexString == null) {
            throw new IllegalArgumentException("Input String is null; primitives can't be null");
        }

        //Convert to Bytes
        byte[] inputBytes = hexToByteArrayRaw(hexString);
        if (inputBytes.length == 0) {
            return 0;
        }

        //Check Proper Length
        final double SIZE = Double.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'double' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'double' primitive ("+SIZE+" bytes)");
        }

        //Do conversion
        return toDouble(inputBytes);
    }

    /**
     * <p>
     * Converts a String of hexadecimal octets (2 digit hex grouping) into a double
     * using big-endian byte ordering. Each octet is converted into its equivalent
     * unsigned byte value.
     * </p>
     *
     * <p>
     * Note: A double is composed of 8 octets (16 Hex Digits). You may break up the
     * hexString using any of the following delimiters: (delimiters are ignored and
     * have no impact on the output)<br>
     * '-' [hyphen]<br>
     * '_' [underscore]<br>
     * '.' [period]<br>
     * ' ' [space]<br>
     * '\t' [tab]
     * </p>
     *
     * @param hexString The String of hexadecimal octets to convert.
     * @return The double equivalent of the given hex string; using big-endian byte ordering.
     */
    public static double hexToDoubleBe(String hexString) {
        //Null Check
        if (hexString == null) {
            throw new IllegalArgumentException("Input String is null; primitives can't be null");
        }

        //Convert to Bytes
        byte[] inputBytes = hexToByteArrayRaw(hexString);
        if (inputBytes.length == 0) {
            return 0;
        }

        //Check Proper Length
        final double SIZE = Double.BYTES;
        if (inputBytes.length > SIZE) {
            throw new IllegalArgumentException("Input data is longer than size of 'double' primitive ("+SIZE+" bytes)");
        } else if (inputBytes.length < SIZE) {
            throw new IllegalArgumentException("Input data is smaller than size of 'double' primitive ("+SIZE+" bytes)");
        }

        //Do conversion
        return toDoubleBe(inputBytes);
    }


    public static final String UTF_8_CHARACTER_ENCODING = "UTF-8";
    public static byte[] getBytes(final String inputStr) {
        byte[] strBytes;
        try {
            strBytes = inputStr.getBytes(UTF_8_CHARACTER_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            strBytes = null;

            /*
             * This error should never happen. See:
             * https://www.baeldung.com/java-char-encoding#:~:text=Java%20supports%20a%20wide%20array,16%20to%20name%20a%20few.
             *
             * "The class Charset defines a set of standard encodings which every implementation of Java platform is mandated to support.
             * This includes US-ASCII, ISO-8859-1, UTF-8, and UTF-16 to name a few."
             */
        }
        return strBytes;
    }

    public static String stringFromBytes(final byte[] strBytes) {
        String returnString;
        try {
            returnString = new String(strBytes, UTF_8_CHARACTER_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            returnString = null;

            /*
             * This error should never happen. See:
             * https://www.baeldung.com/java-char-encoding#:~:text=Java%20supports%20a%20wide%20array,16%20to%20name%20a%20few.
             *
             * "The class Charset defines a set of standard encodings which every implementation of Java platform is mandated to support.
             * This includes US-ASCII, ISO-8859-1, UTF-8, and UTF-16 to name a few."
             */
        }
        return returnString;
    }

    public static byte boolToByte(final boolean b) {
        return (byte) (b ? 1 : 0);
    }

    public static boolean byteToBoolean(final byte b) {
        return b == 1;
    }

    public static void saveBoolean(final boolean b, final OutputStream out) throws IOException {
        saveByte(boolToByte(b), out);
    }

    public static void saveByte(final byte b, final OutputStream out) throws IOException {
        out.write(b);
    }

    public static void saveChar(final char c, final OutputStream out) throws IOException {
        saveByte((byte) c, out);
    }

    public static void saveShort(final short s, final OutputStream out) throws IOException {
        out.write(toByteArray(s));
    }

    public static void saveInt(final int i, final OutputStream out) throws IOException {
        out.write(toByteArray(i));
    }

    public static void saveLong(final long l, final OutputStream out) throws IOException {
        out.write(toByteArray(l));
    }

    public static void saveFloat(final float f, final OutputStream out) throws IOException {
        out.write(toByteArray(f));
    }

    public static void saveDouble(final double d, final OutputStream out) throws IOException {
        out.write(toByteArray(d));
    }

    public static void saveCalendar(final Calendar cal, final OutputStream out) throws IOException {
        saveLong(cal.getTimeInMillis(), out);
    }

    public static void saveUUID(final UUID uuid, final OutputStream out) throws IOException {
        saveString(uuid.toString(), out);
    }

    public static final String STR_CHAR_SET = "UTF-8";
    public static void saveString(final String s, final OutputStream out) throws IOException {
        //Null Check
        if (s == null) {
            saveArray(null, out);
        } else {//Not Null
            final byte[] strBytes = s.getBytes(STR_CHAR_SET);

            //Write String
            saveArray(strBytes, out);
        }
    }

    public static void saveArray(final byte[] array, final OutputStream out) throws IOException {
        //Null Check
        if (array == null || array.length == 0) {
            //Write Length Zero
            saveInt(0, out);
        } else {//Not Null
            //Write Size
            saveInt(array.length, out);

            //Write Data
            out.write(array);
        }
    }

    public static boolean readBoolean(final InputStream in) throws IOException {
        return byteToBoolean(readByte(in));
    }

    public static byte readByte(final InputStream in) throws IOException {
        return (byte) in.read();
    }

    public static char readChar(final InputStream in) throws IOException {
        return (char) readByte(in);
    }

    public static short readShort(final InputStream in) throws IOException {
        return toShort(readBytes(Short.BYTES, in));
    }

    public static int readInt(final InputStream in) throws IOException {
        return toInt(readBytes(Integer.BYTES, in));
    }

    public static long readLong(final InputStream in) throws IOException {
        return toLong(readBytes(Long.BYTES, in));
    }

    public static float readFloat(final InputStream in) throws IOException {
        return toFloat(readBytes(Float.BYTES, in));
    }

    public static double readDouble(final InputStream in) throws IOException {
        return toDouble(readBytes(Double.BYTES, in));
    }

    public static Calendar readCalendar(final InputStream in) throws IOException {
        final long mills = readLong(in);

        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(mills);

        return cal;
    }

    public static UUID readUUID(final InputStream in) throws IOException {
        return UUID.fromString(readString(in));
    }

    public static String readString(final InputStream in) throws IOException {
        //Read String
        return new String(readArray(in), STR_CHAR_SET);
    }

    public static byte[] readArray(final InputStream in) throws IOException {
        //Read Size
        final int length = readInt(in);

        //Read Data
        return readBytes(length, in);
    }

    public static final byte[] readBytes(final int numBytes, final InputStream in) throws IOException {
        //Check Params
        if (numBytes < 0) {
            throw new IllegalArgumentException("numBytes must be positive! Received numBytes: '" + numBytes + "'");
        } else if (numBytes == 0) {
            return new byte[0];
        }

        //Init Buffer
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();

        //Read All Remaining Bytes
        final byte[] buf = new byte[numBytes];
        final int bytesRead = in.read(buf);
        bos.write(buf, 0, bytesRead);

        //Verify Data Length
        if (bytesRead != numBytes) {
            if (bytesRead < numBytes) {
                throw new IOException("Unexpected end of data stream! Expected '" + numBytes + "' bytes; found '" + bytesRead + "' bytes.");
            } else if (bytesRead > numBytes) {
                throw new IOException("Unexpected data stream overflow! Expected '" + numBytes + "' bytes; received '" + bytesRead + "' bytes.");
            }
        }

        //Return
        return bos.toByteArray();
    }


    public static byte[] compress(final String data) {
        return compress(getBytes(data));
    }

    public static byte[] compress(final byte[] originalData) {
        return compress(originalData, 9);
    }

    public static byte[] compress(final byte[] originalData, final int compressionLevel) {
        //Init - Compressor
        final Deflater compressor = new Deflater(compressionLevel);
        compressor.setInput(originalData);
        compressor.finish();

        //Init - Output Buffer
        final byte[] outputBuffer = new byte[8192];
        ByteArrayOutputStream compressedData = new ByteArrayOutputStream();

        //Compress
        while (!compressor.finished()) {
            final int numBytesCompressed = compressor.deflate(outputBuffer);
            compressedData.write(outputBuffer, 0, numBytesCompressed);
        }

        //Trim Array & Return
        return compressedData.toByteArray();
    }

    public static String decompressToString(final byte[] compressedData) throws DataFormatException {
        return stringFromBytes(decompress(compressedData));
    }

    public static byte[] decompress(final byte[] compressedData) throws DataFormatException {
        //Init
        final Inflater decompressor = new Inflater();
        decompressor.setInput(compressedData, 0, compressedData.length);

        final byte[] outputBuffer = new byte[8192];
        ByteArrayOutputStream decompressedData = new ByteArrayOutputStream();

        //Decompress
        while (!decompressor.finished()) {
            final int numBytesDecompressed = decompressor.inflate(outputBuffer);
            decompressedData.write(outputBuffer, 0, numBytesDecompressed);
        }
        decompressor.end();

        //Trim Array & Return
        return decompressedData.toByteArray();
    }




    public static String encodeBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public static byte[] decodeBase64(String data) {
        return Base64.getDecoder().decode(data);
    }

    public static String hashToHex(final String inputStr, final int charLimit) {
        return truncate(hashToHex(inputStr), charLimit);
    }

    public static String hashToHex(final String inputStr) {
        byte[] binHash = hash(inputStr);

        return encodeHex(binHash);
    }

    public static String hashToB64(final String inputStr, final int charLimit) {
        return truncate(hashToB64(inputStr), charLimit);
    }

    public static String hashToB64(final String inputStr) {
        byte[] binHash = hash(inputStr);

        //Convert Binary to Base64
        return encodeBase64(binHash);
    }

    public static byte[] hash(final String inputStr) {
        byte[] strBytes = getBytes(inputStr);

        //Generate Binary Hash
        byte[] binHash = messageDigester.digest(strBytes);
        messageDigester.reset();

        //Return
        return binHash;
    }

    private static String truncate(final String s, final int charLimit) {
        return s.substring(0, charLimit);
    }

    private static final MessageDigest messageDigester;
    static {
        //Hasher
        MessageDigest tmp;
        try {
            tmp = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            tmp = null;
            e.printStackTrace();

            /* This error should never happen. According to the Javadoc:
             * https://docs.oracle.com/javase/7/docs/api/java/security/MessageDigest.html
             *
             * "Every implementation of the Java platform is required to support the following standard MessageDigest algorithms:
             * - MD5
             * - SHA-1
             * - SHA-256"
             */

        }
        messageDigester = tmp;
    }
}
