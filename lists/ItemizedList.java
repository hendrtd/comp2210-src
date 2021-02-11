/**
 * Abstract behavior of a list that keeps its elements in itemized or
 * "bullet point" form.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-20
 */
public interface ItemizedList<T> extends List<T> {

	/** Adds the given element at the front of this list. */
	boolean addToFront(T element);

	/** Adds the given element to the end of this list. */
	boolean addToRear(T element);

	/** Adds the given element after the target element in this list. */
	boolean addAfter(T element, T target);
}
