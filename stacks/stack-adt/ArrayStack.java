import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array-based implementation of the Stack interface.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-04-06
 */
public class ArrayStack<T> implements Stack<T> {

	// holds the values in the stack
	private T[] elements;

	// index of the next insertion point
	private int top;

	/** Create an instance of the ArrayStack class. */
	public ArrayStack() {
		this(5);
	}

	/** Create an instance of the ArrayStack class. */
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		elements = (T[]) new Object[capacity];
		top = 0;
	}

    /** Add one element to the top of this stack. */
    @Override
    public void push(T element) {
    	if (size() == elements.length) {
    		resize(elements.length * 2);
    	}
    	elements[top++] = element;
    }

    /** Remove and return the top element of this stack. */
    @Override
    public T pop() {
    	if (isEmpty()) {
    		return null;
    	}
    	T topValue = elements[--top];
    	elements[top] = null;
    	return topValue;
    }

    /** Return without removing the top element of this stack. */
    @Override
    public T peek() {
    	if (isEmpty()) {
    		return null;
    	}
    	return elements[top - 1];
    }

    /** Returns true if this stack contains no elements. */
    @Override
    public boolean isEmpty() {
    	return size() == 0;
    }

    /** Returns the number of elements in this stack. */
    @Override
    public int size() {
    	return top;
    }

    /** Returns an iterator over the values in this stack. */
    @Override
    public Iterator<T> iterator() {
    	return new ArrayIterator();
    }

    /** Return a String representation of this ArrayStack */
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

    /** Resize the elements array to the specified new size, copying elements over as possible. */
    private void resize(int newSize) {
    	assert newSize > 0;
    	assert newSize >= size();
    	@SuppressWarnings("unchecked")
    	T[] newArray = (T[]) new Object[newSize];
    	System.arraycopy(elements, 0, newArray, 0, size());
    	elements = newArray;
    }

    /**
     * Implements iterator behavior for an array.
     */
    private class ArrayIterator implements Iterator<T> {
    	
    	// index before next element in iteration
    	private int current = top;

    	/** Returns true if there is a next element to return, false otherwise. */
    	public boolean hasNext() {
    		return current > 0;
    	}

    	/** Returns the next element if it exists, throws exception otherwise. */
    	public T next() {
    		if (!hasNext()) {
    			throw new NoSuchElementException();
    		}
    		return elements[--current];
    	}

    	/** Benign optional implementation of remove.  */
    	public void remove() {

    	}

    }
}
