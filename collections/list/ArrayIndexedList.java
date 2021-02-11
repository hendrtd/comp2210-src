import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayIndexedList.java
 * Implements an indexed list using an array as the underlying data structure.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-09-30
 */
public class ArrayIndexedList<T> implements IndexedList<T> {

   // default capacity of the array
   private static final int DEFAULT_CAPACITY = 1;

   // stores all elements of the list
   private T[] elements;

   // the number of elements in the list
   int size;

   /** Creates a sorted list with the default capacity. */
   public ArrayIndexedList() {
      this(DEFAULT_CAPACITY);
   }

   /** Creates a sorted list with the specified capacity. */
   @SuppressWarnings("unchecked")
   public ArrayIndexedList(int capacity) {
      elements = (T[]) new Object[capacity];
      size = 0;
   }


   ////////////////////////////
   // Accessor style methods //
   ////////////////////////////

   /** Returns the first element in this list. */
   @Override
   public T first() {
      if (isEmpty()) {
         throw new NoSuchElementException();
      }
      return elements[0];
   }

   /** Returns the last element in this list. */
   @Override
   public T last() {
      if (isEmpty()) {
         throw new NoSuchElementException();
      }
      return elements[size];
   }

   /** Returns true if this list contains element, false otherwise. */
   @Override
   public boolean contains(T element) {
      return locate(element) >= 0;
   }

   /**
    * Return the index of the specified element in the
    * array or -1 if not present.
    */
   private int locate(T element) {
      for (int i = 0; i < size; i++) {
         if (elements[i].equals(element)) {
            return i;
         }
      }
      return -1;
   }

   /** Returns the number of elements in this list. */
   @Override
   public int size() {
      return size;
   }

   /** Returns true if this list is empty, false otherwise. */
   @Override
   public boolean isEmpty() {
      return size == 0;
   }

   /**
    * Returns true if number of elements in this list is the same
    * as the capacity of the array.
    */
   private boolean isFull() {
      return size == elements.length;
   }

   /**
    * Returns true if the number of elements in this list is strictly less than
    * 25% of the capacity of the elements array.
    */
   private boolean isSparse() {
      return (size > 0) && (size < elements.length / 4);
   }

   /**
    * Return true if the specified index is a valid index for this list,
    * false otherwise.
    */
   private boolean validIndex(int index) {
      return (index >= 0) && (index < size);
   }

   /**
    * Returns the element at the specified position in the list.
    */
   @Override
   public T get(int index) {
      if (!validIndex(index)) {
         throw new IndexOutOfBoundsException();
      }
      return elements[index];
   }

   /**
    * Returns the index of the first occurrence of the specified element in this list,
    * or -1 if if this list does not contain the specified element.
    */
   @Override
   public int indexOf(T element) {
      return locate(element);
   }

   /**
    * Returns a string representation of this list.
    */
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      for (int i = 0; i < size; i++) {
         sb.append(elements[i] + ", ");
      }
      sb.delete(sb.length() - 2, sb.length());
      sb.append("]");
      return sb.toString();
   }

   /** Provides an iterator over the elements in this list. */
   @Override
   public Iterator<T> iterator() {
      return new ArrayIterator();
   }

   /**
    * Provides iteration behavior over the elements array. The values are
    * returned in the order in which they appear in the array, from index 0 to
    * index size - 1.
    */
   private class ArrayIterator implements Iterator<T> {
      int current = 0;

      public boolean hasNext() {
         return current < size;
      }

      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         return elements[current++];
      }

      public void remove() {

      }
   }


   ////////////////////////////////
   // Add methods, plus a setter //
   ////////////////////////////////

   /**
    * Appends the element to the end of this list.
    * Returns true if element was added to the list, false otherwise.
    */
   @Override
   public boolean add(T element) {
      return add(size, element);
   }

   /**
    * Inserts the element at the specified position in this list.
    * Returns true if element was added to the list, false otherwise.
    */
   @Override
   public boolean add(int index, T element) {
      if (index == size) {
         return add(element);
      }
      if (!validIndex(index)) {
         throw new IndexOutOfBoundsException();
      }
      if (isFull()) {
         resize(size * 2);
      }
      shiftRight(index);
      elements[index] = element;
      size++;
      return true;
   }

   /**
    * Replaces the element at the specified position in this list with
    * the specified element. Returns the element previously at the specified
    * position.
    */
   @Override
   public T set(int index, T element) {
      if (!validIndex(index)) {
         throw new IndexOutOfBoundsException();
      }
      T oldElement = elements[index];
      elements[index] = element;
      return oldElement;
   }


   ////////////////////
   // Remove methods //
   ////////////////////

   /**
    * Removes a single instance of element from this list.
    * Returns true if element was removed, false otherwise.
    */
   @Override
   public boolean remove(T element) {
      int loc = locate(element);
      if (loc < 0) {
         return false;
      }
      return remove(loc) != null;
   }

   /**
    * Removes the element at the specified position in this list, if it exists.
    */
   @Override
   public T remove(int index) {
      if (index == size) {
         return removeLast();
      }
      if (!validIndex(index)) {
         throw new IndexOutOfBoundsException();
      }
      final T element = elements[index];
      shiftLeft(index + 1);
      elements[--size] = null;
      if (isSparse()) {
         resize(elements.length / 2);
      }
      return element;
   }

   /**
    * Removes and returns a reference to the first element in this list.
    * Returns null if the list is empty.
    */
   @Override
   public T removeFirst() {
      if (isEmpty()) {
         throw new NoSuchElementException();
      }
      return remove(0);
   }

   /**
    * Removes and returns a reference to the last element in this list.
    * Returns null if the list is empty.
    */
   @Override
   public T removeLast() {
      if (isEmpty()) {
         throw new NoSuchElementException();
      }
      return remove(size - 1);
   }


   //////////////////////////////////////////////
   // Utilities used by add and remove methods //
   //////////////////////////////////////////////

   /**
    * Reassign elements to a new array of capacity newSize with the
    * current elements of the array copied over.
    */
   private void resize(int newSize) {
      assert newSize > 0;
      @SuppressWarnings("unchecked")
      T[] newArray = (T[]) new Object[newSize];
      System.arraycopy(elements, 0, newArray, 0, size);
      elements = newArray;
   }

   /**
    * Shifts elements[loc] through elements[size - 1] to the right
    * by one position.
    */
   private void shiftRight(int loc) {
      assert size < elements.length;
      for (int i = size; i > loc; i--) {
         elements[i] = elements[i - 1];
      }
      // Is the following statement necessary?
      // It causes the method to do more than its name implies.
      elements[loc] = null;
   }

   /**
    * Shifts elements[loc] through elements[size - 1] to the left
    * by one position.
    */
   private void shiftLeft(int loc) {
      for (int i = loc; i < size; i++) {
         elements[i - 1] = elements[i];
      }
      // Is the following statement necessary?
      // It causes the method to do more than its name implies.
      elements[size - 1] = null;
   }

}
