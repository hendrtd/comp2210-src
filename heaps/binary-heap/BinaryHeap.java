/**
 * An array-based implementation of a min binary heap.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-04-15
 */
public class BinaryHeap<T extends Comparable<? super T>> {

	/** array-based binary heap. */
	private T[] heap;

	/** number of elements in the heap. */
	private int size;

	/** Create a new binary heap. */
	@SuppressWarnings("unchecked")
	public BinaryHeap() {
		heap = (T[]) new Comparable[1];
		size = 0;
	}

	/** Adds the given value to this heap. */
	public void add(T value) {
		if (size == heap.length) {
			resize(2 * size);
		}
		heap[size] = value;
		int child = size;
		size++;
		int parent = parent(child);
		while ((child > 0) && (less(heap[child], heap[parent]))) {
			swap(heap, child, parent);
			child = parent;
			parent = parent(child);
		}
	}

	/** Removes the min value from the heap. */
	public T remove() {
		if (size == 0) {
			return null;
		}
		T result = heap[0];
		heap[0] = heap[--size];
		heap[size] = null;

		heapify();

		return result;
	}

	/** Swaps root value down as far as needed. */
	private void heapify() {
		int i = 0;
		while ((i <= size) && (greater(heap[i], heap[minChild(i)]))) {
			int minChild = minChild(i);
			swap(heap, i, minChild);
			i = minChild;
		}
	}

	/** Returns the left child index of i. */
	private int left(int i) {
		return 2 * i + 1;
	}

	/** Returns the right child index of i. */
	private int right(int i) {
		return 2 * i + 2;
	}

	/** Returns the parent index of i. */
	private int parent(int i) {
		return (i -1) / 2;
	}

	/** Returns index of min child of i. */
	public int minChild(int i) {
		int left = left(i);
		int right = right(i);
		if (left >= size) {
			return i;
		}
		if (right >= size) {
			right = left;
		}
		if (less(heap[left], heap[right])) {
			return left;
		}
		return right;
	}

	/** Swaps the elements at index i and j of a. */
	private void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/** Returns true if val1 < val2. */
	private boolean less(T val1, T val2) {
		return val1.compareTo(val2) < 0;
	}

	/** Returns true if val1 > val2. */
	private boolean greater(T val1, T val2) {
		return val1.compareTo(val2) > 0;
	}

	/** Resizes the array to the given capacity. */
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		T[] a = (T[]) new Comparable[capacity];
		for (int i = 0; i < size; i++) {
			a[i] = heap[i];
		}
		heap = a;
	}

	/** Return a string representation of this heap. */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("[");
		for (int i = 0; i < size; i++) {
			result.append(heap[i]);
			result.append(", ");
		}
		result.delete(result.length() - 2, result.length());
		result.append("]");
		return result.toString();
	}

}
