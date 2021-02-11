import java.util.Arrays;

/**
 * Binary search that returns the first and last index of
 * a given target value.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 */
public class BinarySearchDuplicateRange {

    /** Drives execution. */
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 6, 6, 8, 8, 8, 8, 8, 8, 10};
        System.out.println(Arrays.toString(a));
        int location = BinarySearchDuplicateRange.binarySearch(a, 8);
        System.out.println("found at index " + location);
    }

    /**
     * Returns the index of target in a or -1 if not present.
     */
    public static int binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        System.out.printf("%6s %7s %9s\n", "left", "right", "middle");
        while (left <= right) {
            int middle = left + (right - left) / 2;
            System.out.printf("%6d %7d %9d\n", left, right, middle);
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
}
