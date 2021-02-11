/**
 * Describes the abstract behavior of a FIFO queue.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-10-16
 * 
 */
public interface Queue<T> extends Iterable<T> {

    /** Add one element to the rear of this queue. */
    void enqueue(T element);

    /** Remove and return the front element of this queue. */
    T dequeue();

    /** Return without removing the front element of this queue. */
    T first();

    /** Returns true if this queue contains no elements. */
    boolean isEmpty();

    /** Returns the number of elements in this queue. */
    int size();
}
