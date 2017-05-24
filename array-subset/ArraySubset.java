import java.util.Arrays;

/**
 * Demonstrates creating a subset of an array.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-05-24
 */
public class ArraySubset {

   /** Drives execution. */
   public static void main(String[] args) {
      int[] a = {1,2,3,4,5,6,7,8,9};
      int[] subset = getEvens(a);
      System.out.println(subset.length);
   }

   /**
    * Returns an array containing only the even values in the
    * given array.
    */
   public static int[] getEvens(int[] a) {
      int[] result = new int[a.length];
      int index = 0;
      for (int value : a) {
         if (value % 2 == 0) {
            result[index] = value;
            index++;
         }
      }
      return Arrays.copyOf(result, index);
   }
}
