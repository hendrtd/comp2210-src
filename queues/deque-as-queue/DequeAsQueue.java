import java.util.ArrayDeque;
import java.util.Deque;

/**
 * DequeAsQueue.java
 * Illustrates using an ArrayDeque as an implementing class of Deque
 * as a FIFO queue.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-04-06
 */
public class DequeAsQueue {

    /** Drives execution. */
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        queue.addLast(4);
        queue.addLast(5);
        System.out.println(queue);
        queue.removeFirst();
        queue.removeFirst();
        System.out.println(queue);
        queue.addLast(6);
        queue.addLast(7);
        System.out.println(queue);
    }
}

