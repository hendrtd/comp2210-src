import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Node-based implementation of the Queue interface.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-04-06
 */
public class LinkedQueue<T> implements Queue<T> {

	// the front node
	private Node front;

	// the rear node
	private Node rear;

	// the number of elements in the queue
	private int size;

	/** Create an instance of the LinkedQueue class. */
	public LinkedQueue() {
		front = null;
		rear = null;
		size = 0;
	}

    /** Add one element to the rear of this queue. */
    @Override
    public void enqueue(T element) {
    	Node n = new Node(element, null);
    	if (isEmpty()) {
    		rear = n;
    		front = rear;
    	} else {
    		rear.next = n;
    		rear = n;
    	}
        size++;
    }

    /** Remove and return the front element of this queue. */
    @Override
    public T dequeue() {
    	if (isEmpty()) {
    		return null;
    	}
    	T result = front.element;
    	front = front.next;
    	if (size == 1) {
    		rear = front;
    	}
    	size--;
    	return result;
    }

    /** Return without removing the front element of this queue. */
    @Override
    public T first() {
    	if (isEmpty()) {
    		return null;
    	}
    	return front.element;
    }


    /** Returns true if this stack contains no elements. */
    @Override
    public boolean isEmpty() {
    	return size() == 0;
    }

    /** Returns the number of elements in this stack. */
    @Override
    public int size() {
    	return size;
    }

    /** Returns an iterator over the elements in this LinkedStack. */
    @Override
    public Iterator<T> iterator() {
    	return new LinkedIterator();
    }

    /** Returns a String representation of this LinkedStack. */
    @Override
    public String toString() {
    	StringBuilder result = new StringBuilder();
    	result.append("front [");
    	for (T value : this) {
    		result.append(value);
    		result.append(", ");
    	}
    	result.delete(result.length() - 2, result.length());
    	result.append("] rear");
    	return result.toString();
    }

	/** Singly-linked node structure. */
	private class Node {
		private T element;
		private Node next;

		/** Create a Node instance with the given element and next. */
		public Node(T elmnt, Node nxt) {
			element = elmnt;
			next = nxt;
		}
	}

	/** Provides iterator behavior over a singly-linked list. */
	private class LinkedIterator implements Iterator<T> {

		// the next element in the iteration
		Node current = front;

    	/** Returns true if there is a next element to return, false otherwise. */
    	public boolean hasNext() {
    		return current != null;
    	}

    	/** Returns the next element if it exists, throws exception otherwise. */
    	public T next() {
    		if (!hasNext()) {
    			throw new NoSuchElementException();
    		}
    		T result = current.element;
    		current = current.next;
    		return result;
    	}

    	/** Benign optional implementation of remove.  */
    	public void remove() {

    	}
    }

}
