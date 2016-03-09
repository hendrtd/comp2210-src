/**
 * BitOps.java
 * Illustrates bitwise (~, &, ^, |) and bit shift (<<, >>, >>>) operators.
 *
 * References:
 *     https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
 *
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-03-08
 *
 */
public class BitOps {

    /** Number of bits in the int type. */
    private static final int NUM_BITS = 32;

    /** Number of digits in Integer.MAX_VALUE */
    private static final int NUM_DIGITS = 10;

    /**
     * Drives execution.
     */
    public static void main(String[] args) {
        int value = 5;

        /** signed left shift: << */
        // multiply by 2
        value = value << 1;
        // multiply by 8
        value = value << 3;
        // repeated applications of <<
        signedLeftShift();

        /** signed right shift: >> */
        // divide by 2
        value = value >> 1;
        // divide by 8
        value = value >> 3;
        // repeated applications of >>
        signedRightShift();

        /** unsigned right shift: >>> */
        value = 10;
        value = value >>> 1;

        /** bitwise complement: ~ */
        value = 16;
        value = ~value;
        value = ~value;

        /** bitwise AND: & */
        int val1 = 15;
        int val2 = 5;
        int result = val1 & val2;
        result = val2 & val1;
        val1 = 13;
        val2 = 12;
        result = val1 & val2;
        result = val2 & val1;

        /** bitwise exclusive OR: ^ */
        val1 = 15;
        val2 = 12;
        result = val1 ^ val2;
        result = val2 ^ val1;
        val1 = 107;
        val2 = 44;
        result = val1 ^ val2;
        result = val2 ^ val1;

        /** bitwise inclusive OR: ^ */
        val1 = 15;
        val2 = 12;
        result = val1 | val2;
        result = val2 | val1;
        val1 = 107;
        val2 = 44;
        result = val1 | val2;
        result = val2 | val1;
    }

    /**
     * Illustrates multiple calls to signed left shift (<<)
     */
    public static void signedLeftShift() {
        int value = 1;
        for (int i = 0; i < NUM_BITS; i++) {
            printDecimalAndBinary(value);
            value = value << 1;
        }
    }

    /**
     * Illustrates multiple calls to signed right shift (>>)
     */
    public static void signedRightShift() {
        int value = Integer.MAX_VALUE;
        for (int i = 0; i < NUM_BITS; i++) {
            printDecimalAndBinary(value);
            value = value >> 1;
        }
    }

    /**
     * Prints the given value in both decimal and binary forms.
     */
    public static void printDecimalAndBinary(int value) {
        System.out.print("decimal = ");
        String decimalFormat = "%" + (NUM_DIGITS + 1) + "s";
        System.out.print(String.format(decimalFormat, value));
        System.out.print("  binary = ");
        String binary = Integer.toBinaryString(value);
        StringBuilder leadingZeroes = new StringBuilder();
        for (int i = 0; i < NUM_BITS - binary.length(); i++) {
            leadingZeroes.append("0");
        }
        System.out.print(leadingZeroes.toString());
        System.out.println(binary);
    }
}
