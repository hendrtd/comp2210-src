import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Linear search + iterator + comparator
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-02-07
 */
public class LinearSearch {

	/** Drives execution. */
	public static void main(String[] args) {
		Collection<Integer> coll = Arrays.asList(2,4,6,8,10);
		System.out.println(LinearSearch.<Integer>search(coll, 8, new CompareIntegerAscending()));
	}

	/** Comparator. */
	static class CompareIntegerAscending implements Comparator<Integer> {
		public int compare(Integer i1, Integer i2) {
			return i1.compareTo(i2);
		}
	}

	/** Linear search. */
	public static <T> boolean search (Collection<T> coll, T target, Comparator<T> comp) {
		for (T value : coll) {
			if (comp.compare(value, target) == 0) {
				return true;
			}
		}
		return false;
	}
}

