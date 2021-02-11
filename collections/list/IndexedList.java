/**
 * IndexedList.java
 * A list in which order is defined as an indexed sequence of elements.
 * The user of this interface has precise control over where in the list
 * each element is inserted.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-09-30
 */
public interface IndexedList<T> extends List<T> {

   /**
    * Appends the element to the end of this list.
    * Returns true if element was added to the list, false otherwise.
    */
   boolean add(T element);

   /**
    * Inserts the element at the specified position in this list.
    * Returns true if element was added to the list, false otherwise.
    */
   boolean add(int index, T element);

   /**
    * Replaces the element at the specified position in this list with
    * the specified element. Returns the element previously at the specified
    * position.
    */
   T set(int index, T element);

   /**
    * Returns the element at the specified position in the list.
    */
   T get(int index);

   /**
    * Returns the index of the first occurrence of the specified element in this list,
    * or -1 if if this list does not contain the specified element.
    */
   int indexOf(T element);

   /**
    * Removes the element at the specified position in this list, if it exists.
    */
   T remove(int index);
}
