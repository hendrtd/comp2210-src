/**
 * LinearSearch.java
 * Provides various implementations of linear search as relevant
 * to class. All methods are written for arrays of ints.
 *
 * @author 	Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-14
 * 
 */
public class LinearSearch {

	/** Drives execution. */
	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}

		System.out.println("lsearch1: ");
		for (int i = -1; i < a.length + 1; i++) {
			System.out.println(i + " : " + lsearch1(a, i));
		}
		System.out.println();

		System.out.println("lsearch2: ");
		for (int i = -1; i < a.length + 1; i++) {
			System.out.println(i + " : " + lsearch2(a, i));
		}
		System.out.println();

		System.out.println("lsearch3: ");
		for (int i = -1; i < a.length + 1; i++) {
			System.out.println(i + " : " + lsearch3(a, i, 0, a.length - 1));
		}
		System.out.println();
	}

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

    /**
     * Implements linear search on an array of integers.
     */
    public static int lsearch2(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /** Recursive linear search on an array of integers. */
    public static int lsearch3(int[] a, int target, int left, int right) {
    	if (left > right) {
    		return -1;
    	}
    	if (a[left] == target) {
    		return left;
    	}
    	return lsearch3(a, target, left + 1, right);
    }

}
