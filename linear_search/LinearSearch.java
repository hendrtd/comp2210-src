/**
 * LinearSearch.java
 * Provides various implementations of linear search as relevant
 * to class. All methods are written for arrays of ints.
 *
 * @author 	Dean Hendrix (dh@auburn.edu)
 * @version 2016-02-08
 * 
 */
public class LinearSearch {

	/**
	 * Uses linear search to search for value in a. Returns the
	 * location of value in a or -1 if a does not contain value.
	 * 
	 * @param  a     the array to be searched
	 * @param  value the value to search for
	 * @return       index of value in a or -1 if not present
	 */
	public static int lsearch1(int[] a, int value) {
		int i = 0;
		while ((i < a.length) && (a[i] != value)) {
			i++;
		}
		if (i < a.length) {
			return i;
		}
		else {
			return -1;
		}
	}

}
