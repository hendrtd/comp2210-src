/**
 * Client of the Stack interface and an implementing class.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-04-06
 */
public class StackClient {

	/** Drives execution. */
	public static void main(String[] args) {
		// Stack<Integer> stack = new ArrayStack<>();
		Stack<Integer> stack = new LinkedStack<>();
		stack.push(1);
		System.out.println(stack);
		stack.push(2);
		System.out.println(stack);
		stack.push(3);
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		stack.push(4);
		System.out.println(stack);
		stack.push(stack.pop());
		System.out.println(stack);
		stack.push(5);
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
}
}
