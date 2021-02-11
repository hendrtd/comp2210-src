import java.util.Arrays;

/**
 * An implementation of heap sort.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-11-27
 */
public class HeapSort {

	/** Drives execution. */
	public static void main(String[] args) {
		Integer[] values = {20, 12, 35, 15, 10, 80, 30, 17, 2, 1};
		System.out.println(Arrays.deepToString(values));
		HeapSort heapsort = new HeapSort();
		heapsort.makeHeap(values);
		System.out.println(Arrays.deepToString(values));
		heapsort.emptyHeap(values);
		System.out.println(Arrays.deepToString(values));
	}


	/** Heap sort. */
	public void sort(Integer[] a) {
		makeHeap(a);
		emptyHeap(a);		
	}

	/** Transforms the given array into max heap order. */
	public void makeHeap(Integer[] a) {
		Integer i = (a.length - 1) / 2;
		while (i >= 0) {
			heapify(a, i, a.length - 1);
			i--;
		}
	}

	/** Transforms a[start..end] into a max heap. */
	public void heapify(Integer[] a, int start, int end) {
		int i = start;
		while ((i < end) && (a[i] < a[maxChild(a, i, end)])) {
			int maxChild = maxChild(a, i, end);
			swap(a, i, maxChild);
			i = maxChild;
		}
	}

	/** Interchanges a[i] and a[j]. */
	public void swap(Integer[] a, int i, int j) {
		Integer temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/** Returns index of max child of i. */
	public Integer maxChild(Integer[] a, int i, int end) {
		int left = left(i);
		int right = right(i);
		if (left > end) {
			return i;
		}
		if (right > end) {
			right = left;
		}
		if (a[left] > a[right]) {
			return left;
		}
		return right;
	}

	/** Returns the left child of i. */
	public Integer left(int i) {
		return 2 * i + 1;
	}

	/** Returns the right child of i. */
	public Integer right(int i) {
		return 2 * i + 2;
	}

	/** Transforms the given max heap into ascending order. */
	public void emptyHeap(Integer[] a) {
		int heapEnd = a.length - 1;
		while (heapEnd > 0) {
			swap(a, 0, heapEnd);
			heapEnd--;
			heapify(a, 0, heapEnd);
		}
	}
}
