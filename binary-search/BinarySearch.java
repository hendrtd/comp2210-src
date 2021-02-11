/**
 * BinarySearch.java
 * Provides reference implementations for binary search.
 *
 * Should use a better middle calculation:
 *    middle = left + ((right - left) / 2)
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-26
 */
public class BinarySearch {

    /**
     * Returns the index of target in a or -1 if not present.
     */
    public int binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (a[middle] == target) {
                return middle;
            }
            if (a[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    /** 
     * Returns the index of target in a or -1 if not present.
     */
    public int binarySearch(int[] a, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (a[middle] == target) {
            return middle;
        }
        if (a[middle] > target) {
            return binarySearch(a, target, left, middle - 1);
        } 
        return binarySearch(a, target, middle + 1, right);
    }

    /** Drives execution. */
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] a = {2,4,6,8,10,12,14,16,18,20};
        for (int i = 0; i <= 20; i++) {
            System.out.print(i + ": ");
            System.out.print("ls = ");
            int loc = bs.binarySearch(a, i);
            System.out.print(loc + " ");
            System.out.print("bs = ");
            loc = bs.binarySearch(a, i, 0, a.length - 1);
            System.out.print(loc);
            System.out.println();
        }
    }
}

