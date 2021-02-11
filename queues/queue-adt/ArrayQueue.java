import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A circular array implementation of the Queue interface.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-04-06
 */
public class ArrayQueue<T> implements Queue<T> {

	// stores the elements in the queue
	private T[] elements;

	// index of the front element
	private int front;

	// index of the next insertion point
	private int rear;

	// number of elements in the queue
	private int size;

	/** Creates an instance of an ArrayQueue. */
	public ArrayQueue() {
		this(5);
	}

	/** Creates an instance of an ArrayQueue. */
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		elements = (T[]) new Object[capacity];
		front = 0;
		rear = 0;
		size = 0;
	}

    /** Add one element to the rear of this queue. */
    @Override
    public void enqueue(T element) {
    	if (size() == elements.length) {
    		resize(elements.length * 2);
    	}
    	elements[rear] = element;
    	rear = (rear + 1) % elements.length;
    	size++;
    }

    /** Remove and return the front element of this queue. */
    @Override
    public T dequeue() {
    	if (isEmpty()) {
    		return null;
    	}
    	T result = elements[front];
    	elements[front] = null;
    	front = (front + 1) % elements.length;
    	size--;
    	return result;
    }

    /** Return without removing the front element of this queue. */
    @Override
    public T first() {
    	if (isEmpty()) {
    		return null;
    	}
    	return elements[front];
    }

    /** Returns true if this queue contains no elements. */
    @Override
    public boolean isEmpty() {
    	return size() == 0;
    }

    /** Returns the number of elements in this queue. */
    @Override
    public int size() {
    	return size;
    }

    /** Returns in iterator over the elements in this queue. */
    @Override
    public Iterator<T> iterator() {
    	return new ArrayIterator();
    }

    /** Return a String representation of this ArrayStack */
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

    /** Resize the elements array to the specified new size, copying elements over as possible. */
    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
    	assert newSize > 0;
    	assert newSize >= size();
    	T[] newArray = (T[]) new Object[newSize];
    	int i = 0;
    	int j = front;
    	for (int k = 0; k < size; k++) {
    		newArray[i] = elements[j];
    		i++;
    		j = (j + 1) % elements.length;
    	}
    	elements = newArray;
    	front = 0;
    	rear = size;
    }

    /**
     * Implements iterator behavior for an array.
     */
    private class ArrayIterator implements Iterator<T> {
    	
    	// index before next element in iteration
    	private int current = front;

    	/** Returns true if there is a next element to return, false otherwise. */
    	public boolean hasNext() {
    		return current != rear;
    	}

    	/** Returns the next element if it exists, throws exception otherwise. */
    	public T next() {
    		if (!hasNext()) {
    			throw new NoSuchElementException();
    		}
    		T result = elements[current];
    		current = (current + 1) % elements.length;
    		return result;
    	}

    	/** Benign optional implementation of remove.  */
    	public void remove() {

    	}

    }

}
