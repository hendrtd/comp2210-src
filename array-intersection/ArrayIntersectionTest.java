import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * ArrayIntersectionTest.java
 * Provides unit tests for the ArrayIntersection class.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-02-11
 */
public class ArrayIntersectionTest {

   /**
    * An instantiation of the code under test.
    */
   ArrayIntersection fixture;

   /**
    * Setup test fixtures.
    */
   @Before
   public void setup() {
      fixture = new ArrayIntersection();
   }

   /**
    * left array empty.
    */
   @Test
   public void testWhenLeftArrayEmpty() {
      int[] a1 = new int[0];
      int[] a2 = {2, 4, 6, 8};
      int[] expected = new int[0];
      int[] actual = fixture.intersectionNestedScans(a1, a2);
      assertArrayEquals(expected, actual);
   }

   /**
    * right array empty.
    */
   @Test
   public void testWhenRightArrayEmpty() {
      int[] a1 = {2, 4, 6, 8};
      int[] a2 = new int[0];
      int[] expected = new int[0];
      int[] actual = fixture.intersectionNestedScans(a1, a2);
      assertArrayEquals(expected, actual);
   }

   /**
    * arrays non-empty, intersection empty.
    */
   @Test
   public void testWhenArraysNonEmptyIntersectionEmpty() {
      int[] a1 = {1, 2, 3};
      int[] a2 = {2, 4, 6, 8};
      int[] expected = new int[0];
      int[] actual = fixture.intersectionNestedScans(a1, a2);
      assertArrayEquals(expected, actual);
   }

   /**
    * intesection of non-empty equal arrays
    */
   @Test
   public void testWhenArraysEqual() {
      int[] a1 = {1, 2, 3};
      int[] a2 = {1, 2, 3};
      int[] expected = {1, 2, 3};
      int[] actual = fixture.intersectionNestedScans(a1, a2);
      assertArrayEquals(expected, actual);
   }

}
