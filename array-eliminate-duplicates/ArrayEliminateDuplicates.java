import java.util.Arrays;
import java.util.HashSet;

/**
 * Illustrates different approaches for eliminating duplicate values from an array.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-10-03
 */
public class ArrayEliminateDuplicates {

    public static void main(String[] args) {
        int[] a = {5, 2, 2, 3, 9, 5, 3, 10};
        // int[] a = {2,3,3,3,4,4,5,6,7,7,8};
        // int[] a = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,};
        // int[] a = {1,2,3,4,5,6,7,};
        // int[] a = {1,1,1,1,2,3,3,3,3,3,};
        // int[] a = {1,2};
        System.out.println(Arrays.toString(a));
        int[] anodup = nodup3(a);
        System.out.println(Arrays.toString(anodup));
    }

    // O(N^2)
    public static int[] nodup1(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int i = left + 1;
            while (i < right) {
                if (a[i] == a[i - 1]) {
                    swap(a, i, right);
                    right--;
                }
                i++;
            }
            left++;
        }
        return Arrays.copyOf(a, left - 1);
    }

    // O(NlogN)
    public static int[] nodup2(int[] a) {
        if (a.length < 2) {
            return a;
        }
        Arrays.sort(a);
        int left = 1;
        int right = a.length - 1;
        while (left < right) {
            if (a[left] == a[left - 1]) {
                while ((right > left) && (a[right] == a[right - 1])) {
                    right--;
                }
                if (right == left) {
                    break;
                }
                swap(a, left - 1, right);
                right--;
            }
            left++;
        }
        if (a[right] == a[right -1]) {
            right--;
        }
        return Arrays.copyOf(a, right + 1);
    }

    // O(N)
    public static int[] nodup3(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : a) {
            set.add(value);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer value : set) {
            result[i++] = value;
        }
        return result;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
