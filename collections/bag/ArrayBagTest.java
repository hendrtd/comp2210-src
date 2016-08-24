import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * ArrayBagTest.java
 * Provides JUnit tests for classes that implement the
 * Bag interface.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-08-23
 *
 */
public class ArrayBagTest {

   // maximum bag size used in tests
   static final int MAX_SIZE = 100;

   ///////////////////////////////////////////////////////////////////
   // Functional tests for add, remove, contains, isEmpty, and size //
   ///////////////////////////////////////////////////////////////////

   /** Tests the core Bag methods add, remove, contains, isEmpty, and size. */
   @Test
   public void coreMethodsTest() {
      Bag<Integer> abag = new ArrayBag<>();

      // test when empty
      assertEquals(0, abag.size());
      assertEquals(true, abag.isEmpty());
      assertEquals(false, abag.contains(2));

      // Add MAX_SIZE elements, remove MAX_SIZE elements, add MAX_SIZE elements.
      // test at each step
      int size = 0;
      for (int i = 0; i < MAX_SIZE; i++) {
         assertEquals(size, abag.size());
         assertEquals(false, abag.contains(i));
         boolean added = abag.add(i);
         assertEquals(true, added);
         size++;
         assertEquals(size, abag.size());
         assertEquals(true, abag.contains(i));
         assertEquals(false, abag.isEmpty());
      }
      for (int i = 0; i < MAX_SIZE; i++) {
         assertEquals(size, abag.size());
         assertEquals(true, abag.contains(i));
         assertEquals(false, abag.isEmpty());
         boolean removed = abag.remove(i);
         assertEquals(true, removed);
         size--;
         assertEquals(size, abag.size());
         assertEquals(false, abag.contains(i));
      }
      assertEquals(true, abag.isEmpty());
      for (int i = 0; i < MAX_SIZE; i++) {
         assertEquals(size, abag.size());
         assertEquals(false, abag.contains(i));
         boolean added = abag.add(i);
         assertEquals(true, added);
         size++;
         assertEquals(size, abag.size());
         assertEquals(true, abag.contains(i));
         assertEquals(false, abag.isEmpty());
      }

   }

   /** Tests add when the bag is full. */
   @Ignore
   public void add_whenFull() {

   }

   /** Tests remove when the bag is empty. */
   @Test
   public void removeWhenEmpty() {
      Bag<Integer> bag = new ArrayBag<>();

      // test when initially empty
      boolean expected = false;
      boolean actual =  bag.remove(0);
      assertEquals(expected, actual);

      // test when empty after once having elements
      for (int i = 0; i < MAX_SIZE; i++) {
         bag.add(i);
      }
      int value = 0;
      while (!bag.isEmpty()) {
         bag.remove(value);
         value++;
      }
      expected = false;
      actual = bag.remove(0);
      assertEquals(expected, actual);
   }


   /////////////////////////////////////
   // Functional tests for iterator() //
   /////////////////////////////////////

   /** Tests iterator when the bag is empty. */
   @Test
   public void iteratorWhenEmpty() {
      Bag<Integer> bag = new ArrayBag<>();

      // test when initially empty
      Iterator<Integer> itr = bag.iterator();
      assertEquals(false, itr.hasNext());

      List<Integer> elements = new ArrayList<>();
      for (Integer i : bag) {
         elements.add(i);
      }
      assertEquals(0, elements.size());

      // test when empty after once having elements
      for (int i = 0; i < MAX_SIZE; i++) {
         bag.add(i);
      }
      int value = 0;
      while (!bag.isEmpty()) {
         bag.remove(value);
         value++;
      }
      itr = bag.iterator();
      assertEquals(false, itr.hasNext());

      elements = new ArrayList<>();
      for (Integer i : bag) {
         elements.add(i);
      }
      assertEquals(0, elements.size());
   }

   /** Tests iterator for a typical bag. */
   @Test
   public void iteratorTypical() {
      Bag<Integer> bag = new ArrayBag<>();
      Integer[] values = new Integer[]{1};
      for (Integer i : values) {
         bag.add(i);
      }

      List<Integer> elements = new ArrayList<>();
      for (Integer i : bag) {
         elements.add(i);
      }
      assertArrayEquals(values, elements.toArray());

      bag = new ArrayBag<>();
      values = new Integer[]{1,2};
      for (Integer i : values) {
         bag.add(i);
      }
      elements = new ArrayList<>();
      for (Integer i : bag) {
         elements.add(i);
      }
      assertArrayEquals(values, elements.toArray());

      bag = new ArrayBag<>();
      values = new Integer[]{1,2,3};
      for (Integer i : values) {
         bag.add(i);
      }
      elements = new ArrayList<>();
      for (Integer i : bag) {
         elements.add(i);
      }
      assertArrayEquals(values, elements.toArray());

      bag = new ArrayBag<>();
      values = new Integer[]{1,2,3,4,5,6,7,8,9,10};
      for (Integer i : values) {
         bag.add(i);
      }
      elements = new ArrayList<>();
      for (Integer i : bag) {
         elements.add(i);
      }
      assertArrayEquals(values, elements.toArray());
   }

   /** Tests iterator interactions with core methods. */
   @Test
   public void iteratorInteractionsWithCore() {
      Bag<Integer> bag = new ArrayBag<>();
      Integer[] values = new Integer[]{1,2,3,4,5,6,7,8,9,10};
      for (Integer i : values) {
         bag.add(i);
      }
      List<Integer> elements = new ArrayList<>();
      for (Integer i : bag) {
         elements.add(i);
      }

      assertEquals(values.length, bag.size());
      assertEquals(false, bag.isEmpty());
      for (Integer i : values) {
         assertEquals(true, bag.contains(i));
      }

      for (int i = 1; i < values.length; i = i + 2) {
         bag.remove(values[i]);
      }
      values = new Integer[]{1,3,5,7,9};
      elements = new ArrayList<>();
      for (Integer i : bag) {
         elements.add(i);
      }
      Integer[] elemArray = elements.toArray(new Integer[]{});
      Arrays.sort(elemArray);
      assertArrayEquals(values, elemArray);
   }

}
