/**
 * Describes the abstract behavior of a LIFO stack.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-10-16
 * 
 */
public interface Stack<T> extends Iterable<T> {

    /** Add one element to the top of this stack. */
    void push(T element);

    /** Remove and return the top element of this stack. */
    T pop();

    /** Return without removing the top element of this stack. */
    T peek();

    /** Returns true if this stack contains no elements. */
    boolean isEmpty();

    /** Returns the number of elements in this stack. */
    int size();
}
