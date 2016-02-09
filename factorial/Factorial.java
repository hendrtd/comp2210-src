/**
 * Factorial.java
 * Provides implementations that compute or approximate n!.
 * The int type is used, so only small values for n can
 * be used (n <= 12).
 * 
 * Reference: Knuth, TAOCP Vol. 1, pp. 44-49.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-02-09
 * 
 */
public class Factorial {

	// aliases for readability
	private final static double E = Math.E;
	private final static double PI = Math.PI;

	// largest N for which N! doesn't overflow int
	private final static int MAX_N = 12;

	/** Drives execution. */
	public static void main(String[] args) {
		for (int i = 0; i <= MAX_N; i++) {
			System.out.println(i + "! = " + factIterative(i));
		}
		verifyRelativeErrorStirling(10);
	}

	/**
	 * Compute the factorial of n using an iterative
	 * algorithm.
	 */
	public static int factIterative(int n) {
		int fact = n;
		for (int i = n - 1; i > 0; i--) {
			fact *= i;
		}
		return (fact == 0 ? 1 : fact);
	}

	/**
	 * Compute the factorial of n using a recursive
	 * algorithm.
	 */
	public static int factRecursive(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factRecursive(n - 1);
	}

	/**
	 * Compute an approximation of the factorial of n
	 * using Stirling's formula.
	 */
	public static double factStirling(int n) {
		// note that we can leave 2 and n as ints
		return Math.sqrt(2 * PI * n) * Math.pow(n / E, n);
	}

	/**
	 * Compute the relative error of Stirling's
	 * approximation compared to the actual value.
	 * The expected relative error is ~ 1/(12n).
	 */
	public static void verifyRelativeErrorStirling(int n) {
		int exact = factIterativeExact(n);
		double approx = factStirling(n);
		double actual = 1 - (approx / exact);
		double expected = 1 / (12d * n);
		System.out.println("Expected error = " + expected);
		System.out.println("Actual error = " + actual);
	}

	/**
	 * Compute factorial of n using an iterative 
	 * algorithm and Math.multiplyExact to detect
	 * and avoid overflow.
	 */
	public static int factIterativeExact(int n) {
		int fact = n;
		for (int i = n - 1; i > 0; i--) {
			fact = Math.multiplyExact(fact, i);
		}
		return (fact == 0 ? 1 : fact);
	}

}
