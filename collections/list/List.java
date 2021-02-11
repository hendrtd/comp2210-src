/**
 * List.java
 * The root interface in the list hierarchy. A list is an ordered collection in which
 * duplicates are allowed but nulls are not. Neither a specific order nor a specific
 * means of ordered access is specified in this interface. Subinterfaces will specify
 * the nature of the order and the means of ordered access.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-09-30
 */
public interface List<T> extends Iterable<T> {

   /** Returns the first element in this list. */
   T first();

   /** Returns the last element in this list. */
   T last();

   /** Returns true if this list contains element, false otherwise. */
   boolean contains(T element);

   /**
    * Removes a single instance of element from this list.
    * Returns true if element was removed, false otherwise.
    */
   boolean remove(T element);

   /**
    * Removes and returns a reference to the first element in this list.
    */
   T removeFirst();

   /**
    * Removes and returns a reference to the last element in this list.
    */
   T removeLast();

   /** Returns the number of elements in this list. */
   int size();

   /** Returns true if this list is empty, false otherwise. */
   boolean isEmpty();

}
