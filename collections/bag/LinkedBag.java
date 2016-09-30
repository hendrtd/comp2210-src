import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedBag.java
 * Implements bag (multiset) behavior. Duplicates are allowed and no specific
 * order is guaranteed. Method signatures are compatable with the
 * corresponding methods of java.util.Collection, but the semantics of some
 * methods may differ.
 *
 * This implementation is based on a doubly-linked list.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-09-24
 */
public class LinkedBag<T> implements Bag<T> {

   private Node front;
   private int size;

   /**
    * Instantiates an empty bag.
    *
    */
   public LinkedBag() {
      front = null;
      size = 0;
   }

   /**
    * Ensures that this bag contains the specified element. Returns true if the
    * element was added and false otherwise.
    *
    * @param  element the element to be added
    * @return         true if the element was successfully added
    */
   public boolean add(T element) {
      Node n = new Node(element);
      n.next = front;
      if (front != null) {
         front.prev = n;
      }
      front = n;
      size++;
      return true;
   }

   /**
    * Removes a single instance of the specified element from this bag. Returns
    * true if the element was removed and false otherwise.
    *
    * @param  element the element to be removed
    * @return         true if the element was removed
    */
   public boolean remove(T element) {
      Node n = locate(element);
      if (n == null) {
         return false;
      }

      if (size == 1) {
         front = null;
         size = 0;
         return true;
      }

      if (n == front) {
         front = front.next;
         front.prev = null;
      }
      else {
         n.prev.next = n.next;
         if (n.next != null) {
            n.next.prev = n.prev;
         }
      }
      size--;
      return true;
   }

   /**
    * Returns true if this bag contains the specified element and false
    * otherwise.
    *
    * @param  element the element to be searched for
    * @return         true if this bad contains the element
    */
   public boolean contains(T element) {
      return locate(element) != null;
   }

   /**
    * Returns the number of elements in this bag.
    *
    * @return the number of elements in this bag
    */
   public int size() {
      return size;
   }

   /**
    * Returns true if this bag contains no elements and false otherwise.
    *
    * @return true if this bag has no elements
    */
   public boolean isEmpty() {
      return size == 0;
   }

   /**
    * Returns an iterator over the elements in this bag.
    *
    * @return an iterator over the elements in this bag.
    */
   public Iterator<T> iterator() {
      return new LinkedIterator();
   }

   /**
    * Creates a string representation of this collection.
    *
    * @return  string representation of this collection.
    *
    */
   @Override public String toString() {
      String result = "";
      Node n = front;
      while (n != null) {
         result += n.element + " ";
         n = n.next;
      }
      return result + "\n";
   }


   /////////////////////
   // Private methods //
   /////////////////////

   /**
    * Locates the Node that contains element.
    * Can be used in contains for singly-linked nodes,
    * and in both contains and removes for doubly-linked nodes.
    */
   private Node locate(T element) {
      Node n = front;
      while (n != null) {
         if (n.element.equals(element)) {
            return n;
         }
         n = n.next;
      }
      return null;
   }

   ////////////////////
   // Nested classes //
   ////////////////////

   /** Defines a node for a doubly-linked list. */
   private class Node {
      private T element;
      private Node next;
      private Node prev;

      /** Creates a new node. */
      public Node(T e) {
         element = e;
      }

   }

   /** Provides an iterator over the linked list. */
   private class LinkedIterator implements Iterator<T> {
      private Node current = front;

      /** Returns true if more elements are left in the iteration. */
      public boolean hasNext() {
         return current != null;
      }

      /** Returns the next element in the iteration. */
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }

         T result = current.element;
         current = current.next;
         return result;
      }

      /** Unsupported operation. */
      public void remove() {
         throw new UnsupportedOperationException();
      }

   }
}
