import java.util.Iterator;

/**
 * Node-based implementation of the IndexList interface.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-20
 */
public class LinkedIndexedList<T> implements IndexedList<T> {

	/** reference to the first node in the list. */
	private Node front;

	/** reference to the last node in the list. */
	private Node rear;

	/** number of elements in list. */
	private int size;

	/** Constructs an instance of this list. */
	public LinkedIndexedList() {
		front = null;
		rear = null;
		size = 0;
	}

	/** Returns the first element in this list. */
	public T first() {
		return null;
	}

	/** Returns the last element in this list. */
	public T last() {
		return null;
	}

	/** Removes the first element in this list. */
	public T removeFirst() {
		return null;
	}

	/** Removes the last element in this list. */
	public T removeLast() {
		return null;
	}

	/** Removes the specified element from this list. */
	public T remove(T element) {
		return null;
	}

	/** Returns true if this list has no elements, false otherwise. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Returns the number of elements in this list. */
	public int size() {
		return size;
	}

	/** Returns an iterator over the elements in this list. */
	public Iterator<T> iterator() {
		return null;
	}

	/** Returns a string representation of this list. */
	public String toString() {
		return "";
	}

	/** Adds the given element at the specified index in this list. */
	public boolean add(T element, int index) {
		if (index == size) {
			return add(element);
		}
		if (!validIndex(index)) {
			return false;
		}
		Node n = new Node(element);
		if (index == 0) {
			n.next = front;
			front.prev = n;
			front = n;
		} else {
			Node p = front;
			for (int i = 0; i < index; i++) {
				p = p.next;
			}
			n.next = p;
			n.prev = p.prev;
			p.prev.next = n;
			p.prev = n;
		}
		size++;
		return true;
	}

	/** Adds the given element at the end of this list. */
	public boolean add(T element) {
		Node n = new Node(element);
		if (isEmpty()) {
			front = n;
			rear = n;
		} else {
			n.prev = rear;
			rear.next = n;
			rear = n;
		}
		size++;
		return true;
	}

	/** Replaces the current element at the specified index with the given elemeent. */
	public boolean set(T element, int index) {
		return false;
	}

	/** Returns the element at the given index in this list. */
	public T get(int index) {
		return null;
	}

	/** Returns the index of the specified element in this list. */
	public int indexOf(T element) {
		return -1;
	}

	/** Removes the element at the specified index in this list. */
	public T remove(int index) {
		return null;
	}

	/** Returns true if specified index is in the legal range, false otherwise. */
	private boolean validIndex(int index) {
		return (index >= 0) && (index < size);
	}

	/** Doubly-linked node class. */
	private class Node {
		private T element;
		private Node next;
		private Node prev;

		/** Construct an instance of the node class. */
		public Node(T elmnt) {
			element = elmnt;
			next = null;
			prev = null;
		}
	}


}
