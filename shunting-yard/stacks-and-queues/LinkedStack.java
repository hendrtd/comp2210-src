import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Node-based implementation of the Stack interface.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-04-06
 */
public class LinkedStack<T> implements Stack<T> {

	// reference to the top of the stack
	private Node top;

	// number of values in the stack
	private int size;

	/** Create an instance of the LinkedStack class. */
	public LinkedStack() {
		top = null;
		size = 0;
	}

    /** Add one element to the top of this stack. */
    @Override
    public void push(T element) {
    	top = new Node(element, top);
    	size++;
    }

    /** Remove and return the top element of this stack. */
    @Override
    public T pop() {
    	if (isEmpty()) {
    		return null;
    	}
    	T topValue = top.element;
    	top = top.next;
    	size--;
    	return topValue;
    }

    /** Return without removing the top element of this stack. */
    @Override
    public T peek() {
    	if (isEmpty()) {
    		return null;
    	}
    	return top.element;
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
    	result.append("top [");
    	for (T value : this) {
    		result.append(value);
    		result.append(", ");
    	}
    	result.delete(result.length() - 2, result.length());
    	result.append("]");
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
		Node current = top;

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
