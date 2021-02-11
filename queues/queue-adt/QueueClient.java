/**
 * Client of the Queue interface and an implementing class.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-04-06
 */
public class QueueClient {

	/** Drives execution. */
	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayQueue<>();
		// Queue<Integer> stack = new LinkedQueue<>();
		queue.enqueue(1);
		System.out.println(queue);
		queue.enqueue(2);
		System.out.println(queue);
		queue.enqueue(3);
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		queue.enqueue(4);
		System.out.println(queue);
		queue.enqueue(queue.dequeue());
		System.out.println(queue);
		queue.enqueue(5);
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);

		arrayWrapAround();

		arrayResize();
	}

	/** Operations shown in ArrayQueue example in note set. */
	private static void arrayWrapAround() {
		Queue<String> queue = new ArrayQueue<>(6);
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue("E");
		queue.enqueue("F");
		queue.enqueue("G");
		queue.enqueue("H");
		System.out.println(queue);
	}

	/** Operations shown in ArrayQueue example in note set. */
	private static void arrayResize() {
		Queue<String> queue = new ArrayQueue<>(3);
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.dequeue();
		queue.dequeue();
		queue.enqueue("D");
		queue.enqueue("E");
		queue.enqueue("F");
		System.out.println(queue);

	}

}
