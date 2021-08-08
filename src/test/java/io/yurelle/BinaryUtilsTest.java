package io.yurelle;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryUtilsTest
{
    /**
     * Tests {@link BinaryUtils#invertBitOrder(byte b)}.
     */
    @Test
    public void testInvertBitOrder_byte() {
        //Semi
        int len = TestBinaryByteBlocks.byteSemiFalseBits.length;
        int lastIndex = len-1;
        for (int x=0; x<len; x++) {
            assertEquals(TestBinaryByteBlocks.byteSemiFalseBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.byteSemiTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSemiTrueBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.byteSemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.byteSingleTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            assertEquals(TestBinaryByteBlocks.byteSingleTrueBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.byteSingleTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSingleFalseBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.byteSingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.bytePairTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            assertEquals(TestBinaryByteBlocks.bytePairTrueBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bytePairTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bytePairFalseBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bytePairFalseBits[x]));
        }
    }

    /**
     * Tests {@link BinaryUtils#invertBitOrder(boolean[])}.
     */
    @Test
    public void testInvertBitOrder_binary() {
        //Semi
        int len = TestBinaryByteBlocks.binarySemiFalseBits.length;
        int lastIndex = len-1;
        for (int x=0; x<len; x++) {
            assertArrayEquals(TestBinaryByteBlocks.binarySemiFalseBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.binarySemiTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binarySemiTrueBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.binarySemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.binarySingleTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            assertArrayEquals(TestBinaryByteBlocks.binarySingleTrueBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.binarySingleTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binarySingleFalseBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.binarySingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.binaryPairTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            assertArrayEquals(TestBinaryByteBlocks.binaryPairTrueBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.binaryPairTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binaryPairFalseBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.binaryPairFalseBits[x]));
        }

        //Undersized
        assertArrayEquals(TestBinaryByteBlocks.binary_Undersized[0],
                BinaryUtils.invertBitOrder(TestBinaryByteBlocks.binary_Undersized[1]));

        //Oversized
        assertArrayEquals(TestBinaryByteBlocks.binary_Oversized_Leading_0s[0],
                BinaryUtils.invertBitOrder(TestBinaryByteBlocks.binary_Oversized_Leading_0s[1]));
        assertArrayEquals(TestBinaryByteBlocks.binary_Oversized_Leading_1s[0],
                BinaryUtils.invertBitOrder(TestBinaryByteBlocks.binary_Oversized_Leading_1s[1]));
        assertArrayEquals(TestBinaryByteBlocks.binary_Oversized_Trailing_0s[0],
                BinaryUtils.invertBitOrder(TestBinaryByteBlocks.binary_Oversized_Trailing_0s[1]));
        assertArrayEquals(TestBinaryByteBlocks.binary_Oversized_Trailing_1s[0],
                BinaryUtils.invertBitOrder(TestBinaryByteBlocks.binary_Oversized_Trailing_1s[1]));

        //Check Null & Empty
        assertArrayEquals(new boolean[0], BinaryUtils.invertBitOrder((boolean[]) null));
        assertArrayEquals(new boolean[0], BinaryUtils.invertBitOrder(new boolean[0]));
    }

    /**
     * Tests {@link BinaryUtils#invertBitOrder(String)}.
     */
    @Test
    public void testInvertBitOrder_bitString() {
        //Semi
        int len = TestBinaryByteBlocks.binarySemiTrueBits.length;
        int lastIndex = len-1;
        for (int x=0; x<len; x++) {
            assertEquals(TestBinaryByteBlocks.bitStringSemiFalseBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bitStringSemiTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringSemiTrueBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bitStringSemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.bitStringSingleTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            assertEquals(TestBinaryByteBlocks.bitStringSingleTrueBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bitStringSingleTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringSingleFalseBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bitStringSingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.bitStringPairTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            assertEquals(TestBinaryByteBlocks.bitStringPairTrueBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bitStringPairTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringPairFalseBits[lastIndex-x],
                    BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bitStringPairFalseBits[x]));
        }

        //Undersized
        assertEquals(TestBinaryByteBlocks.bitString_Undersized[0],
                BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bitString_Undersized[1]));

        //Oversized
        assertEquals(TestBinaryByteBlocks.bitString_Oversized_Leading_0s[0],
                BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bitString_Oversized_Leading_0s[1]));
        assertEquals(TestBinaryByteBlocks.bitString_Oversized_Leading_1s[0],
                BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bitString_Oversized_Leading_1s[1]));
        assertEquals(TestBinaryByteBlocks.bitString_Oversized_Trailing_0s[0],
                BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bitString_Oversized_Trailing_0s[1]));
        assertEquals(TestBinaryByteBlocks.bitString_Oversized_Trailing_1s[0],
                BinaryUtils.invertBitOrder(TestBinaryByteBlocks.bitString_Oversized_Trailing_1s[1]));

        //Check Null & Empty
        assertEquals("", BinaryUtils.invertBitOrder((String) null));
        assertEquals("", BinaryUtils.invertBitOrder(""));
    }

    /**
     * Tests {@link BinaryUtils#byteToBinary(byte)}.
     */
    @Test
    public void testByteToBinary_convenienceMethod() {
        //Semi
        int len = TestBinaryByteBlocks.byteSemiTrueBits.length;
        int lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertArrayEquals(TestBinaryByteBlocks.binarySemiFalseBits[lastIndex-x],
                    BinaryUtils.byteToBinary(TestBinaryByteBlocks.byteSemiTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binarySemiTrueBits[lastIndex-x],
                    BinaryUtils.byteToBinary(TestBinaryByteBlocks.byteSemiFalseBits[x]));

        }

        //Single
        len = TestBinaryByteBlocks.byteSingleTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertArrayEquals(TestBinaryByteBlocks.binarySingleTrueBits[lastIndex-x],
                    BinaryUtils.byteToBinary(TestBinaryByteBlocks.byteSingleTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binarySingleFalseBits[lastIndex-x],
                    BinaryUtils.byteToBinary(TestBinaryByteBlocks.byteSingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.bytePairTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertArrayEquals(TestBinaryByteBlocks.binaryPairTrueBits[lastIndex-x],
                    BinaryUtils.byteToBinary(TestBinaryByteBlocks.bytePairTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binaryPairFalseBits[lastIndex-x],
                    BinaryUtils.byteToBinary(TestBinaryByteBlocks.bytePairFalseBits[x]));
        }
    }

    /**
     * Tests {@link BinaryUtils#byteToBinaryRaw(byte)}.
     */
    @Test
    public void testByteToBinaryRaw_convenienceMethod() {
        //Semi
        int len = TestBinaryByteBlocks.binarySemiTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertArrayEquals(TestBinaryByteBlocks.binarySemiTrueBits[x],
                    BinaryUtils.byteToBinaryRaw(TestBinaryByteBlocks.byteSemiTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binarySemiFalseBits[x],
                    BinaryUtils.byteToBinaryRaw(TestBinaryByteBlocks.byteSemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.binarySingleTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertArrayEquals(TestBinaryByteBlocks.binarySingleTrueBits[x],
                    BinaryUtils.byteToBinaryRaw(TestBinaryByteBlocks.byteSingleTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binarySingleFalseBits[x],
                    BinaryUtils.byteToBinaryRaw(TestBinaryByteBlocks.byteSingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.binaryPairTrueBits.length;
        for (int x=0; x<len; x++) {
            assertArrayEquals(TestBinaryByteBlocks.binaryPairTrueBits[x],
                    BinaryUtils.byteToBinaryRaw(TestBinaryByteBlocks.bytePairTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binaryPairFalseBits[x],
                    BinaryUtils.byteToBinaryRaw(TestBinaryByteBlocks.bytePairFalseBits[x]));
        }
    }

    /**
     * Tests {@link BinaryUtils#byteToBinaryMsb0(byte)}.
     */
    @Test
    public void testByteToBinaryMsb0_convenienceMethod() {
        //Semi
        int len = TestBinaryByteBlocks.binarySemiTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertArrayEquals(TestBinaryByteBlocks.binarySemiTrueBits[x],
                    BinaryUtils.byteToBinaryMsb0(TestBinaryByteBlocks.byteSemiTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binarySemiFalseBits[x],
                    BinaryUtils.byteToBinaryMsb0(TestBinaryByteBlocks.byteSemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.binarySingleTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertArrayEquals(TestBinaryByteBlocks.binarySingleTrueBits[x],
                    BinaryUtils.byteToBinaryMsb0(TestBinaryByteBlocks.byteSingleTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binarySingleFalseBits[x],
                    BinaryUtils.byteToBinaryMsb0(TestBinaryByteBlocks.byteSingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.binaryPairTrueBits.length;
        for (int x=0; x<len; x++) {
            assertArrayEquals(TestBinaryByteBlocks.binaryPairTrueBits[x],
                    BinaryUtils.byteToBinaryMsb0(TestBinaryByteBlocks.bytePairTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binaryPairFalseBits[x],
                    BinaryUtils.byteToBinaryMsb0(TestBinaryByteBlocks.bytePairFalseBits[x]));
        }
    }

    /**
     * Tests {@link BinaryUtils#binaryToByte(boolean[])}.
     */
    @Test
    public void testBinaryToByte_convenienceMethod() {
        byte BASE_CODE_ANSWER = 0;

        //Semi
        int len = TestBinaryByteBlocks.binarySemiTrueBits.length;
        int lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byteSemiFalseBits[lastIndex-x],
                    BinaryUtils.binaryToByte(TestBinaryByteBlocks.binarySemiTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSemiTrueBits[lastIndex-x],
                    BinaryUtils.binaryToByte(TestBinaryByteBlocks.binarySemiFalseBits[x]));

        }

        //Single
        len = TestBinaryByteBlocks.binarySingleTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byteSingleTrueBits[lastIndex-x],
                    BinaryUtils.binaryToByte(TestBinaryByteBlocks.binarySingleTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSingleFalseBits[lastIndex-x],
                    BinaryUtils.binaryToByte(TestBinaryByteBlocks.binarySingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.binaryPairTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bytePairTrueBits[lastIndex-x],
                    BinaryUtils.binaryToByte(TestBinaryByteBlocks.binaryPairTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bytePairFalseBits[lastIndex-x],
                    BinaryUtils.binaryToByte(TestBinaryByteBlocks.binaryPairFalseBits[x]));
        }

        //Undersized
        len = TestBinaryByteBlocks.binary_Undersized.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byte_Undersized[lastIndex-x],
                    BinaryUtils.binaryToByte(TestBinaryByteBlocks.binary_Undersized[x]));
        }

        //Check Null & Empty
        assertEquals(0, BinaryUtils.binaryToByte((boolean[]) null));
        assertEquals(0, BinaryUtils.binaryToByte(new boolean[0]));
    }

    /**
     * Tests {@link BinaryUtils#binaryToByte(boolean[])}.
     */
    @Test
    public void testBinaryToByte_convenienceMethod_oversizedException() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.binaryToByte(TestBinaryByteBlocks.binary_Oversized_Leading_0s[0]));
    }

    /**
     * Tests {@link BinaryUtils#binaryToByteRaw(boolean[])}.
     */
    @Test
    public void testBinaryToByteRaw_convenienceMethod() {
        //Semi
        int len = TestBinaryByteBlocks.binarySemiTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byteSemiTrueBits[x],
                    BinaryUtils.binaryToByteRaw(TestBinaryByteBlocks.binarySemiTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSemiFalseBits[x],
                    BinaryUtils.binaryToByteRaw(TestBinaryByteBlocks.binarySemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.binarySingleTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byteSingleTrueBits[x],
                    BinaryUtils.binaryToByteRaw(TestBinaryByteBlocks.binarySingleTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSingleFalseBits[x],
                    BinaryUtils.binaryToByteRaw(TestBinaryByteBlocks.binarySingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.binaryPairTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bytePairTrueBits[x],
                    BinaryUtils.binaryToByteRaw(TestBinaryByteBlocks.binaryPairTrueBits[x]));
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bytePairFalseBits[x],
                    BinaryUtils.binaryToByteRaw(TestBinaryByteBlocks.binaryPairFalseBits[x]));
        }

        //Undersized
        len = TestBinaryByteBlocks.binary_Undersized.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byte_Undersized_Msb0_fullByteValue[x],
                    BinaryUtils.binaryToByteRaw(TestBinaryByteBlocks.binary_Undersized[x]));
        }

        //Check Null & Empty
        assertEquals(0, BinaryUtils.binaryToByteRaw((boolean[]) null));
        assertEquals(0, BinaryUtils.binaryToByteRaw(new boolean[0]));
    }

    /**
     * Tests {@link BinaryUtils#binaryToByteRaw(boolean[])}.
     */
    @Test
    public void testBinaryToByteRaw_convenienceMethod_oversizedException() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.binaryToByteRaw(TestBinaryByteBlocks.binary_Oversized_Leading_0s[0]));
    }

    /**
     * Tests {@link BinaryUtils#binaryToByteMsb0(boolean[])}.
     */
    @Test
    public void testBinaryToByteMsb0_convenienceMethod() {
        //Semi
        int len = TestBinaryByteBlocks.binarySemiTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byteSemiTrueBits[x],
                    BinaryUtils.binaryToByteMsb0(TestBinaryByteBlocks.binarySemiTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSemiFalseBits[x],
                    BinaryUtils.binaryToByteMsb0(TestBinaryByteBlocks.binarySemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.binarySingleTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byteSingleTrueBits[x],
                    BinaryUtils.binaryToByteMsb0(TestBinaryByteBlocks.binarySingleTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSingleFalseBits[x],
                    BinaryUtils.binaryToByteMsb0(TestBinaryByteBlocks.binarySingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.binaryPairTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bytePairTrueBits[x],
                    BinaryUtils.binaryToByteMsb0(TestBinaryByteBlocks.binaryPairTrueBits[x]));
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bytePairFalseBits[x],
                    BinaryUtils.binaryToByteMsb0(TestBinaryByteBlocks.binaryPairFalseBits[x]));
        }

        //Undersized
        len = TestBinaryByteBlocks.binary_Undersized.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byte_Undersized_Msb0_fullByteValue[x],
                    BinaryUtils.binaryToByteMsb0(TestBinaryByteBlocks.binary_Undersized[x]));
        }

        //Check Null & Empty
        assertEquals(0, BinaryUtils.binaryToByteMsb0((boolean[]) null));
        assertEquals(0, BinaryUtils.binaryToByteMsb0(new boolean[0]));
    }

    /**
     * Tests {@link BinaryUtils#binaryToByteMsb0(boolean[])}.
     */
    @Test
    public void testBinaryToByteMsb0_convenienceMethod_oversizedException() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.binaryToByteMsb0(TestBinaryByteBlocks.binary_Oversized_Leading_0s[0]));
    }

    /**
     * Tests {@link BinaryUtils#stripStringDelimiters(String)}.
     */
    @Test
    public void testStripStringDelimiters() {
        //Check Null & Empty
        assertEquals("", BinaryUtils.stripStringDelimiters((String) null));
        assertEquals("", BinaryUtils.stripStringDelimiters(""));
        assertEquals("", BinaryUtils.stripStringDelimiters(".--..._\t\t__  . .\t_ --_-.   \t-"));

        //Check ignore delimiters
        int len = TestBinaryByteBlocks.bitString_Delimited_Dashes.length;
        for (int x=0; x<len; x++) {
            assertEquals(TestBinaryByteBlocks.bitString_Delimited_None[x],
                    BinaryUtils.stripStringDelimiters(TestBinaryByteBlocks.bitString_Delimited_Spaces[x]));
            assertEquals(TestBinaryByteBlocks.bitString_Delimited_None[x],
                    BinaryUtils.stripStringDelimiters(TestBinaryByteBlocks.bitString_Delimited_Dashes[x]));
            assertEquals(TestBinaryByteBlocks.bitString_Delimited_None[x],
                    BinaryUtils.stripStringDelimiters(TestBinaryByteBlocks.bitString_Delimited_Underscores[x]));
            assertEquals(TestBinaryByteBlocks.bitString_Delimited_None[x],
                    BinaryUtils.stripStringDelimiters(TestBinaryByteBlocks.bitString_Delimited_Periods[x]));
            assertEquals(TestBinaryByteBlocks.bitString_Delimited_None[x],
                    BinaryUtils.stripStringDelimiters(TestBinaryByteBlocks.bitString_Delimited_All[x]));
        }
    }

    /**
     * Tests {@link BinaryUtils#bitStringToBinaryRaw(String)}.
     */
    @Test
    public void testBitStringToBinaryRaw() {
        //Semi
        int len = TestBinaryByteBlocks.binarySemiTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertArrayEquals(TestBinaryByteBlocks.binarySemiTrueBits[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitStringSemiTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binarySemiFalseBits[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitStringSemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.binarySingleTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertArrayEquals(TestBinaryByteBlocks.binarySingleTrueBits[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitStringSingleTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binarySingleFalseBits[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitStringSingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.binaryPairTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertArrayEquals(TestBinaryByteBlocks.binaryPairTrueBits[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitStringPairTrueBits[x]));
            assertArrayEquals(TestBinaryByteBlocks.binaryPairFalseBits[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitStringPairFalseBits[x]));
        }

        //Undersized
        len = TestBinaryByteBlocks.binary_Undersized.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertArrayEquals(TestBinaryByteBlocks.binary_Undersized[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitString_Undersized[x]));
        }

        //Oversized
        len = TestBinaryByteBlocks.bitString_Oversized_Leading_0s.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertArrayEquals(TestBinaryByteBlocks.binary_Oversized_Leading_0s[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitString_Oversized_Leading_0s[x]));
            assertArrayEquals(TestBinaryByteBlocks.binary_Oversized_Leading_1s[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitString_Oversized_Leading_1s[x]));
            assertArrayEquals(TestBinaryByteBlocks.binary_Oversized_Trailing_0s[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitString_Oversized_Trailing_0s[x]));
            assertArrayEquals(TestBinaryByteBlocks.binary_Oversized_Trailing_1s[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitString_Oversized_Trailing_1s[x]));
        }

        //Check Null & Empty
        assertArrayEquals(new boolean[0], BinaryUtils.bitStringToBinaryRaw((String) null));
        assertArrayEquals(new boolean[0], BinaryUtils.bitStringToBinaryRaw(""));

        //Check ignore delimiters
        assertArrayEquals(new boolean[0], BinaryUtils.bitStringToBinaryRaw("- \t_"));
        assertArrayEquals(new boolean[0], BinaryUtils.bitStringToBinaryRaw("- \t_"));

        for (int x=0; x<TestBinaryByteBlocks.bitString_Delimited_Dashes.length; x++) {
            assertArrayEquals(TestBinaryByteBlocks.binary_Delimited_None[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitString_Delimited_Spaces[x]));
            assertArrayEquals(TestBinaryByteBlocks.binary_Delimited_None[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitString_Delimited_Dashes[x]));
            assertArrayEquals(TestBinaryByteBlocks.binary_Delimited_None[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitString_Delimited_Underscores[x]));
            assertArrayEquals(TestBinaryByteBlocks.binary_Delimited_None[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitString_Delimited_Periods[x]));
            assertArrayEquals(TestBinaryByteBlocks.binary_Delimited_None[x],
                    BinaryUtils.bitStringToBinaryRaw(TestBinaryByteBlocks.bitString_Delimited_All[x]));
        }
    }

    /**
     * Tests {@link BinaryUtils#binaryToBitStringRaw(boolean[])}.
     */
    @Test
    public void testBinaryToBitStringRaw() {
        //Semi
        int len = TestBinaryByteBlocks.bitStringSemiTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitStringSemiTrueBits[x],
                    BinaryUtils.binaryToBitStringRaw(TestBinaryByteBlocks.binarySemiTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringSemiFalseBits[x],
                    BinaryUtils.binaryToBitStringRaw(TestBinaryByteBlocks.binarySemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.bitStringSingleTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitStringSingleTrueBits[x],
                    BinaryUtils.binaryToBitStringRaw(TestBinaryByteBlocks.binarySingleTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringSingleFalseBits[x],
                    BinaryUtils.binaryToBitStringRaw(TestBinaryByteBlocks.binarySingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.bitStringPairTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitStringPairTrueBits[x],
                    BinaryUtils.binaryToBitStringRaw(TestBinaryByteBlocks.binaryPairTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringPairFalseBits[x],
                    BinaryUtils.binaryToBitStringRaw(TestBinaryByteBlocks.binaryPairFalseBits[x]));
        }

        //Undersized
        len = TestBinaryByteBlocks.binary_Undersized.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitString_Undersized[x],
                    BinaryUtils.binaryToBitStringRaw(TestBinaryByteBlocks.binary_Undersized[x]));
        }

        //Oversized
        len = TestBinaryByteBlocks.bitString_Oversized_Leading_0s.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitString_Oversized_Leading_0s[x],
                    BinaryUtils.binaryToBitStringRaw(TestBinaryByteBlocks.binary_Oversized_Leading_0s[x]));
            assertEquals(TestBinaryByteBlocks.bitString_Oversized_Leading_1s[x],
                    BinaryUtils.binaryToBitStringRaw(TestBinaryByteBlocks.binary_Oversized_Leading_1s[x]));
            assertEquals(TestBinaryByteBlocks.bitString_Oversized_Trailing_0s[x],
                    BinaryUtils.binaryToBitStringRaw(TestBinaryByteBlocks.binary_Oversized_Trailing_0s[x]));
            assertEquals(TestBinaryByteBlocks.bitString_Oversized_Trailing_1s[x],
                    BinaryUtils.binaryToBitStringRaw(TestBinaryByteBlocks.binary_Oversized_Trailing_1s[x]));
        }

        //Check Null & Empty
        assertEquals("", BinaryUtils.binaryToBitStringRaw((boolean[]) null));
        assertEquals("", BinaryUtils.binaryToBitStringRaw(new boolean[0]));
    }

    /**
     * Tests {@link BinaryUtils#byteToBitString(byte)}.
     */
    @Test
    public void testByteToBitString() {
        //Semi
        int len = TestBinaryByteBlocks.bitStringSemiFalseBits.length;
        int lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitStringSemiFalseBits[lastIndex-x],
                    BinaryUtils.byteToBitString(TestBinaryByteBlocks.byteSemiTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringSemiTrueBits[lastIndex-x],
                    BinaryUtils.byteToBitString(TestBinaryByteBlocks.byteSemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.bitStringSingleTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitStringSingleTrueBits[lastIndex-x],
                    BinaryUtils.byteToBitString(TestBinaryByteBlocks.byteSingleTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringSingleFalseBits[lastIndex-x],
                    BinaryUtils.byteToBitString(TestBinaryByteBlocks.byteSingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.bitStringPairTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitStringPairTrueBits[lastIndex-x],
                    BinaryUtils.byteToBitString(TestBinaryByteBlocks.bytePairTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringPairFalseBits[lastIndex-x],
                    BinaryUtils.byteToBitString(TestBinaryByteBlocks.bytePairFalseBits[x]));
        }
    }

    /**
     * Tests {@link BinaryUtils#byteToBitStringRaw(byte)}.
     */
    @Test
    public void testByteToBitStringRaw() {
        //Semi
        int len = TestBinaryByteBlocks.bitStringSemiFalseBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitStringSemiTrueBits[x],
                    BinaryUtils.byteToBitStringRaw(TestBinaryByteBlocks.byteSemiTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringSemiFalseBits[x],
                    BinaryUtils.byteToBitStringRaw(TestBinaryByteBlocks.byteSemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.bitStringSingleTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitStringSingleTrueBits[x],
                    BinaryUtils.byteToBitStringRaw(TestBinaryByteBlocks.byteSingleTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringSingleFalseBits[x],
                    BinaryUtils.byteToBitStringRaw(TestBinaryByteBlocks.byteSingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.bitStringPairTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitStringPairTrueBits[x],
                    BinaryUtils.byteToBitStringRaw(TestBinaryByteBlocks.bytePairTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringPairFalseBits[x],
                    BinaryUtils.byteToBitStringRaw(TestBinaryByteBlocks.bytePairFalseBits[x]));
        }
    }

    /**
     * Tests {@link BinaryUtils#byteToBitStringMsb0(byte)}.
     */
    @Test
    public void testByteToBitStringMsb0() {
        //Semi
        int len = TestBinaryByteBlocks.bitStringSemiFalseBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitStringSemiTrueBits[x],
                    BinaryUtils.byteToBitStringMsb0(TestBinaryByteBlocks.byteSemiTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringSemiFalseBits[x],
                    BinaryUtils.byteToBitStringMsb0(TestBinaryByteBlocks.byteSemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.bitStringSingleTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitStringSingleTrueBits[x],
                    BinaryUtils.byteToBitStringMsb0(TestBinaryByteBlocks.byteSingleTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringSingleFalseBits[x],
                    BinaryUtils.byteToBitStringMsb0(TestBinaryByteBlocks.byteSingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.bitStringPairTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bitStringPairTrueBits[x],
                    BinaryUtils.byteToBitStringMsb0(TestBinaryByteBlocks.bytePairTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bitStringPairFalseBits[x],
                    BinaryUtils.byteToBitStringMsb0(TestBinaryByteBlocks.bytePairFalseBits[x]));
        }
    }

    /**
     * Tests {@link BinaryUtils#bitStringToByte(String)}.
     */
    @Test
    public void testBitStringToByte() {
        //Semi
        int len = TestBinaryByteBlocks.byteSemiTrueBits.length;
        int lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byteSemiFalseBits[lastIndex-x],
                    BinaryUtils.bitStringToByte(TestBinaryByteBlocks.bitStringSemiTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSemiTrueBits[lastIndex-x],
                    BinaryUtils.bitStringToByte(TestBinaryByteBlocks.bitStringSemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.byteSingleTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byteSingleTrueBits[lastIndex-x],
                    BinaryUtils.bitStringToByte(TestBinaryByteBlocks.bitStringSingleTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSingleFalseBits[lastIndex-x],
                    BinaryUtils.bitStringToByte(TestBinaryByteBlocks.bitStringSingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.bytePairTrueBits.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bytePairTrueBits[lastIndex-x],
                    BinaryUtils.bitStringToByte(TestBinaryByteBlocks.bitStringPairTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bytePairFalseBits[lastIndex-x],
                    BinaryUtils.bitStringToByte(TestBinaryByteBlocks.bitStringPairFalseBits[x]));
        }

        //Check Null & Empty
        assertEquals(0, BinaryUtils.bitStringToByte((String) null));
        assertEquals(0, BinaryUtils.bitStringToByte(""));

        //Check ignore delimiters
        assertEquals(0, BinaryUtils.bitStringToByte("- \t_"));
        assertEquals(0, BinaryUtils.bitStringToByte("- \t_"));

        len = TestBinaryByteBlocks.bitString_Delimited_Dashes.length;
        lastIndex = len-1;
        for (int x=0; x<len; x++) {
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[lastIndex-x],
                    BinaryUtils.bitStringToByte(TestBinaryByteBlocks.bitString_Delimited_Spaces[x]));
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[lastIndex-x],
                    BinaryUtils.bitStringToByte(TestBinaryByteBlocks.bitString_Delimited_Dashes[x]));
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[lastIndex-x],
                    BinaryUtils.bitStringToByte(TestBinaryByteBlocks.bitString_Delimited_Underscores[x]));
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[lastIndex-x],
                    BinaryUtils.bitStringToByte(TestBinaryByteBlocks.bitString_Delimited_Periods[x]));
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[lastIndex-x],
                    BinaryUtils.bitStringToByte(TestBinaryByteBlocks.bitString_Delimited_All[x]));
        }
    }

    /**
     * Tests {@link BinaryUtils#bitStringToByte(String)}.
     */
    @Test
    public void testBitStringToByte_oversizedException() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.bitStringToByte(TestBinaryByteBlocks.bitString_Oversized_Leading_0s[0]));
    }

    /**
     * Tests {@link BinaryUtils#bitStringToByte(String)}.
     */
    @Test
    public void testBitStringToByte_notBitStringException() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.bitStringToByte("Not Bit String"));
    }

    /**
     * Tests {@link BinaryUtils#bitStringToByteRaw(String)}.
     */
    @Test
    public void testBitStringToByteRaw() {
        //Semi
        int len = TestBinaryByteBlocks.byteSemiTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byteSemiTrueBits[x],
                    BinaryUtils.bitStringToByteRaw(TestBinaryByteBlocks.bitStringSemiTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSemiFalseBits[x],
                    BinaryUtils.bitStringToByteRaw(TestBinaryByteBlocks.bitStringSemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.byteSingleTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byteSingleTrueBits[x],
                    BinaryUtils.bitStringToByteRaw(TestBinaryByteBlocks.bitStringSingleTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSingleFalseBits[x],
                    BinaryUtils.bitStringToByteRaw(TestBinaryByteBlocks.bitStringSingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.bytePairTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bytePairTrueBits[x],
                    BinaryUtils.bitStringToByteRaw(TestBinaryByteBlocks.bitStringPairTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bytePairFalseBits[x],
                    BinaryUtils.bitStringToByteRaw(TestBinaryByteBlocks.bitStringPairFalseBits[x]));
        }

        //Check Null & Empty
        assertEquals(0, BinaryUtils.bitStringToByteRaw((String) null));
        assertEquals(0, BinaryUtils.bitStringToByteRaw(""));

        //Check ignore delimiters
        assertEquals(0, BinaryUtils.bitStringToByteRaw("- \t_"));
        assertEquals(0, BinaryUtils.bitStringToByteRaw("- \t_"));

        for (int x=0; x<TestBinaryByteBlocks.bitString_Delimited_Dashes.length; x++) {
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[x],
                    BinaryUtils.bitStringToByteRaw(TestBinaryByteBlocks.bitString_Delimited_Spaces[x]));
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[x],
                    BinaryUtils.bitStringToByteRaw(TestBinaryByteBlocks.bitString_Delimited_Dashes[x]));
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[x],
                    BinaryUtils.bitStringToByteRaw(TestBinaryByteBlocks.bitString_Delimited_Underscores[x]));
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[x],
                    BinaryUtils.bitStringToByteRaw(TestBinaryByteBlocks.bitString_Delimited_Periods[x]));
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[x],
                    BinaryUtils.bitStringToByteRaw(TestBinaryByteBlocks.bitString_Delimited_All[x]));
        }
    }

    /**
     * Tests {@link BinaryUtils#bitStringToByteRaw(String)}.
     */
    @Test
    public void testBitStringToByteRaw_oversizedException() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.bitStringToByteRaw(TestBinaryByteBlocks.bitString_Oversized_Leading_0s[0]));
    }

    /**
     * Tests {@link BinaryUtils#bitStringToByteRaw(String)}.
     */
    @Test
    public void testBitStringToByteRaw_notBitStringException() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.bitStringToByteRaw("Not A Bit String"));
    }

    /**
     * Tests {@link BinaryUtils#bitStringToByteMsb0(String)}.
     */
    @Test
    public void testBitStringToByteMsb0() {
        //Semi
        int len = TestBinaryByteBlocks.byteSemiTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byteSemiTrueBits[x],
                    BinaryUtils.bitStringToByteMsb0(TestBinaryByteBlocks.bitStringSemiTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSemiFalseBits[x],
                    BinaryUtils.bitStringToByteMsb0(TestBinaryByteBlocks.bitStringSemiFalseBits[x]));
        }

        //Single
        len = TestBinaryByteBlocks.byteSingleTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.byteSingleTrueBits[x],
                    BinaryUtils.bitStringToByteMsb0(TestBinaryByteBlocks.bitStringSingleTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.byteSingleFalseBits[x],
                    BinaryUtils.bitStringToByteMsb0(TestBinaryByteBlocks.bitStringSingleFalseBits[x]));
        }

        //Pair
        len = TestBinaryByteBlocks.bytePairTrueBits.length;
        for (int x=0; x<len; x++) {
            //Check expected value
            assertEquals(TestBinaryByteBlocks.bytePairTrueBits[x],
                    BinaryUtils.bitStringToByteMsb0(TestBinaryByteBlocks.bitStringPairTrueBits[x]));
            assertEquals(TestBinaryByteBlocks.bytePairFalseBits[x],
                    BinaryUtils.bitStringToByteMsb0(TestBinaryByteBlocks.bitStringPairFalseBits[x]));
        }

        //Check Null & Empty
        assertEquals(0, BinaryUtils.bitStringToByteMsb0((String) null));
        assertEquals(0, BinaryUtils.bitStringToByteMsb0(""));

        //Check ignore delimiters
        assertEquals(0, BinaryUtils.bitStringToByteMsb0("- \t_"));
        assertEquals(0, BinaryUtils.bitStringToByteMsb0("- \t_"));

        for (int x=0; x<TestBinaryByteBlocks.bitString_Delimited_Dashes.length; x++) {
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[x],
                    BinaryUtils.bitStringToByteMsb0(TestBinaryByteBlocks.bitString_Delimited_Spaces[x]));
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[x],
                    BinaryUtils.bitStringToByteMsb0(TestBinaryByteBlocks.bitString_Delimited_Dashes[x]));
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[x],
                    BinaryUtils.bitStringToByteMsb0(TestBinaryByteBlocks.bitString_Delimited_Underscores[x]));
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[x],
                    BinaryUtils.bitStringToByteMsb0(TestBinaryByteBlocks.bitString_Delimited_Periods[x]));
            assertEquals(TestBinaryByteBlocks.byte_Delimited_None[x],
                    BinaryUtils.bitStringToByteMsb0(TestBinaryByteBlocks.bitString_Delimited_All[x]));
        }
    }

    /**
     * Tests {@link BinaryUtils#bitStringToByteMsb0(String)}.
     */
    @Test
    public void testBitStringToByteMsb0_oversizedException() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.bitStringToByteMsb0(TestBinaryByteBlocks.bitString_Oversized_Leading_0s[0]));
    }

    /**
     * Tests {@link BinaryUtils#bitStringToByteMsb0(String)}.
     */
    @Test
    public void testBitStringToByteMsb0_notBitStringException() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.bitStringToByteMsb0("Not A Bit String"));
    }

    /**
     * Tests {@link BinaryUtils#hexToByteArrayRaw(String)}.
     */
    @Test
    public void testHexToByteArrayRaw() {
        //Check Values
        assertArrayEquals(TestBinaryByteBlocks.hexStringByteVals_Delimited_None,
                BinaryUtils.hexToByteArrayRaw(TestBinaryByteBlocks.hexString_Delimited_None));
        assertArrayEquals(TestBinaryByteBlocks.hexStringByteVals_Delimited_None,
                BinaryUtils.hexToByteArrayRaw(TestBinaryByteBlocks.hexString_Delimited_Spaces));
        assertArrayEquals(TestBinaryByteBlocks.hexStringByteVals_Delimited_None,
                BinaryUtils.hexToByteArrayRaw(TestBinaryByteBlocks.hexString_Delimited_Dashes));
        assertArrayEquals(TestBinaryByteBlocks.hexStringByteVals_Delimited_None,
                BinaryUtils.hexToByteArrayRaw(TestBinaryByteBlocks.hexString_Delimited_Underscores));
        assertArrayEquals(TestBinaryByteBlocks.hexStringByteVals_Delimited_None,
                BinaryUtils.hexToByteArrayRaw(TestBinaryByteBlocks.hexString_Delimited_Periods));
        assertArrayEquals(TestBinaryByteBlocks.hexStringByteVals_Delimited_None,
                BinaryUtils.hexToByteArrayRaw(TestBinaryByteBlocks.hexString_Delimited_Tabs));
        assertArrayEquals(TestBinaryByteBlocks.hexStringByteVals_Delimited_None,
                BinaryUtils.hexToByteArrayRaw(TestBinaryByteBlocks.hexString_Delimited_All));

        //Check Null & Empty
        assertArrayEquals(null, BinaryUtils.hexToByteArrayRaw((String) null));
        assertArrayEquals(new byte[0], BinaryUtils.hexToByteArrayRaw(""));
        assertArrayEquals(new byte[0], BinaryUtils.hexToByteArrayRaw(".-- .\t\t __  \t-._"));
    }

    /**
     * Tests {@link BinaryUtils#hexToByteArrayRaw(String)}.
     */
    @Test
    public void testHexToByteArrayRaw_OddLengthException() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToByteArrayRaw("FA219"));
    }

    /**
     * Tests {@link BinaryUtils#hexToByteArrayRaw(String)}.
     */
    @Test
    public void testHexToByteArrayRaw_OddLengthException_WithEvenTotal() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToByteArrayRaw("FA.21-_9"));
    }



    /* ************************************** *
     * ************************************** *
     * ***         ************************** *
     * ***  Short  ************************** *
     * ***         ************************** *
     * ************************************** *
     * ************************************** */

    /**
     * Tests {@link BinaryUtils#toByteArray(short)}.
     */
    @Test
    public void testToByteArray_short() {
        //Check raw bytes
        assertArrayEquals(TestBinaryByteBlocks.SHORT_MAX_VAL_BYTES, BinaryUtils.toByteArray(Short.MAX_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.SHORT_MIN_VAL_BYTES, BinaryUtils.toByteArray(Short.MIN_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.SHORT_NEG_1_BYTES,   BinaryUtils.toByteArray((short) -1));
        assertArrayEquals(TestBinaryByteBlocks.SHORT_0_BYTES,       BinaryUtils.toByteArray((short) 0));
        assertArrayEquals(TestBinaryByteBlocks.SHORT_1_BYTES,       BinaryUtils.toByteArray((short) 1));

        //Check full conversion cycle
        assertEquals(Short.MAX_VALUE, BinaryUtils.toShort(BinaryUtils.toByteArray(Short.MAX_VALUE)));
        assertEquals(Short.MIN_VALUE, BinaryUtils.toShort(BinaryUtils.toByteArray(Short.MIN_VALUE)));
        assertEquals((short) -1,      BinaryUtils.toShort(BinaryUtils.toByteArray((short) -1)));
        assertEquals((short) 0,       BinaryUtils.toShort(BinaryUtils.toByteArray((short) 0)));
        assertEquals((short) 1,       BinaryUtils.toShort(BinaryUtils.toByteArray((short) 1)));
    }

    /**
     * Tests {@link BinaryUtils#toByteArrayBe(short)}.
     */
    @Test
    public void testToByteArrayBe_short() {
        //Check raw bytes
        assertArrayEquals(TestBinaryByteBlocks.Be_SHORT_MAX_VAL_BYTES, BinaryUtils.toByteArrayBe(Short.MAX_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.Be_SHORT_MIN_VAL_BYTES, BinaryUtils.toByteArrayBe(Short.MIN_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.Be_SHORT_NEG_1_BYTES,   BinaryUtils.toByteArrayBe((short) -1));
        assertArrayEquals(TestBinaryByteBlocks.Be_SHORT_0_BYTES,       BinaryUtils.toByteArrayBe((short) 0));
        assertArrayEquals(TestBinaryByteBlocks.Be_SHORT_1_BYTES,       BinaryUtils.toByteArrayBe((short) 1));

        //Check full conversion cycle
        assertEquals(Short.MAX_VALUE, BinaryUtils.toShortBe(BinaryUtils.toByteArrayBe(Short.MAX_VALUE)));
        assertEquals(Short.MIN_VALUE, BinaryUtils.toShortBe(BinaryUtils.toByteArrayBe(Short.MIN_VALUE)));
        assertEquals((short) -1,      BinaryUtils.toShortBe(BinaryUtils.toByteArrayBe((short) -1)));
        assertEquals((short) 0,       BinaryUtils.toShortBe(BinaryUtils.toByteArrayBe((short) 0)));
        assertEquals((short) 1,       BinaryUtils.toShortBe(BinaryUtils.toByteArrayBe((short) 1)));
    }

    /**
     * Tests {@link BinaryUtils#toShort(byte[])}.
     */
    @Test
    public void testToShort() {
        //Check values
        assertEquals(Short.MAX_VALUE, BinaryUtils.toShort(TestBinaryByteBlocks.SHORT_MAX_VAL_BYTES));
        assertEquals(Short.MIN_VALUE, BinaryUtils.toShort(TestBinaryByteBlocks.SHORT_MIN_VAL_BYTES));
        assertEquals((short) -1,      BinaryUtils.toShort(TestBinaryByteBlocks.SHORT_NEG_1_BYTES));
        assertEquals((short) 0,       BinaryUtils.toShort(TestBinaryByteBlocks.SHORT_0_BYTES));
        assertEquals((short) 1,       BinaryUtils.toShort(TestBinaryByteBlocks.SHORT_1_BYTES));

        //Check Null & Empty
        assertEquals((short) 0, BinaryUtils.toShort((byte[]) null));
        assertEquals((short) 0, BinaryUtils.toShort(new byte[0]));

        //Check full conversion cycle
        assertEquals(Short.MAX_VALUE, BinaryUtils.toShort(BinaryUtils.toByteArray(Short.MAX_VALUE)));
        assertEquals(Short.MIN_VALUE, BinaryUtils.toShort(BinaryUtils.toByteArray(Short.MIN_VALUE)));
        assertEquals((short) -1,      BinaryUtils.toShort(BinaryUtils.toByteArray((short) -1)));
        assertEquals((short) 0,       BinaryUtils.toShort(BinaryUtils.toByteArray((short) 0)));
        assertEquals((short) 1,       BinaryUtils.toShort(BinaryUtils.toByteArray((short) 1)));
    }

    /**
     * Tests {@link BinaryUtils#toShort(byte[])}.
     */
    @Test
    public void testToShort_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toShort(new byte[TestBinaryByteBlocks.SHORT_BYTES+1]));
    }

    /**
     * Tests {@link BinaryUtils#toShort(byte[])}.
     */
    @Test
    public void testToShort_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toShort(new byte[TestBinaryByteBlocks.SHORT_BYTES-1]));
    }

    /**
     * Tests {@link BinaryUtils#toShortBe(byte[])}.
     */
    @Test
    public void testToShortBe() {
        //Check values
        assertEquals(Short.MAX_VALUE, BinaryUtils.toShortBe(TestBinaryByteBlocks.Be_SHORT_MAX_VAL_BYTES));
        assertEquals(Short.MIN_VALUE, BinaryUtils.toShortBe(TestBinaryByteBlocks.Be_SHORT_MIN_VAL_BYTES));
        assertEquals((short) -1,      BinaryUtils.toShortBe(TestBinaryByteBlocks.Be_SHORT_NEG_1_BYTES));
        assertEquals((short) 0,       BinaryUtils.toShortBe(TestBinaryByteBlocks.Be_SHORT_0_BYTES));
        assertEquals((short) 1,       BinaryUtils.toShortBe(TestBinaryByteBlocks.Be_SHORT_1_BYTES));

        //Check Null & Empty
        assertEquals((short) 0, BinaryUtils.toShortBe((byte[]) null));
        assertEquals((short) 0, BinaryUtils.toShortBe(new byte[0]));

        //Check full conversion cycle
        assertEquals(Short.MAX_VALUE, BinaryUtils.toShortBe(BinaryUtils.toByteArrayBe(Short.MAX_VALUE)));
        assertEquals(Short.MIN_VALUE, BinaryUtils.toShortBe(BinaryUtils.toByteArrayBe(Short.MIN_VALUE)));
        assertEquals((short) -1,      BinaryUtils.toShortBe(BinaryUtils.toByteArrayBe((short) -1)));
        assertEquals((short) 0,       BinaryUtils.toShortBe(BinaryUtils.toByteArrayBe((short) 0)));
        assertEquals((short) 1,       BinaryUtils.toShortBe(BinaryUtils.toByteArrayBe((short) 1)));
    }

    /**
     * Tests {@link BinaryUtils#toShortBe(byte[])}.
     */
    @Test
    public void testToShortBe_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toShortBe(new byte[TestBinaryByteBlocks.SHORT_BYTES+1]));
    }

    /**
     * Tests {@link BinaryUtils#toShortBe(byte[])}.
     */
    @Test
    public void testToShortBe_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toShortBe(new byte[TestBinaryByteBlocks.SHORT_BYTES-1]));
    }

    /* ************************************** *
     * ***   Hex   ************************** *
     * ************************************** */

    /**
     * Tests {@link BinaryUtils#hexToShort(String)}.
     */
    @Test
    public void testHexToShort_ConvenienceMethod() {
        //Check values
        assertEquals(Short.MAX_VALUE, BinaryUtils.hexToShort(TestBinaryByteBlocks.HEX_SHORT_MAX_VAL_BYTES));
        assertEquals(Short.MIN_VALUE, BinaryUtils.hexToShort(TestBinaryByteBlocks.HEX_SHORT_MIN_VAL_BYTES));
        assertEquals((short) -1,      BinaryUtils.hexToShort(TestBinaryByteBlocks.HEX_SHORT_NEG_1_BYTES));
        assertEquals((short) 0,       BinaryUtils.hexToShort(TestBinaryByteBlocks.HEX_SHORT_0_BYTES));
        assertEquals((short) 1,       BinaryUtils.hexToShort(TestBinaryByteBlocks.HEX_SHORT_1_BYTES));

        //Check Null & Empty
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToShort((String) null));
        assertEquals((short) 0, BinaryUtils.hexToShort(""));
        assertEquals((short) 0, BinaryUtils.hexToShort(".-- .\t\t __  \t-._"));

        //Check full conversion cycle
        assertEquals(Short.MAX_VALUE, BinaryUtils.hexToShort(BinaryUtils.toHex(Short.MAX_VALUE)));
        assertEquals(Short.MIN_VALUE, BinaryUtils.hexToShort(BinaryUtils.toHex(Short.MIN_VALUE)));
        assertEquals((short) -1,      BinaryUtils.hexToShort(BinaryUtils.toHex((short) -1)));
        assertEquals((short) 0,       BinaryUtils.hexToShort(BinaryUtils.toHex((short) 0)));
        assertEquals((short) 1,       BinaryUtils.hexToShort(BinaryUtils.toHex((short) 1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToShort(String)}.
     */
    @Test
    public void testHexToShort_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToShort(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.SHORT_BYTES+1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToShort(String)}.
     */
    @Test
    public void testHexToShort_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToShort(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.SHORT_BYTES-1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToShortBe(String)}.
     */
    @Test
    public void testHexToShortBe_ConvenienceMethod() {
        //Check values
        assertEquals(Short.MAX_VALUE, BinaryUtils.hexToShortBe(TestBinaryByteBlocks.Be_HEX_SHORT_MAX_VAL_BYTES));
        assertEquals(Short.MIN_VALUE, BinaryUtils.hexToShortBe(TestBinaryByteBlocks.Be_HEX_SHORT_MIN_VAL_BYTES));
        assertEquals((short) -1,      BinaryUtils.hexToShortBe(TestBinaryByteBlocks.Be_HEX_SHORT_NEG_1_BYTES));
        assertEquals((short) 0,       BinaryUtils.hexToShortBe(TestBinaryByteBlocks.Be_HEX_SHORT_0_BYTES));
        assertEquals((short) 1,       BinaryUtils.hexToShortBe(TestBinaryByteBlocks.Be_HEX_SHORT_1_BYTES));

        //Check Null & Empty
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToShortBe((String) null));
        assertEquals((short) 0, BinaryUtils.hexToShortBe(""));
        assertEquals((short) 0, BinaryUtils.hexToShortBe(".-- .\t\t __  \t-._"));

        //Check full conversion cycle
        assertEquals(Short.MAX_VALUE, BinaryUtils.hexToShortBe(BinaryUtils.toHexBe(Short.MAX_VALUE)));
        assertEquals(Short.MIN_VALUE, BinaryUtils.hexToShortBe(BinaryUtils.toHexBe(Short.MIN_VALUE)));
        assertEquals((short) -1,      BinaryUtils.hexToShortBe(BinaryUtils.toHexBe((short) -1)));
        assertEquals((short) 0,       BinaryUtils.hexToShortBe(BinaryUtils.toHexBe((short) 0)));
        assertEquals((short) 1,       BinaryUtils.hexToShortBe(BinaryUtils.toHexBe((short) 1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToShortBe(String)}.
     */
    @Test
    public void testHexToShortBe_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToShortBe(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.SHORT_BYTES+1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToShortBe(String)}.
     */
    @Test
    public void testHexToShortBe_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToShortBe(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.SHORT_BYTES-1)));
    }

    /* ************************************** *
     * ************************************** *
     * ***             ********************** *
     * ***  End Short  ********************** *
     * ***             ********************** *
     * ************************************** *
     * ************************************** */

    /* ************************************** *
     * ************************************** *
     * ***       **************************** *
     * ***  Int  **************************** *
     * ***       **************************** *
     * ************************************** *
     * ************************************** */

    /**
     * Tests {@link BinaryUtils#toByteArray(int)}.
     */
    @Test
    public void testToByteArray_int() {
        //Check raw bytes
        assertArrayEquals(TestBinaryByteBlocks.INT_MAX_VAL_BYTES, BinaryUtils.toByteArray(Integer.MAX_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.INT_MIN_VAL_BYTES, BinaryUtils.toByteArray(Integer.MIN_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.INT_NEG_1_BYTES,   BinaryUtils.toByteArray((int) -1));
        assertArrayEquals(TestBinaryByteBlocks.INT_0_BYTES,       BinaryUtils.toByteArray((int) 0));
        assertArrayEquals(TestBinaryByteBlocks.INT_1_BYTES,       BinaryUtils.toByteArray((int) 1));

        //Check full conversion cycle
        assertEquals(Integer.MAX_VALUE, BinaryUtils.toInt(BinaryUtils.toByteArray(Integer.MAX_VALUE)));
        assertEquals(Integer.MIN_VALUE, BinaryUtils.toInt(BinaryUtils.toByteArray(Integer.MIN_VALUE)));
        assertEquals((int) -1,          BinaryUtils.toInt(BinaryUtils.toByteArray((int) -1)));
        assertEquals((int) 0,           BinaryUtils.toInt(BinaryUtils.toByteArray((int) 0)));
        assertEquals((int) 1,           BinaryUtils.toInt(BinaryUtils.toByteArray((int) 1)));
    }

    /**
     * Tests {@link BinaryUtils#toByteArrayBe(int)}.
     */
    @Test
    public void testToByteArrayBe_int() {
        //Check raw bytes
        assertArrayEquals(TestBinaryByteBlocks.Be_INT_MAX_VAL_BYTES, BinaryUtils.toByteArrayBe(Integer.MAX_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.Be_INT_MIN_VAL_BYTES, BinaryUtils.toByteArrayBe(Integer.MIN_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.Be_INT_NEG_1_BYTES,   BinaryUtils.toByteArrayBe((int) -1));
        assertArrayEquals(TestBinaryByteBlocks.Be_INT_0_BYTES,       BinaryUtils.toByteArrayBe((int) 0));
        assertArrayEquals(TestBinaryByteBlocks.Be_INT_1_BYTES,       BinaryUtils.toByteArrayBe((int) 1));

        //Check full conversion cycle
        assertEquals(Integer.MAX_VALUE, BinaryUtils.toIntBe(BinaryUtils.toByteArrayBe(Integer.MAX_VALUE)));
        assertEquals(Integer.MIN_VALUE, BinaryUtils.toIntBe(BinaryUtils.toByteArrayBe(Integer.MIN_VALUE)));
        assertEquals((int) -1,          BinaryUtils.toIntBe(BinaryUtils.toByteArrayBe((int) -1)));
        assertEquals((int) 0,           BinaryUtils.toIntBe(BinaryUtils.toByteArrayBe((int) 0)));
        assertEquals((int) 1,           BinaryUtils.toIntBe(BinaryUtils.toByteArrayBe((int) 1)));
    }

    /**
     * Tests {@link BinaryUtils#toInt(byte[])}.
     */
    @Test
    public void testToInt() {
        //Check values
        assertEquals(Integer.MAX_VALUE, BinaryUtils.toInt(TestBinaryByteBlocks.INT_MAX_VAL_BYTES));
        assertEquals(Integer.MIN_VALUE, BinaryUtils.toInt(TestBinaryByteBlocks.INT_MIN_VAL_BYTES));
        assertEquals((int) -1,          BinaryUtils.toInt(TestBinaryByteBlocks.INT_NEG_1_BYTES));
        assertEquals((int) 0,           BinaryUtils.toInt(TestBinaryByteBlocks.INT_0_BYTES));
        assertEquals((int) 1,           BinaryUtils.toInt(TestBinaryByteBlocks.INT_1_BYTES));

        //Check Null & Empty
        assertEquals((int) 0, BinaryUtils.toInt((byte[]) null));
        assertEquals((int) 0, BinaryUtils.toInt(new byte[0]));

        //Check full conversion cycle
        assertEquals(Integer.MAX_VALUE, BinaryUtils.toInt(BinaryUtils.toByteArray(Integer.MAX_VALUE)));
        assertEquals(Integer.MIN_VALUE, BinaryUtils.toInt(BinaryUtils.toByteArray(Integer.MIN_VALUE)));
        assertEquals((int) -1,          BinaryUtils.toInt(BinaryUtils.toByteArray((int) -1)));
        assertEquals((int) 0,           BinaryUtils.toInt(BinaryUtils.toByteArray((int) 0)));
        assertEquals((int) 1,           BinaryUtils.toInt(BinaryUtils.toByteArray((int) 1)));
    }

    /**
     * Tests {@link BinaryUtils#toInt(byte[])}.
     */
    @Test
    public void testToInt_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toInt(new byte[TestBinaryByteBlocks.INT_BYTES+1]));
    }

    /**
     * Tests {@link BinaryUtils#toInt(byte[])}.
     */
    @Test
    public void testToInt_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toInt(new byte[TestBinaryByteBlocks.INT_BYTES-1]));
    }

    /**
     * Tests {@link BinaryUtils#toIntBe(byte[])}.
     */
    @Test
    public void testToIntBe() {
        //Check values
        assertEquals(Integer.MAX_VALUE, BinaryUtils.toIntBe(TestBinaryByteBlocks.Be_INT_MAX_VAL_BYTES));
        assertEquals(Integer.MIN_VALUE, BinaryUtils.toIntBe(TestBinaryByteBlocks.Be_INT_MIN_VAL_BYTES));
        assertEquals((int) -1,          BinaryUtils.toIntBe(TestBinaryByteBlocks.Be_INT_NEG_1_BYTES));
        assertEquals((int) 0,           BinaryUtils.toIntBe(TestBinaryByteBlocks.Be_INT_0_BYTES));
        assertEquals((int) 1,           BinaryUtils.toIntBe(TestBinaryByteBlocks.Be_INT_1_BYTES));

        //Check Null & Empty
        assertEquals((int) 0, BinaryUtils.toIntBe((byte[]) null));
        assertEquals((int) 0, BinaryUtils.toIntBe(new byte[0]));

        //Check full conversion cycle
        assertEquals(Integer.MAX_VALUE, BinaryUtils.toIntBe(BinaryUtils.toByteArrayBe(Integer.MAX_VALUE)));
        assertEquals(Integer.MIN_VALUE, BinaryUtils.toIntBe(BinaryUtils.toByteArrayBe(Integer.MIN_VALUE)));
        assertEquals((int) -1,          BinaryUtils.toIntBe(BinaryUtils.toByteArrayBe((int) -1)));
        assertEquals((int) 0,           BinaryUtils.toIntBe(BinaryUtils.toByteArrayBe((int) 0)));
        assertEquals((int) 1,           BinaryUtils.toIntBe(BinaryUtils.toByteArrayBe((int) 1)));
    }

    /**
     * Tests {@link BinaryUtils#toIntBe(byte[])}.
     */
    @Test
    public void testToIntBe_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toIntBe(new byte[TestBinaryByteBlocks.INT_BYTES+1]));
    }

    /**
     * Tests {@link BinaryUtils#toIntBe(byte[])}.
     */
    @Test
    public void testToIntBe_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toIntBe(new byte[TestBinaryByteBlocks.INT_BYTES-1]));
    }

    /* ************************************** *
     * ***   Hex   ************************** *
     * ************************************** */

    /**
     * Tests {@link BinaryUtils#hexToInt(String)}.
     */
    @Test
    public void testHexToInt_ConvenienceMethod() {
        //Check values
        assertEquals(Integer.MAX_VALUE, BinaryUtils.hexToInt(TestBinaryByteBlocks.HEX_INT_MAX_VAL_BYTES));
        assertEquals(Integer.MIN_VALUE, BinaryUtils.hexToInt(TestBinaryByteBlocks.HEX_INT_MIN_VAL_BYTES));
        assertEquals((int) -1,          BinaryUtils.hexToInt(TestBinaryByteBlocks.HEX_INT_NEG_1_BYTES));
        assertEquals((int) 0,           BinaryUtils.hexToInt(TestBinaryByteBlocks.HEX_INT_0_BYTES));
        assertEquals((int) 1,           BinaryUtils.hexToInt(TestBinaryByteBlocks.HEX_INT_1_BYTES));

        //Check Null & Empty
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToInt((String) null));
        assertEquals((int) 0, BinaryUtils.hexToInt(""));
        assertEquals((int) 0, BinaryUtils.hexToInt(".-- .\t\t __  \t-._"));

        //Check full conversion cycle
        assertEquals(Integer.MAX_VALUE, BinaryUtils.hexToInt(BinaryUtils.toHex(Integer.MAX_VALUE)));
        assertEquals(Integer.MIN_VALUE, BinaryUtils.hexToInt(BinaryUtils.toHex(Integer.MIN_VALUE)));
        assertEquals((int) -1,          BinaryUtils.hexToInt(BinaryUtils.toHex((int) -1)));
        assertEquals((int) 0,           BinaryUtils.hexToInt(BinaryUtils.toHex((int) 0)));
        assertEquals((int) 1,           BinaryUtils.hexToInt(BinaryUtils.toHex((int) 1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToInt(String)}.
     */
    @Test
    public void testHexToInt_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToInt(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.INT_BYTES+1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToInt(String)}.
     */
    @Test
    public void testHexToInt_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToInt(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.INT_BYTES-1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToIntBe(String)}.
     */
    @Test
    public void testHexToIntBe_ConvenienceMethod() {
        //Check values
        assertEquals(Integer.MAX_VALUE, BinaryUtils.hexToIntBe(TestBinaryByteBlocks.Be_HEX_INT_MAX_VAL_BYTES));
        assertEquals(Integer.MIN_VALUE, BinaryUtils.hexToIntBe(TestBinaryByteBlocks.Be_HEX_INT_MIN_VAL_BYTES));
        assertEquals((int) -1,          BinaryUtils.hexToIntBe(TestBinaryByteBlocks.Be_HEX_INT_NEG_1_BYTES));
        assertEquals((int) 0,           BinaryUtils.hexToIntBe(TestBinaryByteBlocks.Be_HEX_INT_0_BYTES));
        assertEquals((int) 1,           BinaryUtils.hexToIntBe(TestBinaryByteBlocks.Be_HEX_INT_1_BYTES));

        //Check Null & Empty
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToIntBe((String) null));
        assertEquals((int) 0, BinaryUtils.hexToIntBe(""));
        assertEquals((int) 0, BinaryUtils.hexToIntBe(".-- .\t\t __  \t-._"));

        //Check full conversion cycle
        assertEquals(Integer.MAX_VALUE, BinaryUtils.hexToIntBe(BinaryUtils.toHexBe(Integer.MAX_VALUE)));
        assertEquals(Integer.MIN_VALUE, BinaryUtils.hexToIntBe(BinaryUtils.toHexBe(Integer.MIN_VALUE)));
        assertEquals((int) -1,          BinaryUtils.hexToIntBe(BinaryUtils.toHexBe((int) -1)));
        assertEquals((int) 0,           BinaryUtils.hexToIntBe(BinaryUtils.toHexBe((int) 0)));
        assertEquals((int) 1,           BinaryUtils.hexToIntBe(BinaryUtils.toHexBe((int) 1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToIntBe(String)}.
     */
    @Test
    public void testHexToIntBe_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToIntBe(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.INT_BYTES+1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToIntBe(String)}.
     */
    @Test
    public void testHexToIntBe_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToIntBe(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.INT_BYTES-1)));
    }

    /* ************************************** *
     * ************************************** *
     * ***           ************************ *
     * ***  End Int  ************************ *
     * ***           ************************ *
     * ************************************** *
     * ************************************** */

    /* ************************************** *
     * ************************************** *
     * ***        *************************** *
     * ***  Long  *************************** *
     * ***        *************************** *
     * ************************************** *
     * ************************************** */

    /**
     * Tests {@link BinaryUtils#toByteArray(long)}.
     */
    @Test
    public void testToByteArray_long() {
        //Check raw bytes
        assertArrayEquals(TestBinaryByteBlocks.LONG_MAX_VAL_BYTES, BinaryUtils.toByteArray(Long.MAX_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.LONG_MIN_VAL_BYTES, BinaryUtils.toByteArray(Long.MIN_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.LONG_NEG_1_BYTES,   BinaryUtils.toByteArray((long) -1));
        assertArrayEquals(TestBinaryByteBlocks.LONG_0_BYTES,       BinaryUtils.toByteArray((long) 0));
        assertArrayEquals(TestBinaryByteBlocks.LONG_1_BYTES,       BinaryUtils.toByteArray((long) 1));

        //Check full conversion cycle
        assertEquals(Long.MAX_VALUE, BinaryUtils.toLong(BinaryUtils.toByteArray(Long.MAX_VALUE)));
        assertEquals(Long.MIN_VALUE, BinaryUtils.toLong(BinaryUtils.toByteArray(Long.MIN_VALUE)));
        assertEquals((long) -1,      BinaryUtils.toLong(BinaryUtils.toByteArray((long) -1)));
        assertEquals((long) 0,       BinaryUtils.toLong(BinaryUtils.toByteArray((long) 0)));
        assertEquals((long) 1,       BinaryUtils.toLong(BinaryUtils.toByteArray((long) 1)));
    }

    /**
     * Tests {@link BinaryUtils#toByteArrayBe(long)}.
     */
    @Test
    public void testToByteArrayBe_long() {
        //Check raw bytes
        assertArrayEquals(TestBinaryByteBlocks.Be_LONG_MAX_VAL_BYTES, BinaryUtils.toByteArrayBe(Long.MAX_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.Be_LONG_MIN_VAL_BYTES, BinaryUtils.toByteArrayBe(Long.MIN_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.Be_LONG_NEG_1_BYTES,   BinaryUtils.toByteArrayBe((long) -1));
        assertArrayEquals(TestBinaryByteBlocks.Be_LONG_0_BYTES,       BinaryUtils.toByteArrayBe((long) 0));
        assertArrayEquals(TestBinaryByteBlocks.Be_LONG_1_BYTES,       BinaryUtils.toByteArrayBe((long) 1));

        //Check full conversion cycle
        assertEquals(Long.MAX_VALUE, BinaryUtils.toLongBe(BinaryUtils.toByteArrayBe(Long.MAX_VALUE)));
        assertEquals(Long.MIN_VALUE, BinaryUtils.toLongBe(BinaryUtils.toByteArrayBe(Long.MIN_VALUE)));
        assertEquals((long) -1,      BinaryUtils.toLongBe(BinaryUtils.toByteArrayBe((long) -1)));
        assertEquals((long) 0,       BinaryUtils.toLongBe(BinaryUtils.toByteArrayBe((long) 0)));
        assertEquals((long) 1,       BinaryUtils.toLongBe(BinaryUtils.toByteArrayBe((long) 1)));
    }

    /**
     * Tests {@link BinaryUtils#toLong(byte[])}.
     */
    @Test
    public void testToLong() {
        //Check values
        assertEquals(Long.MAX_VALUE, BinaryUtils.toLong(TestBinaryByteBlocks.LONG_MAX_VAL_BYTES));
        assertEquals(Long.MIN_VALUE, BinaryUtils.toLong(TestBinaryByteBlocks.LONG_MIN_VAL_BYTES));
        assertEquals((long) -1,      BinaryUtils.toLong(TestBinaryByteBlocks.LONG_NEG_1_BYTES));
        assertEquals((long) 0,       BinaryUtils.toLong(TestBinaryByteBlocks.LONG_0_BYTES));
        assertEquals((long) 1,       BinaryUtils.toLong(TestBinaryByteBlocks.LONG_1_BYTES));

        //Check Null & Empty
        assertEquals((long) 0, BinaryUtils.toLong((byte[]) null));
        assertEquals((long) 0, BinaryUtils.toLong(new byte[0]));

        //Check full conversion cycle
        assertEquals(Long.MAX_VALUE, BinaryUtils.toLong(BinaryUtils.toByteArray(Long.MAX_VALUE)));
        assertEquals(Long.MIN_VALUE, BinaryUtils.toLong(BinaryUtils.toByteArray(Long.MIN_VALUE)));
        assertEquals((long) -1,      BinaryUtils.toLong(BinaryUtils.toByteArray((long) -1)));
        assertEquals((long) 0,       BinaryUtils.toLong(BinaryUtils.toByteArray((long) 0)));
        assertEquals((long) 1,       BinaryUtils.toLong(BinaryUtils.toByteArray((long) 1)));
    }

    /**
     * Tests {@link BinaryUtils#toLong(byte[])}.
     */
    @Test
    public void testToLong_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toLong(new byte[TestBinaryByteBlocks.LONG_BYTES+1]));
    }

    /**
     * Tests {@link BinaryUtils#toLong(byte[])}.
     */
    @Test
    public void testToLong_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toLong(new byte[TestBinaryByteBlocks.LONG_BYTES-1]));
    }

    /**
     * Tests {@link BinaryUtils#toLongBe(byte[])}.
     */
    @Test
    public void testToLongBe() {
        //Check values
        assertEquals(Long.MAX_VALUE, BinaryUtils.toLongBe(TestBinaryByteBlocks.Be_LONG_MAX_VAL_BYTES));
        assertEquals(Long.MIN_VALUE, BinaryUtils.toLongBe(TestBinaryByteBlocks.Be_LONG_MIN_VAL_BYTES));
        assertEquals((long) -1,      BinaryUtils.toLongBe(TestBinaryByteBlocks.Be_LONG_NEG_1_BYTES));
        assertEquals((long) 0,       BinaryUtils.toLongBe(TestBinaryByteBlocks.Be_LONG_0_BYTES));
        assertEquals((long) 1,       BinaryUtils.toLongBe(TestBinaryByteBlocks.Be_LONG_1_BYTES));

        //Check Null & Empty
        assertEquals((long) 0, BinaryUtils.toLongBe((byte[]) null));
        assertEquals((long) 0, BinaryUtils.toLongBe(new byte[0]));

        //Check full conversion cycle
        assertEquals(Long.MAX_VALUE, BinaryUtils.toLongBe(BinaryUtils.toByteArrayBe(Long.MAX_VALUE)));
        assertEquals(Long.MIN_VALUE, BinaryUtils.toLongBe(BinaryUtils.toByteArrayBe(Long.MIN_VALUE)));
        assertEquals((long) -1,      BinaryUtils.toLongBe(BinaryUtils.toByteArrayBe((long) -1)));
        assertEquals((long) 0,       BinaryUtils.toLongBe(BinaryUtils.toByteArrayBe((long) 0)));
        assertEquals((long) 1,       BinaryUtils.toLongBe(BinaryUtils.toByteArrayBe((long) 1)));
    }

    /**
     * Tests {@link BinaryUtils#toLongBe(byte[])}.
     */
    @Test
    public void testToLongBe_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toLongBe(new byte[TestBinaryByteBlocks.LONG_BYTES+1]));
    }

    /**
     * Tests {@link BinaryUtils#toLongBe(byte[])}.
     */
    @Test
    public void testToLongBe_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toLongBe(new byte[TestBinaryByteBlocks.LONG_BYTES-1]));
    }

    /* ************************************** *
     * ***   Hex   ************************** *
     * ************************************** */

    /**
     * Tests {@link BinaryUtils#hexToLong(String)}.
     */
    @Test
    public void testHexToLong_ConvenienceMethod() {
        //Check values
        assertEquals(Long.MAX_VALUE, BinaryUtils.hexToLong(TestBinaryByteBlocks.HEX_LONG_MAX_VAL_BYTES));
        assertEquals(Long.MIN_VALUE, BinaryUtils.hexToLong(TestBinaryByteBlocks.HEX_LONG_MIN_VAL_BYTES));
        assertEquals((long) -1,      BinaryUtils.hexToLong(TestBinaryByteBlocks.HEX_LONG_NEG_1_BYTES));
        assertEquals((long) 0,       BinaryUtils.hexToLong(TestBinaryByteBlocks.HEX_LONG_0_BYTES));
        assertEquals((long) 1,       BinaryUtils.hexToLong(TestBinaryByteBlocks.HEX_LONG_1_BYTES));

        //Check Null & Empty
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToLong((String) null));
        assertEquals((long) 0, BinaryUtils.hexToLong(""));
        assertEquals((long) 0, BinaryUtils.hexToLong(".-- .\t\t __  \t-._"));

        //Check full conversion cycle
        assertEquals(Long.MAX_VALUE, BinaryUtils.hexToLong(BinaryUtils.toHex(Long.MAX_VALUE)));
        assertEquals(Long.MIN_VALUE, BinaryUtils.hexToLong(BinaryUtils.toHex(Long.MIN_VALUE)));
        assertEquals((long) -1,      BinaryUtils.hexToLong(BinaryUtils.toHex((long) -1)));
        assertEquals((long) 0,       BinaryUtils.hexToLong(BinaryUtils.toHex((long) 0)));
        assertEquals((long) 1,       BinaryUtils.hexToLong(BinaryUtils.toHex((long) 1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToLong(String)}.
     */
    @Test
    public void testHexToLong_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToLong(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.LONG_BYTES+1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToLong(String)}.
     */
    @Test
    public void testHexToLong_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToLong(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.LONG_BYTES-1)));
        ;
    }

    /**
     * Tests {@link BinaryUtils#hexToLongBe(String)}.
     */
    @Test
    public void testHexToLongBe_ConvenienceMethod() {
        //Check values
        assertEquals(Long.MAX_VALUE, BinaryUtils.hexToLongBe(TestBinaryByteBlocks.Be_HEX_LONG_MAX_VAL_BYTES));
        assertEquals(Long.MIN_VALUE, BinaryUtils.hexToLongBe(TestBinaryByteBlocks.Be_HEX_LONG_MIN_VAL_BYTES));
        assertEquals((long) -1,      BinaryUtils.hexToLongBe(TestBinaryByteBlocks.Be_HEX_LONG_NEG_1_BYTES));
        assertEquals((long) 0,       BinaryUtils.hexToLongBe(TestBinaryByteBlocks.Be_HEX_LONG_0_BYTES));
        assertEquals((long) 1,       BinaryUtils.hexToLongBe(TestBinaryByteBlocks.Be_HEX_LONG_1_BYTES));

        //Check Null & Empty
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToLongBe((String) null));
        assertEquals((long) 0, BinaryUtils.hexToLongBe(""));
        assertEquals((long) 0, BinaryUtils.hexToLongBe(".-- .\t\t __  \t-._"));

        //Check full conversion cycle
        assertEquals(Long.MAX_VALUE, BinaryUtils.hexToLongBe(BinaryUtils.toHexBe(Long.MAX_VALUE)));
        assertEquals(Long.MIN_VALUE, BinaryUtils.hexToLongBe(BinaryUtils.toHexBe(Long.MIN_VALUE)));
        assertEquals((long) -1,      BinaryUtils.hexToLongBe(BinaryUtils.toHexBe((long) -1)));
        assertEquals((long) 0,       BinaryUtils.hexToLongBe(BinaryUtils.toHexBe((long) 0)));
        assertEquals((long) 1,       BinaryUtils.hexToLongBe(BinaryUtils.toHexBe((long) 1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToLongBe(String)}.
     */
    @Test
    public void testHexToLongBe_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToLongBe(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.LONG_BYTES+1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToLongBe(String)}.
     */
    @Test
    public void testHexToLongBe_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToLongBe(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.LONG_BYTES-1)));
    }

    /* ************************************** *
     * ************************************** *
     * ***            *********************** *
     * ***  End Long  *********************** *
     * ***            *********************** *
     * ************************************** *
     * ************************************** */

    /* ************************************** *
     * ************************************** *
     * ***         ************************** *
     * ***  Float  ************************** *
     * ***         ************************** *
     * ************************************** *
     * ************************************** */

    /**
     * Tests {@link BinaryUtils#toByteArray(float)}.
     */
    @Test
    public void testToByteArray_float() {
        //Check raw bytes
        assertArrayEquals(TestBinaryByteBlocks.FLOAT_MAX_VAL_BYTES, BinaryUtils.toByteArray(Float.MAX_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.FLOAT_MIN_VAL_BYTES, BinaryUtils.toByteArray(Float.MIN_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.FLOAT_NEG_1_BYTES,   BinaryUtils.toByteArray((float) -1));
        assertArrayEquals(TestBinaryByteBlocks.FLOAT_0_BYTES,       BinaryUtils.toByteArray((float) 0));
        assertArrayEquals(TestBinaryByteBlocks.FLOAT_1_BYTES,       BinaryUtils.toByteArray((float) 1));

        //Check full conversion cycle
        assertEquals(Float.MAX_VALUE, BinaryUtils.toFloat(BinaryUtils.toByteArray(Float.MAX_VALUE)), 0);
        assertEquals(Float.MIN_VALUE, BinaryUtils.toFloat(BinaryUtils.toByteArray(Float.MIN_VALUE)), 0);
        assertEquals((float) -1,      BinaryUtils.toFloat(BinaryUtils.toByteArray((float) -1)), 0);
        assertEquals((float) 0,       BinaryUtils.toFloat(BinaryUtils.toByteArray((float) 0)), 0);
        assertEquals((float) 1,       BinaryUtils.toFloat(BinaryUtils.toByteArray((float) 1)), 0);
    }

    /**
     * Tests {@link BinaryUtils#toByteArrayBe(float)}.
     */
    @Test
    public void testToByteArrayBe_float() {
        //Check raw bytes
        assertArrayEquals(TestBinaryByteBlocks.Be_FLOAT_MAX_VAL_BYTES, BinaryUtils.toByteArrayBe(Float.MAX_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.Be_FLOAT_MIN_VAL_BYTES, BinaryUtils.toByteArrayBe(Float.MIN_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.Be_FLOAT_NEG_1_BYTES,   BinaryUtils.toByteArrayBe((float) -1));
        assertArrayEquals(TestBinaryByteBlocks.Be_FLOAT_0_BYTES,       BinaryUtils.toByteArrayBe((float) 0));
        assertArrayEquals(TestBinaryByteBlocks.Be_FLOAT_1_BYTES,       BinaryUtils.toByteArrayBe((float) 1));

        //Check full conversion cycle
        assertEquals(Float.MAX_VALUE, BinaryUtils.toFloatBe(BinaryUtils.toByteArrayBe(Float.MAX_VALUE)), 0);
        assertEquals(Float.MIN_VALUE, BinaryUtils.toFloatBe(BinaryUtils.toByteArrayBe(Float.MIN_VALUE)), 0);
        assertEquals((float) -1,      BinaryUtils.toFloatBe(BinaryUtils.toByteArrayBe((float) -1)), 0);
        assertEquals((float) 0,       BinaryUtils.toFloatBe(BinaryUtils.toByteArrayBe((float) 0)), 0);
        assertEquals((float) 1,       BinaryUtils.toFloatBe(BinaryUtils.toByteArrayBe((float) 1)), 0);
    }

    /**
     * Tests {@link BinaryUtils#toFloat(byte[])}.
     */
    @Test
    public void testToFloat() {
        //Check values
        assertEquals(Float.MAX_VALUE, BinaryUtils.toFloat(TestBinaryByteBlocks.FLOAT_MAX_VAL_BYTES), 0);
        assertEquals(Float.MIN_VALUE, BinaryUtils.toFloat(TestBinaryByteBlocks.FLOAT_MIN_VAL_BYTES), 0);
        assertEquals((float) -1,      BinaryUtils.toFloat(TestBinaryByteBlocks.FLOAT_NEG_1_BYTES), 0);
        assertEquals((float) 0,       BinaryUtils.toFloat(TestBinaryByteBlocks.FLOAT_0_BYTES), 0);
        assertEquals((float) 1,       BinaryUtils.toFloat(TestBinaryByteBlocks.FLOAT_1_BYTES), 0);

        //Check Null & Empty
        assertEquals((float) 0, BinaryUtils.toFloat((byte[]) null), 0);
        assertEquals((float) 0, BinaryUtils.toFloat(new byte[0]), 0);

        //Check full conversion cycle
        assertEquals(Float.MAX_VALUE, BinaryUtils.toFloat(BinaryUtils.toByteArray(Float.MAX_VALUE)), 0);
        assertEquals(Float.MIN_VALUE, BinaryUtils.toFloat(BinaryUtils.toByteArray(Float.MIN_VALUE)), 0);
        assertEquals((float) -1,      BinaryUtils.toFloat(BinaryUtils.toByteArray((float) -1)), 0);
        assertEquals((float) 0,       BinaryUtils.toFloat(BinaryUtils.toByteArray((float) 0)), 0);
        assertEquals((float) 1,       BinaryUtils.toFloat(BinaryUtils.toByteArray((float) 1)), 0);
    }

    /**
     * Tests {@link BinaryUtils#toFloat(byte[])}.
     */
    @Test
    public void testToFloat_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toFloat(new byte[TestBinaryByteBlocks.FLOAT_BYTES+1]));
    }

    /**
     * Tests {@link BinaryUtils#toFloat(byte[])}.
     */
    @Test
    public void testToFloat_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toFloat(new byte[TestBinaryByteBlocks.FLOAT_BYTES-1]));
    }

    /**
     * Tests {@link BinaryUtils#toFloatBe(byte[])}.
     */
    @Test
    public void testToFloatBe() {
        //Check values
        assertEquals(Float.MAX_VALUE, BinaryUtils.toFloatBe(TestBinaryByteBlocks.Be_FLOAT_MAX_VAL_BYTES), 0);
        assertEquals(Float.MIN_VALUE, BinaryUtils.toFloatBe(TestBinaryByteBlocks.Be_FLOAT_MIN_VAL_BYTES), 0);
        assertEquals((float) -1,      BinaryUtils.toFloatBe(TestBinaryByteBlocks.Be_FLOAT_NEG_1_BYTES), 0);
        assertEquals((float) 0,       BinaryUtils.toFloatBe(TestBinaryByteBlocks.Be_FLOAT_0_BYTES), 0);
        assertEquals((float) 1,       BinaryUtils.toFloatBe(TestBinaryByteBlocks.Be_FLOAT_1_BYTES), 0);

        //Check Null & Empty
        assertEquals((float) 0, BinaryUtils.toFloatBe((byte[]) null), 0);
        assertEquals((float) 0, BinaryUtils.toFloatBe(new byte[0]), 0);

        //Check full conversion cycle
        assertEquals(Float.MAX_VALUE, BinaryUtils.toFloatBe(BinaryUtils.toByteArrayBe(Float.MAX_VALUE)), 0);
        assertEquals(Float.MIN_VALUE, BinaryUtils.toFloatBe(BinaryUtils.toByteArrayBe(Float.MIN_VALUE)), 0);
        assertEquals((float) -1,      BinaryUtils.toFloatBe(BinaryUtils.toByteArrayBe((float) -1)), 0);
        assertEquals((float) 0,       BinaryUtils.toFloatBe(BinaryUtils.toByteArrayBe((float) 0)), 0);
        assertEquals((float) 1,       BinaryUtils.toFloatBe(BinaryUtils.toByteArrayBe((float) 1)), 0);
    }

    /**
     * Tests {@link BinaryUtils#toFloatBe(byte[])}.
     */
    @Test
    public void testToFloatBe_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toFloatBe(new byte[TestBinaryByteBlocks.FLOAT_BYTES+1]));
    }

    /**
     * Tests {@link BinaryUtils#toFloatBe(byte[])}.
     */
    @Test
    public void testToFloatBe_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toFloatBe(new byte[TestBinaryByteBlocks.FLOAT_BYTES-1]));
    }

    /* ************************************** *
     * ***   Hex   ************************** *
     * ************************************** */

    /**
     * Tests {@link BinaryUtils#hexToFloat(String)}.
     */
    @Test
    public void testHexToFloat_ConvenienceMethod() {
        //Check values
        assertEquals(Float.MAX_VALUE, BinaryUtils.hexToFloat(TestBinaryByteBlocks.HEX_FLOAT_MAX_VAL_BYTES), 0);
        assertEquals(Float.MIN_VALUE, BinaryUtils.hexToFloat(TestBinaryByteBlocks.HEX_FLOAT_MIN_VAL_BYTES), 0);
        assertEquals((float) -1,      BinaryUtils.hexToFloat(TestBinaryByteBlocks.HEX_FLOAT_NEG_1_BYTES), 0);
        assertEquals((float) 0,       BinaryUtils.hexToFloat(TestBinaryByteBlocks.HEX_FLOAT_0_BYTES), 0);
        assertEquals((float) 1,       BinaryUtils.hexToFloat(TestBinaryByteBlocks.HEX_FLOAT_1_BYTES), 0);

        //Check Null & Empty
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToFloat((String) null));
        assertEquals((float) 0, BinaryUtils.hexToFloat(""), 0);
        assertEquals((float) 0, BinaryUtils.hexToFloat(".-- .\t\t __  \t-._"), 0);

        //Check full conversion cycle
        assertEquals(Float.MAX_VALUE, BinaryUtils.hexToFloat(BinaryUtils.toHex(Float.MAX_VALUE)), 0);
        assertEquals(Float.MIN_VALUE, BinaryUtils.hexToFloat(BinaryUtils.toHex(Float.MIN_VALUE)), 0);
        assertEquals((float) -1,      BinaryUtils.hexToFloat(BinaryUtils.toHex((float) -1)), 0);
        assertEquals((float) 0,       BinaryUtils.hexToFloat(BinaryUtils.toHex((float) 0)), 0);
        assertEquals((float) 1,       BinaryUtils.hexToFloat(BinaryUtils.toHex((float) 1)), 0);
    }

    /**
     * Tests {@link BinaryUtils#hexToFloat(String)}.
     */
    @Test
    public void testHexToFloat_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToFloat(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.FLOAT_BYTES+1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToFloat(String)}.
     */
    @Test
    public void testHexToFloat_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToFloat(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.FLOAT_BYTES-1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToFloatBe(String)}.
     */
    @Test
    public void testHexToFloatBe_ConvenienceMethod() {
        //Check values
        assertEquals(Float.MAX_VALUE, BinaryUtils.hexToFloatBe(TestBinaryByteBlocks.Be_HEX_FLOAT_MAX_VAL_BYTES), 0);
        assertEquals(Float.MIN_VALUE, BinaryUtils.hexToFloatBe(TestBinaryByteBlocks.Be_HEX_FLOAT_MIN_VAL_BYTES), 0);
        assertEquals((float) -1,      BinaryUtils.hexToFloatBe(TestBinaryByteBlocks.Be_HEX_FLOAT_NEG_1_BYTES), 0);
        assertEquals((float) 0,       BinaryUtils.hexToFloatBe(TestBinaryByteBlocks.Be_HEX_FLOAT_0_BYTES), 0);
        assertEquals((float) 1,       BinaryUtils.hexToFloatBe(TestBinaryByteBlocks.Be_HEX_FLOAT_1_BYTES), 0);

        //Check Null & Empty
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToFloatBe((String) null));
        assertEquals((float) 0, BinaryUtils.hexToFloatBe(""), 0);
        assertEquals((float) 0, BinaryUtils.hexToFloatBe(".-- .\t\t __  \t-._"), 0);

        //Check full conversion cycle
        assertEquals(Float.MAX_VALUE, BinaryUtils.hexToFloatBe(BinaryUtils.toHexBe(Float.MAX_VALUE)), 0);
        assertEquals(Float.MIN_VALUE, BinaryUtils.hexToFloatBe(BinaryUtils.toHexBe(Float.MIN_VALUE)), 0);
        assertEquals((float) -1,      BinaryUtils.hexToFloatBe(BinaryUtils.toHexBe((float) -1)), 0);
        assertEquals((float) 0,       BinaryUtils.hexToFloatBe(BinaryUtils.toHexBe((float) 0)), 0);
        assertEquals((float) 1,       BinaryUtils.hexToFloatBe(BinaryUtils.toHexBe((float) 1)), 0);
    }

    /**
     * Tests {@link BinaryUtils#hexToFloatBe(String)}.
     */
    @Test
    public void testHexToFloatBe_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToFloatBe(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.FLOAT_BYTES+1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToFloatBe(String)}.
     */
    @Test
    public void testHexToFloatBe_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToFloatBe(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.FLOAT_BYTES-1)));
    }

    /* ************************************** *
     * ************************************** *
     * ***             ********************** *
     * ***  End Float  ********************** *
     * ***             ********************** *
     * ************************************** *
     * ************************************** */

    /* ************************************** *
     * ************************************** *
     * ***          ************************* *
     * ***  Double  ************************* *
     * ***          ************************* *
     * ************************************** *
     * ************************************** */

    /**
     * Tests {@link BinaryUtils#toByteArray(double)}.
     */
    @Test
    public void testToByteArray_double() {
        //Check raw bytes
        assertArrayEquals(TestBinaryByteBlocks.DOUBLE_MAX_VAL_BYTES, BinaryUtils.toByteArray(Double.MAX_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.DOUBLE_MIN_VAL_BYTES, BinaryUtils.toByteArray(Double.MIN_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.DOUBLE_NEG_1_BYTES,   BinaryUtils.toByteArray((double) -1));
        assertArrayEquals(TestBinaryByteBlocks.DOUBLE_0_BYTES,       BinaryUtils.toByteArray((double) 0));
        assertArrayEquals(TestBinaryByteBlocks.DOUBLE_1_BYTES,       BinaryUtils.toByteArray((double) 1));

        //Check full conversion cycle
        assertEquals(Double.MAX_VALUE, BinaryUtils.toDouble(BinaryUtils.toByteArray(Double.MAX_VALUE)), 0);
        assertEquals(Double.MIN_VALUE, BinaryUtils.toDouble(BinaryUtils.toByteArray(Double.MIN_VALUE)), 0);
        assertEquals((double) -1,      BinaryUtils.toDouble(BinaryUtils.toByteArray((double) -1)), 0);
        assertEquals((double) 0,       BinaryUtils.toDouble(BinaryUtils.toByteArray((double) 0)), 0);
        assertEquals((double) 1,       BinaryUtils.toDouble(BinaryUtils.toByteArray((double) 1)), 0);
    }

    /**
     * Tests {@link BinaryUtils#toByteArrayBe(double)}.
     */
    @Test
    public void testToByteArrayBe_double() {
        //Check raw bytes
        assertArrayEquals(TestBinaryByteBlocks.Be_DOUBLE_MAX_VAL_BYTES, BinaryUtils.toByteArrayBe(Double.MAX_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.Be_DOUBLE_MIN_VAL_BYTES, BinaryUtils.toByteArrayBe(Double.MIN_VALUE));
        assertArrayEquals(TestBinaryByteBlocks.Be_DOUBLE_NEG_1_BYTES,   BinaryUtils.toByteArrayBe((double) -1));
        assertArrayEquals(TestBinaryByteBlocks.Be_DOUBLE_0_BYTES,       BinaryUtils.toByteArrayBe((double) 0));
        assertArrayEquals(TestBinaryByteBlocks.Be_DOUBLE_1_BYTES,       BinaryUtils.toByteArrayBe((double) 1));

        //Check full conversion cycle
        assertEquals(Double.MAX_VALUE, BinaryUtils.toDoubleBe(BinaryUtils.toByteArrayBe(Double.MAX_VALUE)), 0);
        assertEquals(Double.MIN_VALUE, BinaryUtils.toDoubleBe(BinaryUtils.toByteArrayBe(Double.MIN_VALUE)), 0);
        assertEquals((double) -1,      BinaryUtils.toDoubleBe(BinaryUtils.toByteArrayBe((double) -1)), 0);
        assertEquals((double) 0,       BinaryUtils.toDoubleBe(BinaryUtils.toByteArrayBe((double) 0)), 0);
        assertEquals((double) 1,       BinaryUtils.toDoubleBe(BinaryUtils.toByteArrayBe((double) 1)), 0);
    }

    /**
     * Tests {@link BinaryUtils#toDouble(byte[])}.
     */
    @Test
    public void testToDouble() {
        //Check values
        assertEquals(Double.MAX_VALUE, BinaryUtils.toDouble(TestBinaryByteBlocks.DOUBLE_MAX_VAL_BYTES), 0);
        assertEquals(Double.MIN_VALUE, BinaryUtils.toDouble(TestBinaryByteBlocks.DOUBLE_MIN_VAL_BYTES), 0);
        assertEquals((double) -1,      BinaryUtils.toDouble(TestBinaryByteBlocks.DOUBLE_NEG_1_BYTES), 0);
        assertEquals((double) 0,       BinaryUtils.toDouble(TestBinaryByteBlocks.DOUBLE_0_BYTES), 0);
        assertEquals((double) 1,       BinaryUtils.toDouble(TestBinaryByteBlocks.DOUBLE_1_BYTES), 0);

        //Check Null & Empty
        assertEquals((double) 0, BinaryUtils.toDouble((byte[]) null), 0);
        assertEquals((double) 0, BinaryUtils.toDouble(new byte[0]), 0);

        //Check full conversion cycle
        assertEquals(Double.MAX_VALUE, BinaryUtils.toDouble(BinaryUtils.toByteArray(Double.MAX_VALUE)), 0);
        assertEquals(Double.MIN_VALUE, BinaryUtils.toDouble(BinaryUtils.toByteArray(Double.MIN_VALUE)), 0);
        assertEquals((double) -1,      BinaryUtils.toDouble(BinaryUtils.toByteArray((double) -1)), 0);
        assertEquals((double) 0,       BinaryUtils.toDouble(BinaryUtils.toByteArray((double) 0)), 0);
        assertEquals((double) 1,       BinaryUtils.toDouble(BinaryUtils.toByteArray((double) 1)), 0);
    }

    /**
     * Tests {@link BinaryUtils#toDouble(byte[])}.
     */
    @Test
    public void testToDouble_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toDouble(new byte[TestBinaryByteBlocks.DOUBLE_BYTES+1]));
    }

    /**
     * Tests {@link BinaryUtils#toDouble(byte[])}.
     */
    @Test
    public void testToDouble_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toDouble(new byte[TestBinaryByteBlocks.DOUBLE_BYTES-1]));
    }

    /**
     * Tests {@link BinaryUtils#toDoubleBe(byte[])}.
     */
    @Test
    public void testToDoubleBe() {
        //Check values
        assertEquals(Double.MAX_VALUE, BinaryUtils.toDoubleBe(TestBinaryByteBlocks.Be_DOUBLE_MAX_VAL_BYTES), 0);
        assertEquals(Double.MIN_VALUE, BinaryUtils.toDoubleBe(TestBinaryByteBlocks.Be_DOUBLE_MIN_VAL_BYTES), 0);
        assertEquals((double) -1,      BinaryUtils.toDoubleBe(TestBinaryByteBlocks.Be_DOUBLE_NEG_1_BYTES), 0);
        assertEquals((double) 0,       BinaryUtils.toDoubleBe(TestBinaryByteBlocks.Be_DOUBLE_0_BYTES), 0);
        assertEquals((double) 1,       BinaryUtils.toDoubleBe(TestBinaryByteBlocks.Be_DOUBLE_1_BYTES), 0);

        //Check Null & Empty
        assertEquals((double) 0, BinaryUtils.toDoubleBe((byte[]) null), 0);
        assertEquals((double) 0, BinaryUtils.toDoubleBe(new byte[0]), 0);

        //Check full conversion cycle
        assertEquals(Double.MAX_VALUE, BinaryUtils.toDoubleBe(BinaryUtils.toByteArrayBe(Double.MAX_VALUE)), 0);
        assertEquals(Double.MIN_VALUE, BinaryUtils.toDoubleBe(BinaryUtils.toByteArrayBe(Double.MIN_VALUE)), 0);
        assertEquals((double) -1,      BinaryUtils.toDoubleBe(BinaryUtils.toByteArrayBe((double) -1)), 0);
        assertEquals((double) 0,       BinaryUtils.toDoubleBe(BinaryUtils.toByteArrayBe((double) 0)), 0);
        assertEquals((double) 1,       BinaryUtils.toDoubleBe(BinaryUtils.toByteArrayBe((double) 1)), 0);
    }

    /**
     * Tests {@link BinaryUtils#toDoubleBe(byte[])}.
     */
    @Test
    public void testToDoubleBe_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toDoubleBe(new byte[TestBinaryByteBlocks.DOUBLE_BYTES+1]));
    }

    /**
     * Tests {@link BinaryUtils#toDoubleBe(byte[])}.
     */
    @Test
    public void testToDoubleBe_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.toDoubleBe(new byte[TestBinaryByteBlocks.DOUBLE_BYTES-1]));
    }

    /* ************************************** *
     * ***   Hex   ************************** *
     * ************************************** */

    /**
     * Tests {@link BinaryUtils#hexToDouble(String)}.
     */
    @Test
    public void testHexToDouble_ConvenienceMethod() {
        //Check values
        assertEquals(Double.MAX_VALUE, BinaryUtils.hexToDouble(TestBinaryByteBlocks.HEX_DOUBLE_MAX_VAL_BYTES), 0);
        assertEquals(Double.MIN_VALUE, BinaryUtils.hexToDouble(TestBinaryByteBlocks.HEX_DOUBLE_MIN_VAL_BYTES), 0);
        assertEquals((double) -1,      BinaryUtils.hexToDouble(TestBinaryByteBlocks.HEX_DOUBLE_NEG_1_BYTES), 0);
        assertEquals((double) 0,       BinaryUtils.hexToDouble(TestBinaryByteBlocks.HEX_DOUBLE_0_BYTES), 0);
        assertEquals((double) 1,       BinaryUtils.hexToDouble(TestBinaryByteBlocks.HEX_DOUBLE_1_BYTES), 0);

        //Check Null & Empty
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToDouble((String) null));
        assertEquals((double) 0, BinaryUtils.hexToDouble(""), 0);
        assertEquals((double) 0, BinaryUtils.hexToDouble(".-- .\t\t __  \t-._"), 0);

        //Check full conversion cycle
        assertEquals(Double.MAX_VALUE, BinaryUtils.hexToDouble(BinaryUtils.toHex(Double.MAX_VALUE)), 0);
        assertEquals(Double.MIN_VALUE, BinaryUtils.hexToDouble(BinaryUtils.toHex(Double.MIN_VALUE)), 0);
        assertEquals((double) -1,      BinaryUtils.hexToDouble(BinaryUtils.toHex((double) -1)), 0);
        assertEquals((double) 0,       BinaryUtils.hexToDouble(BinaryUtils.toHex((double) 0)), 0);
        assertEquals((double) 1,       BinaryUtils.hexToDouble(BinaryUtils.toHex((double) 1)), 0);
    }

    /**
     * Tests {@link BinaryUtils#hexToDouble(String)}.
     */
    @Test
    public void testHexToDouble_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToDouble(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.DOUBLE_BYTES+1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToDouble(String)}.
     */
    @Test
    public void testHexToDouble_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToDouble(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.DOUBLE_BYTES-1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToDoubleBe(String)}.
     */
    @Test
    public void testHexToDoubleBe_ConvenienceMethod() {
        //Check values
        assertEquals(Double.MAX_VALUE, BinaryUtils.hexToDoubleBe(TestBinaryByteBlocks.Be_HEX_DOUBLE_MAX_VAL_BYTES), 0);
        assertEquals(Double.MIN_VALUE, BinaryUtils.hexToDoubleBe(TestBinaryByteBlocks.Be_HEX_DOUBLE_MIN_VAL_BYTES), 0);
        assertEquals((double) -1,      BinaryUtils.hexToDoubleBe(TestBinaryByteBlocks.Be_HEX_DOUBLE_NEG_1_BYTES), 0);
        assertEquals((double) 0,       BinaryUtils.hexToDoubleBe(TestBinaryByteBlocks.Be_HEX_DOUBLE_0_BYTES), 0);
        assertEquals((double) 1,       BinaryUtils.hexToDoubleBe(TestBinaryByteBlocks.Be_HEX_DOUBLE_1_BYTES), 0);

        //Check Null & Empty
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToDoubleBe((String) null));
        assertEquals((double) 0, BinaryUtils.hexToDoubleBe(""), 0);
        assertEquals((double) 0, BinaryUtils.hexToDoubleBe(".-- .\t\t __  \t-._"), 0);

        //Check full conversion cycle
        assertEquals(Double.MAX_VALUE, BinaryUtils.hexToDoubleBe(BinaryUtils.toHexBe(Double.MAX_VALUE)), 0);
        assertEquals(Double.MIN_VALUE, BinaryUtils.hexToDoubleBe(BinaryUtils.toHexBe(Double.MIN_VALUE)), 0);
        assertEquals((double) -1,      BinaryUtils.hexToDoubleBe(BinaryUtils.toHexBe((double) -1)), 0);
        assertEquals((double) 0,       BinaryUtils.hexToDoubleBe(BinaryUtils.toHexBe((double) 0)), 0);
        assertEquals((double) 1,       BinaryUtils.hexToDoubleBe(BinaryUtils.toHexBe((double) 1)), 0);
    }

    /**
     * Tests {@link BinaryUtils#hexToDoubleBe(String)}.
     */
    @Test
    public void testHexToDoubleBe_tooLong() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToDoubleBe(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.DOUBLE_BYTES+1)));
    }

    /**
     * Tests {@link BinaryUtils#hexToDoubleBe(String)}.
     */
    @Test
    public void testHexToDoubleBe_tooSmall() {
        assertThrows(IllegalArgumentException.class, () -> BinaryUtils.hexToDoubleBe(TestBinaryByteBlocks.getNumHexDigits(TestBinaryByteBlocks.DOUBLE_BYTES-1)));
    }

    /* ************************************** *
     * ************************************** *
     * ***              ********************* *
     * ***  End Double  ********************* *
     * ***              ********************* *
     * ************************************** *
     * ************************************** */

    /**
     * Tests {@link BinaryUtils#toHex(byte)}.
     */
    @Test
    public void testToHex_byte() {
        for (byte x=Byte.MIN_VALUE; x<Byte.MAX_VALUE; x++) {
            assertEquals(TestBinaryByteBlocks.DOUBLE_HEX_LU[x & 0xFF], BinaryUtils.toHex(x));
        }
    }

    /**
     * Tests {@link BinaryUtils#toHexRaw(byte[])}.
     */
    @Test
    public void testToHexRaw() {
        //Check values
        assertEquals(_getHexOctets(TestBinaryByteBlocks.LONG_MAX_VAL_BYTES),
                BinaryUtils.toHexRaw(TestBinaryByteBlocks.LONG_MAX_VAL_BYTES));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.LONG_MIN_VAL_BYTES),
                BinaryUtils.toHexRaw(TestBinaryByteBlocks.LONG_MIN_VAL_BYTES));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.LONG_NEG_1_BYTES),
                BinaryUtils.toHexRaw(TestBinaryByteBlocks.LONG_NEG_1_BYTES));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.LONG_0_BYTES),
                BinaryUtils.toHexRaw(TestBinaryByteBlocks.LONG_0_BYTES));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.LONG_1_BYTES),
                BinaryUtils.toHexRaw(TestBinaryByteBlocks.LONG_1_BYTES));

        //Check Null & Empty
        assertEquals(null, BinaryUtils.toHexRaw((byte[]) null));
        assertEquals("", BinaryUtils.toHexRaw(new byte[0]));
    }

    private String _getHexOctets(byte[] chunks) {
        StringBuilder builder = new StringBuilder();

        boolean isFirstIteration = true;
        for (int x=0; x<chunks.length; x++) {
            if (isFirstIteration) {
                isFirstIteration = false;
            } else {
                builder.append(BinaryUtils.STANDARD_DELIMITER);
            }
            builder.append(TestBinaryByteBlocks.DOUBLE_HEX_LU[chunks[x] & 0xFF]);
        }
        return builder.toString();
    }

    @Test
    public void testToHex_short() {
        assertEquals(_getHexOctets(TestBinaryByteBlocks.SHORT_MAX_VAL_BYTES), BinaryUtils.toHex(Short.MAX_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.SHORT_MIN_VAL_BYTES), BinaryUtils.toHex(Short.MIN_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.SHORT_NEG_1_BYTES),   BinaryUtils.toHex((short) -1));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.SHORT_0_BYTES),       BinaryUtils.toHex((short) 0));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.SHORT_1_BYTES),       BinaryUtils.toHex((short) 1));
    }

    @Test
    public void testToHex_shortBe() {
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_SHORT_MAX_VAL_BYTES), BinaryUtils.toHexBe(Short.MAX_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_SHORT_MIN_VAL_BYTES), BinaryUtils.toHexBe(Short.MIN_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_SHORT_NEG_1_BYTES),   BinaryUtils.toHexBe((short) -1));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_SHORT_0_BYTES),       BinaryUtils.toHexBe((short) 0));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_SHORT_1_BYTES),       BinaryUtils.toHexBe((short) 1));
    }

    @Test
    public void testToHex_int() {
        assertEquals(_getHexOctets(TestBinaryByteBlocks.INT_MAX_VAL_BYTES), BinaryUtils.toHex(Integer.MAX_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.INT_MIN_VAL_BYTES), BinaryUtils.toHex(Integer.MIN_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.INT_NEG_1_BYTES),   BinaryUtils.toHex((int) -1));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.INT_0_BYTES),       BinaryUtils.toHex((int) 0));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.INT_1_BYTES),       BinaryUtils.toHex((int) 1));
    }

    @Test
    public void testToHex_intBe() {
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_INT_MAX_VAL_BYTES), BinaryUtils.toHexBe(Integer.MAX_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_INT_MIN_VAL_BYTES), BinaryUtils.toHexBe(Integer.MIN_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_INT_NEG_1_BYTES),   BinaryUtils.toHexBe((int) -1));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_INT_0_BYTES),       BinaryUtils.toHexBe((int) 0));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_INT_1_BYTES),       BinaryUtils.toHexBe((int) 1));
    }

    @Test
    public void testToHex_long() {
        assertEquals(_getHexOctets(TestBinaryByteBlocks.LONG_MAX_VAL_BYTES), BinaryUtils.toHex(Long.MAX_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.LONG_MIN_VAL_BYTES), BinaryUtils.toHex(Long.MIN_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.LONG_NEG_1_BYTES),   BinaryUtils.toHex((long) -1));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.LONG_0_BYTES),       BinaryUtils.toHex((long) 0));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.LONG_1_BYTES),       BinaryUtils.toHex((long) 1));
    }

    @Test
    public void testToHex_longBe() {
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_LONG_MAX_VAL_BYTES), BinaryUtils.toHexBe(Long.MAX_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_LONG_MIN_VAL_BYTES), BinaryUtils.toHexBe(Long.MIN_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_LONG_NEG_1_BYTES),   BinaryUtils.toHexBe((long) -1));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_LONG_0_BYTES),       BinaryUtils.toHexBe((long) 0));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_LONG_1_BYTES),       BinaryUtils.toHexBe((long) 1));
    }

    @Test
    public void testToHex_float() {
        assertEquals(_getHexOctets(TestBinaryByteBlocks.FLOAT_MAX_VAL_BYTES), BinaryUtils.toHex(Float.MAX_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.FLOAT_MIN_VAL_BYTES), BinaryUtils.toHex(Float.MIN_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.FLOAT_NEG_1_BYTES),   BinaryUtils.toHex((float) -1));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.FLOAT_0_BYTES),       BinaryUtils.toHex((float) 0));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.FLOAT_1_BYTES),       BinaryUtils.toHex((float) 1));
    }

    @Test
    public void testToHex_floatBe() {
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_FLOAT_MAX_VAL_BYTES), BinaryUtils.toHexBe(Float.MAX_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_FLOAT_MIN_VAL_BYTES), BinaryUtils.toHexBe(Float.MIN_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_FLOAT_NEG_1_BYTES),   BinaryUtils.toHexBe((float) -1));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_FLOAT_0_BYTES),       BinaryUtils.toHexBe((float) 0));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_FLOAT_1_BYTES),       BinaryUtils.toHexBe((float) 1));
    }

    @Test
    public void testToHex_double() {
        assertEquals(_getHexOctets(TestBinaryByteBlocks.DOUBLE_MAX_VAL_BYTES), BinaryUtils.toHex(Double.MAX_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.DOUBLE_MIN_VAL_BYTES), BinaryUtils.toHex(Double.MIN_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.DOUBLE_NEG_1_BYTES),   BinaryUtils.toHex((double) -1));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.DOUBLE_0_BYTES),       BinaryUtils.toHex((double) 0));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.DOUBLE_1_BYTES),       BinaryUtils.toHex((double) 1));
    }

    @Test
    public void testToHex_doubleBe() {
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_DOUBLE_MAX_VAL_BYTES), BinaryUtils.toHexBe(Double.MAX_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_DOUBLE_MIN_VAL_BYTES), BinaryUtils.toHexBe(Double.MIN_VALUE));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_DOUBLE_NEG_1_BYTES),   BinaryUtils.toHexBe((double) -1));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_DOUBLE_0_BYTES),       BinaryUtils.toHexBe((double) 0));
        assertEquals(_getHexOctets(TestBinaryByteBlocks.Be_DOUBLE_1_BYTES),       BinaryUtils.toHexBe((double) 1));
    }

    public static final class TestBinaryByteBlocks {
        public static String getNumHexDigits(int numHexDigits) {
            return getNumHexDigits(numHexDigits, 'F');
        }
        public static String getNumHexDigits(int numHexDigits, char hexDigit) {
            StringBuilder builder = new StringBuilder();
            for (int x=0; x<numHexDigits; x++) {
                builder.append(hexDigit);
            }
            return builder.toString();
        }

        public static final int SHORT_BYTES  = 2;
        public static final int INT_BYTES    = 4;
        public static final int LONG_BYTES   = 8;
        public static final int FLOAT_BYTES  = 4;
        public static final int DOUBLE_BYTES = 8;

        public static final char[] SINGLE_HEX_LU = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        public static final String[] DOUBLE_HEX_LU;
        public static final Map<String, Byte> DOUBLE_HEX_REV_LU;
        static {
            //Init Forward Lookup
            DOUBLE_HEX_LU = new String[256];
            int index = 0;
            for (int x=0; x<16; x++) {
                for (int y=0; y<16; y++) {
                    DOUBLE_HEX_LU[index++] = "" + SINGLE_HEX_LU[x] + SINGLE_HEX_LU[y];
                }
            }

            //Init Reverse Lookup
            DOUBLE_HEX_REV_LU = new HashMap<String, Byte>(256);
            for (int x=0; x<256; x++) {
                DOUBLE_HEX_REV_LU.put(DOUBLE_HEX_LU[x], (byte) x);
            }
        }

        //Short
        public static final byte[]    SHORT_MAX_VAL_BYTES = new byte[] {(byte) 0xFF, (byte) 0x7F};
        public static final byte[] Be_SHORT_MAX_VAL_BYTES = new byte[] {(byte) 0x7F, (byte) 0xFF};
        public static final byte[]    SHORT_MIN_VAL_BYTES = new byte[] {(byte) 0x00, (byte) 0x80};
        public static final byte[] Be_SHORT_MIN_VAL_BYTES = new byte[] {(byte) 0x80, (byte) 0x00};
        public static final byte[]    SHORT_NEG_1_BYTES   = new byte[] {(byte) 0xFF, (byte) 0xFF};
        public static final byte[] Be_SHORT_NEG_1_BYTES   = new byte[] {(byte) 0xFF, (byte) 0xFF};
        public static final byte[]    SHORT_0_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00};
        public static final byte[] Be_SHORT_0_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00};
        public static final byte[]    SHORT_1_BYTES       = new byte[] {(byte) 0x01, (byte) 0x00};
        public static final byte[] Be_SHORT_1_BYTES       = new byte[] {(byte) 0x00, (byte) 0x01};
        public static final String    HEX_SHORT_MAX_VAL_BYTES = "FF7F";
        public static final String Be_HEX_SHORT_MAX_VAL_BYTES = "7FFF";
        public static final String    HEX_SHORT_MIN_VAL_BYTES = "0080";
        public static final String Be_HEX_SHORT_MIN_VAL_BYTES = "8000";
        public static final String    HEX_SHORT_NEG_1_BYTES   = "FFFF";
        public static final String Be_HEX_SHORT_NEG_1_BYTES   = "FFFF";
        public static final String    HEX_SHORT_0_BYTES       = "0000";
        public static final String Be_HEX_SHORT_0_BYTES       = "0000";
        public static final String    HEX_SHORT_1_BYTES       = "0100";
        public static final String Be_HEX_SHORT_1_BYTES       = "0001";

        //Int
        public static final byte[]    INT_MAX_VAL_BYTES = new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x7F};
        public static final byte[] Be_INT_MAX_VAL_BYTES = new byte[] {(byte) 0x7F, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        public static final byte[]    INT_MIN_VAL_BYTES = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x80};
        public static final byte[] Be_INT_MIN_VAL_BYTES = new byte[] {(byte) 0x80, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[]    INT_NEG_1_BYTES   = new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        public static final byte[] Be_INT_NEG_1_BYTES   = new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        public static final byte[]    INT_0_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[] Be_INT_0_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[]    INT_1_BYTES       = new byte[] {(byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[] Be_INT_1_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01};
        public static final String    HEX_INT_MAX_VAL_BYTES = "FFFFFF7F";
        public static final String Be_HEX_INT_MAX_VAL_BYTES = "7FFFFFFF";
        public static final String    HEX_INT_MIN_VAL_BYTES = "00000080";
        public static final String Be_HEX_INT_MIN_VAL_BYTES = "80000000";
        public static final String    HEX_INT_NEG_1_BYTES   = "FFFFFFFF";
        public static final String Be_HEX_INT_NEG_1_BYTES   = "FFFFFFFF";
        public static final String    HEX_INT_0_BYTES       = "00000000";
        public static final String Be_HEX_INT_0_BYTES       = "00000000";
        public static final String    HEX_INT_1_BYTES       = "01000000";
        public static final String Be_HEX_INT_1_BYTES       = "00000001";

        //Long
        public static final byte[]    LONG_MAX_VAL_BYTES = new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x7F};
        public static final byte[] Be_LONG_MAX_VAL_BYTES = new byte[] {(byte) 0x7F, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        public static final byte[]    LONG_MIN_VAL_BYTES = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x80};
        public static final byte[] Be_LONG_MIN_VAL_BYTES = new byte[] {(byte) 0x80, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[]    LONG_NEG_1_BYTES   = new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        public static final byte[] Be_LONG_NEG_1_BYTES   = new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        public static final byte[]    LONG_0_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[] Be_LONG_0_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[]    LONG_1_BYTES       = new byte[] {(byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[] Be_LONG_1_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01};
        public static final String    HEX_LONG_MAX_VAL_BYTES = "FFFFFFFFFFFFFF7F";
        public static final String Be_HEX_LONG_MAX_VAL_BYTES = "7FFFFFFFFFFFFFFF";
        public static final String    HEX_LONG_MIN_VAL_BYTES = "0000000000000080";
        public static final String Be_HEX_LONG_MIN_VAL_BYTES = "8000000000000000";
        public static final String    HEX_LONG_NEG_1_BYTES   = "FFFFFFFFFFFFFFFF";
        public static final String Be_HEX_LONG_NEG_1_BYTES   = "FFFFFFFFFFFFFFFF";
        public static final String    HEX_LONG_0_BYTES       = "0000000000000000";
        public static final String Be_HEX_LONG_0_BYTES       = "0000000000000000";
        public static final String    HEX_LONG_1_BYTES       = "0100000000000000";
        public static final String Be_HEX_LONG_1_BYTES       = "0000000000000001";

        //Float
        public static final byte[]    FLOAT_MAX_VAL_BYTES = new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0x7F, (byte) 0x7F};
        public static final byte[] Be_FLOAT_MAX_VAL_BYTES = new byte[] {(byte) 0x7F, (byte) 0x7F, (byte) 0xFF, (byte) 0xFF};
        public static final byte[]    FLOAT_MIN_VAL_BYTES = new byte[] {(byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[] Be_FLOAT_MIN_VAL_BYTES = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01};
        public static final byte[]    FLOAT_NEG_1_BYTES   = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x80, (byte) 0xBF};
        public static final byte[] Be_FLOAT_NEG_1_BYTES   = new byte[] {(byte) 0xBF, (byte) 0x80, (byte) 0x00, (byte) 0x00};
        public static final byte[]    FLOAT_0_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[] Be_FLOAT_0_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[]    FLOAT_1_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x80, (byte) 0x3F};
        public static final byte[] Be_FLOAT_1_BYTES       = new byte[] {(byte) 0x3F, (byte) 0x80, (byte) 0x00, (byte) 0x00};
        public static final String    HEX_FLOAT_MAX_VAL_BYTES = "FFFF7F7F";
        public static final String Be_HEX_FLOAT_MAX_VAL_BYTES = "7F7FFFFF";
        public static final String    HEX_FLOAT_MIN_VAL_BYTES = "01000000";
        public static final String Be_HEX_FLOAT_MIN_VAL_BYTES = "00000001";
        public static final String    HEX_FLOAT_NEG_1_BYTES   = "000080BF";
        public static final String Be_HEX_FLOAT_NEG_1_BYTES   = "BF800000";
        public static final String    HEX_FLOAT_0_BYTES       = "00000000";
        public static final String Be_HEX_FLOAT_0_BYTES       = "00000000";
        public static final String    HEX_FLOAT_1_BYTES       = "0000803F";
        public static final String Be_HEX_FLOAT_1_BYTES       = "3F800000";

        //Double
        public static final byte[]    DOUBLE_MAX_VAL_BYTES = new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0x7F};
        public static final byte[] Be_DOUBLE_MAX_VAL_BYTES = new byte[] {(byte) 0x7F, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        public static final byte[]    DOUBLE_MIN_VAL_BYTES = new byte[] {(byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[] Be_DOUBLE_MIN_VAL_BYTES = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01};
        public static final byte[]    DOUBLE_NEG_1_BYTES   = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0xF0, (byte) 0xBF};
        public static final byte[] Be_DOUBLE_NEG_1_BYTES   = new byte[] {(byte) 0xBF, (byte) 0xF0, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[]    DOUBLE_0_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[] Be_DOUBLE_0_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final byte[]    DOUBLE_1_BYTES       = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0xF0, (byte) 0x3F};
        public static final byte[] Be_DOUBLE_1_BYTES       = new byte[] {(byte) 0x3F, (byte) 0xF0, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        public static final String    HEX_DOUBLE_MAX_VAL_BYTES = "FFFFFFFFFFFFEF7F";
        public static final String Be_HEX_DOUBLE_MAX_VAL_BYTES = "7FEFFFFFFFFFFFFF";
        public static final String    HEX_DOUBLE_MIN_VAL_BYTES = "0100000000000000";
        public static final String Be_HEX_DOUBLE_MIN_VAL_BYTES = "0000000000000001";
        public static final String    HEX_DOUBLE_NEG_1_BYTES   = "000000000000F0BF";
        public static final String Be_HEX_DOUBLE_NEG_1_BYTES   = "BFF0000000000000";
        public static final String    HEX_DOUBLE_0_BYTES       = "0000000000000000";
        public static final String Be_HEX_DOUBLE_0_BYTES       = "0000000000000000";
        public static final String    HEX_DOUBLE_1_BYTES       = "000000000000F03F";
        public static final String Be_HEX_DOUBLE_1_BYTES       = "3FF0000000000000";

        public static final boolean[][] binarySemiTrueBits = new boolean[][] {
                {true, false, false, false, false, false, false, false},  //128
                {true, true, false, false, false, false, false, false},   //192
                {true, true, true, false, false, false, false, false},    //224
                {true, true, true, true, false, false, false, false},     //240
                {true, true, true, true, true, false, false, false},      //248
                {true, true, true, true, true, true, false, false},       //252
                {true, true, true, true, true, true, true, false}         //254
        };

        public static final String[] bitStringSemiTrueBits = new String[] {
                "10000000", //128
                "11000000", //192
                "11100000", //224
                "11110000", //240
                "11111000", //248
                "11111100", //252
                "11111110"  //254
        };

        public static final byte[] byteSemiTrueBits = new byte[] {
                (byte) 128,
                (byte) 192,
                (byte) 224,
                (byte) 240,
                (byte) 248,
                (byte) 252,
                (byte) 254
        };

        public static final boolean[][] binarySemiFalseBits = new boolean[][] {
                {false, true, true, true, true, true, true, true},        //127
                {false, false, true, true, true, true, true, true},       //63
                {false, false, false, true, true, true, true, true},      //31
                {false, false, false, false, true, true, true, true},     //15
                {false, false, false, false, false, true, true, true},    //7
                {false, false, false, false, false, false, true, true},   //3
                {false, false, false, false, false, false, false, true}   //1
        };

        public static final String[] bitStringSemiFalseBits = new String[] {
                "01111111", //127
                "00111111", //63
                "00011111", //31
                "00001111", //15
                "00000111", //7
                "00000011", //3
                "00000001"  //1
        };

        public static final byte[] byteSemiFalseBits = new byte[] {
                (byte) 127,
                (byte) 63,
                (byte) 31,
                (byte) 15,
                (byte) 7,
                (byte) 3,
                (byte) 1
        };

        public static final boolean[][] binarySingleTrueBits = new boolean[][] {
                {true, false, false, false, false, false, false, false},  //128
                {false, true, false, false, false, false, false, false},  //64
                {false, false, true, false, false, false, false, false},  //32
                {false, false, false, true, false, false, false, false},  //16
                {false, false, false, false, true, false, false, false},  //8
                {false, false, false, false, false, true, false, false},  //4
                {false, false, false, false, false, false, true, false},  //2
                {false, false, false, false, false, false, false, true}   //1
        };

        public static final String[] bitStringSingleTrueBits = new String[] {
                "10000000", //128
                "01000000", //64
                "00100000", //32
                "00010000", //16
                "00001000", //8
                "00000100", //4
                "00000010", //2
                "00000001"  //1
        };

        public static final byte[] byteSingleTrueBits = new byte[] {
                (byte) 128,
                (byte) 64,
                (byte) 32,
                (byte) 16,
                (byte) 8,
                (byte) 4,
                (byte) 2,
                (byte) 1
        };

        public static final boolean[][] binarySingleFalseBits = new boolean[][] {
                {false, true, true, true, true, true, true, true},  //127
                {true, false, true, true, true, true, true, true},  //191
                {true, true, false, true, true, true, true, true},  //223
                {true, true, true, false, true, true, true, true},  //239
                {true, true, true, true, false, true, true, true},  //247
                {true, true, true, true, true, false, true, true},  //251
                {true, true, true, true, true, true, false, true},  //253
                {true, true, true, true, true, true, true, false}   //254
        };

        public static final String[] bitStringSingleFalseBits = new String[] {
                "01111111", //127
                "10111111", //191
                "11011111", //223
                "11101111", //239
                "11110111", //247
                "11111011", //251
                "11111101", //253
                "11111110"  //254
        };

        public static final byte[] byteSingleFalseBits = new byte[] {
                (byte) 127,
                (byte) 191,
                (byte) 223,
                (byte) 239,
                (byte) 247,
                (byte) 251,
                (byte) 253,
                (byte) 254
        };

        public static final boolean[][] binaryPairTrueBits = new boolean[][] {
                {true, false, true, false, false, false, false, false}, //160
                {false, true, false, true, false, false, false, false}, //80
                {false, false, true, false, true, false, false, false}, //40
                {false, false, false, true, false, true, false, false}, //20
                {false, false, false, false, true, false, true, false}, //10
                {false, false, false, false, false, true, false, true}  //5
        };

        public static final String[] bitStringPairTrueBits = new String[] {
                "10100000", //160
                "01010000", //80
                "00101000", //40
                "00010100", //20
                "00001010", //10
                "00000101"  //5
        };

        public static final byte[] bytePairTrueBits = new byte[] {
                (byte) 160,
                (byte) 80,
                (byte) 40,
                (byte) 20,
                (byte) 10,
                (byte) 5
        };

        public static final boolean[][] binaryPairFalseBits = new boolean[][] {
                {false, true, false, true, true, true, true, true},   //95
                {true, false, true, false, true, true, true, true},   //175
                {true, true, false, true, false, true, true, true},   //215
                {true, true, true, false, true, false, true, true},   //235
                {true, true, true, true, false, true, false, true},   //245
                {true, true, true, true, true, false, true, false}    //250
        };

        public static final String[] bitStringPairFalseBits = new String[] {
                "01011111", //95
                "10101111", //175
                "11010111", //215
                "11101011", //235
                "11110101", //245
                "11111010"  //250
        };

        public static final byte[] bytePairFalseBits = new byte[] {
                (byte) 95,
                (byte) 175,
                (byte) 215,
                (byte) 235,
                (byte) 245,
                (byte) 250
        };

        public static final boolean[][] binary_Undersized = new boolean[][] {
                {true, false, true, false}, //10
                {false, true, false, true}  //5
        };

        public static final String[] bitString_Undersized  = new String[] {
                "1010", //10
                "0101"  //5
        };

        public static final byte[] byte_Undersized = new byte[] {
                (byte) 10,
                (byte) 5
        };

        public static final byte[] byte_Undersized_Msb0_fullByteValue = new byte[] {
                (byte) 160,
                (byte) 80
        };

        public static final boolean[][] binary_Oversized_Leading_1s = new boolean[][] {
                {true, true, true, true, true, true, true, true, true, false, true, false},     //4090
                {false, true, false, true, true, true, true, true, true, true, true, true}      //1535
        };

        public static final boolean[][] binary_Oversized_Trailing_1s = new boolean[][] {
                {true, true, true, true, true, false, true, false, true, true, true, true},     //4015
                {true, true, true, true, false, true, false, true, true, true, true, true}      //3935
        };

        public static final boolean[][] binary_Oversized_Leading_0s = new boolean[][] {
                {false, false, false, false, true, true, true, true, true, false, true, false}, //250
                {false, true, false, true, true, true, true, true, false, false, false, false}  //1520
        };

        public static final boolean[][] binary_Oversized_Trailing_0s = new boolean[][] {
                {true, true, true, true, true, false, true, false, false, false, false, false}, //4000
                {false, false, false, false, false, true, false, true, true, true, true, true}  //95
        };

        public static final String[] bitString_Oversized_Leading_1s  = new String[] {
                "111111111010", //4090
                "010111111111"  //1535
        };

        public static final String[] bitString_Oversized_Trailing_1s = new String[] {
                "111110101111", //4015
                "111101011111"  //3935
        };

        public static final String[] bitString_Oversized_Leading_0s  = new String[] {
                "000011111010", //250
                "010111110000"  //1520
        };

        public static final String[] bitString_Oversized_Trailing_0s = new String[] {
                "111110100000", //4000
                "000001011111"  //95
        };

        public static final byte[] byte_Delimited_None = new byte[] {
                (byte) 183,
                (byte) 237
        };

        public static final boolean[][] binary_Delimited_None = new boolean[][] {
                {true, false, true, true, false, true, true, true}, //183
                {true, true, true, false, true, true, false, true}  //237
        };

        public static final String[] bitString_Delimited_None = new String[] {
                "10110111", //183
                "11101101"  //237
        };

        public static final String[] bitString_Delimited_Spaces = new String[] {
                "1011 01  11", //183
                "111011   01"  //237
        };

        public static final String[] bitString_Delimited_Dashes = new String[] {
                "1011-01--11", //183
                "111011---01"  //237
        };

        public static final String[] bitString_Delimited_Underscores = new String[] {
                "1011_01__11", //183
                "111011___01"  //237
        };

        public static final String[] bitString_Delimited_Periods = new String[] {
                "1011.01..11", //183
                "111011...01"  //237
        };

        public static final String[] bitString_Delimited_Tabs = new String[] {
                "1011\t01\t\t11", //183
                "111011\t\t\t01"  //237
        };

        public static final String[] bitString_Delimited_All = new String[] {
                "__  10_-11\t0..1\t\t1. --1", //183
                " 1--1-_\t10__.-.11\t\t..01"  //237
        };

        public static final byte[] hexStringByteVals_Delimited_None = new byte[] {
                (byte) 0xAF, //175
                (byte) 0xF3, //243
                (byte) 0x26, //38
                (byte) 0x6E, //110
                (byte) 0xA1, //161
                (byte) 0x4E, //78
                (byte) 0x23, //35
                (byte) 0x01  //1
        };

        public static final String hexString_Delimited_None         = "AFF3266EA14E2301";
        public static final String hexString_Delimited_Spaces       = "AFF3 26  6EA14E   2301";
        public static final String hexString_Delimited_Dashes       = "AFF3-26--6EA14E---2301";
        public static final String hexString_Delimited_Underscores  = "AFF3_26__6EA14E___2301";
        public static final String hexString_Delimited_Periods      = "AFF3.26..6EA14E...2301";
        public static final String hexString_Delimited_Tabs         = "AFF3\t26\t\t6EA14E\t\t\t2301";
        public static final String hexString_Delimited_All          = "__ AF_-F3\t2..6\t\t6. --E  A14.\t_-_E2-.301";
    }

}
