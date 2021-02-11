/**
 * SortedList.java
 * A list in which order is defined as the natural order of its elements.
 * All elements inserted into a sorted list must implement the Comparable
 * interface. Furthermore, all elements must be mutually comparable. That is,
 * e1.compareTo(e2) must not throw a ClassCastException for any elements
 * e1 and e2 in the sorted list.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-09-30
 */
public interface SortedList<T> extends List<T> {

   /**
    * Ensures that this list contains the specified element.
    * Returns true if element was added, false otherwise.
    */
   boolean add(T element);
}
