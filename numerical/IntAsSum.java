/**
 * IntAsSum.java
 * Expresses a positive int as the sum of distinct powers of two.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-03-09
 *
 */
public class IntAsSum {

    /** Number of bits in the int type, excluding the sign. */
    private static final int NUM_BITS = 31;

    /**
     * Drives execution.
     */
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.print(i + " = ");
            System.out.println(asSumShift(i));
            // System.out.println(asSumDiv(i, 128));
        }
    }

    /**
     * Returns a string representation of the sum of
     * distinct powers of two that is equal to the given
     * positive int value.
     *
     * This implementation uses bitwise and shift
     * operators to test for powers of two in value.
     */
    public static String asSumShift(int value) {
        assert value > 0;
        StringBuilder sum = new StringBuilder();
        int term = 1;
        while (term <= value) {
            if ((value & term) == term) {
                sum.append(term + " + ");
            }
            term = term << 1;
        }
        sum.delete(sum.length() - 3, sum.length());
        return sum.toString();
    }

    /**
     * Returns a string representation of the sum of
     * distinct powers of two that is equal to the given
     * positive int value.
     *
     * This implementation uses integer division
     * operators to test for powers of two in value.
     *
     * @param value the int for which the sum expression is to
     *              be calculated
     * @param nextLargerPower the smallest power of two greater
     *                        than or equal to value
     */
    public static String asSumDiv(int value, int nextLargerPower) {
        assert value > 0;
        StringBuilder sum = new StringBuilder();
        int term = nextLargerPower;
        while (term >= 1) {
            if (value / term >= 1) {
                sum.insert(0, term + " + ");
                value = value % term;
            }
            term = term / 2;
        }
        sum.delete(sum.length() - 3, sum.length());
        return sum.toString();
    }

}
