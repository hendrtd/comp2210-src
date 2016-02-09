import java.math.BigInteger;

/**
 * FactorialBigInteger.java
 * Provides implementations that compute or approximate n!.
 * The BigInteger type is used, so relatively large values 
 * for n can be used (n <= XXX).
 * 
 * References: 
 * 		- Knuth, TAOCP Vol. 1, pp. 44-49.
 * 		- http://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html
 * 		
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-02-09
 * 
 */
public class FactorialBigInteger {

	/** Drives execution. */
	public static void main(String[] args) {
		for (int i = 0; i <= 100; i++) {
			System.out.println(i + "! = " + factIterative(i));
		}
	}

	/**
	 * Computes the factorial of n using an iterative
	 * algorithm. A string representing n! radix 10
	 * is returned.
	 */
	public static String factIterative(int n) {
		if (n == 0) {
			return "1";
		}
		BigInteger fact = BigInteger.valueOf(n);
		for (int i = n - 1; i > 0; i--) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact.toString(10);
	}

	/**
	 * Computes the factorial of n using a recursive
	 * algorithm.
	 */
	public static String factRecursive(int n) {
		return fRBigInt(BigInteger.valueOf(n)).toString(10);
	}

	/** recursive factorial on BigIntegers */
	private static BigInteger fRBigInt(BigInteger n) {
		if (n.equals(BigInteger.valueOf(0))) {
			return BigInteger.valueOf(1);
		}
		return n.multiply(fRBigInt(n.subtract(BigInteger.valueOf(1))));
	}

	/** 
	 * Finds the largest int for which we can compute n! in terms
	 * of a BingInteger. This will run for some time ...
	 */
	public static void findMaxN() {
		int i = 0;
		try {
			for (; ; i++) {
				String fact = factIterative(i);
				// let us know you're still with us ...
				if (i % 1_000 == 0) {
					System.out.println(i);
				}
			}
		}
		catch (ArithmeticException e) {
			System.out.println("Max N = " + (i - 1));
		}
	}

}
