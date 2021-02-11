/**
 * Abstract behavior of a list that maintains its elements natural order of its elements.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-19
 */
public interface SortedList<T extends Comparable<T>> extends List<T> {

	/** Adds the given element to this list. */
	boolean add(T element);
	
}
