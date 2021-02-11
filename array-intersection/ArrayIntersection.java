import java.util.Arrays;

/**
 * ArrayIntersection.java
 * Illustrates algorithms for computing intersection of arrays.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-02-11
 */
public class ArrayIntersection {

   /**
    * Returns the intersection of the two specified arrays. Uses nested linear
    * scans and thus offers O(N^2) time complexity.
    */
   public int[] intersectionNestedScans(int[] a1, int[] a2) {
      if (a1.length == 0 || a2.length == 0) {
         return new int[0];
      }
      int[] outer = (a1.length < a2.length ? a1 : a2);
      int[] inner = (a1.length > a2.length ? a1 : a2);
      int[] intersection = new int[outer.length];
      int count = 0;
      for (int element : outer) {
         if (indexOf(inner, element) >= 0) {
            intersection[count++] = element;
         }
      }
      return Arrays.copyOf(intersection, count - 1);
   }

   /**
    * Returns the index of target in a or -1 if not present.
    */
   private int indexOf(int[] a, int target) {
      for (int i = 0; i < a.length; i++) {
         if (a[i] == target) {
            return i;
         }
      }
      return -1;
   }
}
