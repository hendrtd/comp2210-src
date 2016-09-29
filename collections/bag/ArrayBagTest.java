import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Field;

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
      Integer[] elementsArray = elements.<Integer>toArray(new Integer[]{});
      Arrays.<Integer>sort(elementsArray);
      assertArrayEquals(values, elementsArray);

      bag = new ArrayBag<>();
      values = new Integer[]{1,2};
      for (Integer i : values) {
         bag.add(i);
      }
      elements = new ArrayList<>();
      for (Integer i : bag) {
         elements.add(i);
      }
      elementsArray = elements.<Integer>toArray(new Integer[]{});
      Arrays.<Integer>sort(elementsArray);
      assertArrayEquals(values, elementsArray);

      bag = new ArrayBag<>();
      values = new Integer[]{1,2,3};
      for (Integer i : values) {
         bag.add(i);
      }
      elements = new ArrayList<>();
      for (Integer i : bag) {
         elements.add(i);
      }
      elementsArray = elements.<Integer>toArray(new Integer[]{});
      Arrays.<Integer>sort(elementsArray);
      assertArrayEquals(values, elementsArray);

      bag = new ArrayBag<>();
      values = new Integer[]{1,2,3,4,5,6,7,8,9,10};
      for (Integer i : values) {
         bag.add(i);
      }
      elements = new ArrayList<>();
      for (Integer i : bag) {
         elements.add(i);
      }
      elementsArray = elements.<Integer>toArray(new Integer[]{});
      Arrays.<Integer>sort(elementsArray);
      assertArrayEquals(values, elementsArray);
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
      Integer[] elementsArray = elements.<Integer>toArray(new Integer[]{});
      Arrays.<Integer>sort(elementsArray);
      assertArrayEquals(values, elementsArray);
   }


   /////////////////////////////////////////
   // Structural tests for add and remove //
   /////////////////////////////////////////

   @Test
   public void addArrayGrowth() throws Exception {
      Bag<Integer> bag = new ArrayBag<>();
      Field array = bag.getClass().getDeclaredField("elements");
      array.setAccessible(true);
      Object[] elements = (Object[]) array.get(bag);

      // The elements array starts out at capacity 1.
      // Does not double on an add that *makes* it full.
      // Doubles only on adds that can't be satisfied without
      // more room.
      // Make N consecutive adds (add(i = [1..N]). On each
      // iteration, the following invariants must hold.
      //    i == bag.size()
      //    capacity == doubleSize (the next size at which doubling will happen)
      // When i == capacity at the *beginning* of an add request, doubling occurs
      // and doubleSize is increased.
      assertEquals("Incorrect initial size. ", 0, bag.size());
      int capacity = 1;
      assertEquals("Incorrect initial capacity. ", capacity, elements.length);
      int doubleSize = capacity;
      for (int i = 1; i <= 32; i++) {
         bag.add(i);
         elements = (Object[]) array.get(bag);
         capacity = elements.length;
         assertEquals("Incorrect size for i = " + i + ". ", i, bag.size());
         assertEquals("Incorrect capacity for i = " + i + ". ", doubleSize, capacity);
         if (i == capacity) {
            doubleSize *= 2;
         }
         // System.out.println(" i = " + i + ", size = " + bag.size() + ", capacity = " + capacity);
      }
   }

   @Test
   public void removeArrayShrink() throws Exception {
      Bag<Integer> bag = new ArrayBag<>();
      Field array = bag.getClass().getDeclaredField("elements");
      array.setAccessible(true);
      Object[] elements = (Object[]) array.get(bag);

      // The elements array shrinks by half after a remove that
      // causes size() to be strictly less than elements.length * .25.
      // Once the array capacity grows to four, it will never shrink below four.
      // Starting with a bag of size N and elements [1..N], make  N
      // consecutive removes (remove(i = [N..1])). On each iteration,
      // the following invariants must hold after a remove.
      //    i == bag.size() + 1
      //    capacity == halfSize * 2 (the next size at which halving will occur)
      // When i == halfSize / 2 at the *end* of a remove, halving occurs
      // and halfSize is decreased.
      for (int i = 1; i <= 32; i++) {
         bag.add(i);
      }
      int capacity = 32;
      int halfSize = 16;
      for (int i = 32; i > 0; i--) {
         bag.remove(i);
         elements = (Object[]) array.get(bag);
         capacity = elements.length;
         if ((i > 1) && (i == halfSize / 2)) {
            halfSize /= 2;
         }
         assertEquals("Incorrect size for i = " + i + ". ", i, bag.size() + 1);
         assertEquals("Incorrect capacity for i = " + i + ". ", capacity, halfSize * 2);
      }
   }

}
