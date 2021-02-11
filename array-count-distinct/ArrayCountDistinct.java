import java.util.Arrays;
import java.util.HashSet;

/**
 * Illustrates different approaches for counting distinct values in an array.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-01-21
 */
public class ArrayCountDistinct {

    public static void main(String[] args) {
        // int[] a = {5, 2, 2, 3, 9, 5, 3, 10};
        // int[] a = {2,3,3,3,4,4,5,6,7,7,8};
        // int[] a = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,};
        // int[] a = {1,2,3,4,5,6,7,};
        // int[] a = {1,1,1,1,2,3,3,3,3,3,};
        int[] a = {1,2};
        System.out.println(Arrays.toString(a));
        System.out.println(countDistinct1(a));
    }

    // O(NlogN)
    public static int countDistinct1(int[] a) {
        if ((a.length == 0) || (a.length == 1)) {
            return a.length;
        }
        int[] acopy = Arrays.copyOf(a, a.length);
        Arrays.sort(acopy);
        int distinctVal = acopy[0];
        int distinct = 1;
        for (int val : acopy) {
            if (val != distinctVal) {
                distinctVal = val;
                distinct += 1;
            }
        }
        return distinct;
    }

    // O(N)
    public static int countDistinct2(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : a) {
            set.add(value);
        }
        return set.size();
    }

}
