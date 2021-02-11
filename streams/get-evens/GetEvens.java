import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

/** 
 * Illustrates streams.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2020-01-17
 */
public class GetEvens {

	/** Drives execution. */
	public static void main(String[] args) {
		int[] zeroLength = new int[0];
		int[] none = {1, 3, 5, 7};
		int[] all = {2, 4, 6, 8};
		int[] some = {1, 2, 3, 4, 5};

		// zero length
		System.out.println("a = " + Arrays.toString(zeroLength));
		int[] evens = getEvensLoop(zeroLength);
		// int[] evens = getEvensStream(zeroLength);
		System.out.println("evens = " + Arrays.toString(evens));
		System.out.println();

		// no evens
		System.out.println("a = " + Arrays.toString(none));
		evens = getEvensLoop(none);
		// evens = getEvensStream(none);
		System.out.println("evens = " + Arrays.toString(evens));
		System.out.println();

		// all evens
		System.out.println("a = " + Arrays.toString(all));
		evens = getEvensLoop(all);
		// evens = getEvensStream(all);
		System.out.println("evens = " + Arrays.toString(evens));
		System.out.println();

		// some evens
		System.out.println("a = " + Arrays.toString(some));
		evens = getEvensLoop(some);
		// evens = getEvensStream(some);
		System.out.println("evens = " + Arrays.toString(evens));
		System.out.println();
	}


	/**
	 * Returns an array of size N containing the N even ints in a.
	 */
	public static int[] getEvensLoop(int[] a) {
		int[] result = new int[a.length];
		int count = 0;
		for (int value : a) {
			if (value % 2 == 0) {
				result[count] = value;
				count++;
			}
		}
		return Arrays.copyOf(result, count);
	}


	/**
	 * Returns an array of size N containing the N even ints in a.
	 */
	public static int[] getEvensStream(int[] a) {
		return IntStream.of(a).
			filter(value -> value % 2 == 0).
			toArray();
	}
}
