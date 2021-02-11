import java.util.Iterator;

/**
 * ArraySortedList.java
 * Implements a sorted list using an array for the underlying data structure.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-09-30
 */
public class ArraySortedList<T extends Comparable<T>> implements SortedList<T> {

   // default capacity of the array
   private static final int DEFAULT_CAPACITY = 1;

   // stores all elements of the list
   private T[] elements;

   // the number of elements in the list
   int size;

   /** Creates a sorted list with the default capacity. */
   public ArraySortedList() {
      this(DEFAULT_CAPACITY);
   }

   /** Creates a sorted list with the specified capacity. */
   @SuppressWarnings("unchecked")
   public ArraySortedList(int capacity) {
      elements = (T[]) new Comparable[capacity];
      size = 0;
   }

   /**
    * Ensures that this list contains the specified element.
    * Returns true if element was added, false otherwise.
    */
   public boolean add(T element) {
      return false;
   }

   /** Returns the first element in this list. */
   public T first() {
      return null;
   }

   /** Returns the last element in this list. */
   public T last() {
      return null;
   }

   /** Returns true if this list contains element, false otherwise. */
   public boolean contains(T element) {
      return false;
   }

   /**
    * Removes a single instance of element from this list.
    * Returns true if element was removed, false otherwise.
    */
   public boolean remove(T element) {
      return false;
   }

   /**
    * Removes and returns a reference to the first element in this list.
    * Returns null if the list is empty.
    */
   public T removeFirst() {
      return null;
   }

   /**
    * Removes and returns a reference to the last element in this list.
    * Returns null if the list is empty.
    */
   public T removeLast() {
      return null;
   }

   /** Returns the number of elements in this list. */
   public int size() {
      return -1;
   }

   /** Returns true if this list is empty, false otherwise. */
   public boolean isEmpty() {
      return false;
   }

   /** Provides an iterator over the elements in this list. */
   public Iterator<T> iterator() {
      return null;
   }
}
