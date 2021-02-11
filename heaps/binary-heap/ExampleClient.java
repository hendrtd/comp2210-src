/**
 * Example client for the BinaryHeap class.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-04-15
 */
public class ExampleClient {

	/** Drives execution. */
	public static void main(String[] args) {
		BinaryHeap<Integer> heap = new BinaryHeap<>();
		int[] values = {60, 80, 50, 40, 30, 70};
		for (int value : values) {
			heap.add(value);
		}
		System.out.println(heap);
		for (int i = 0; i < 3; i++) {
		Integer value = heap.remove();
		System.out.println("remove " + value);
		System.out.println(heap);			
		}

	}
}
