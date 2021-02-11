/**
 * Recursive and iterative solutions to the Tower of Hanoi puzzle
 * with three pegs and N disks.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-12
 */
public class Hanoi {

	/** Drives execution. */
	public static void main(String[] args) {
		hanoiRecursiveString(3, "A", "C", "B");
	}

	/** Recursive solution to Tower of Hanoi. Prints optimal sequence of moves. */
	public static void hanoiRecursiveString(int n, String startPeg, String endPeg, String tempPeg) {
		if (n == 1) {
			System.out.println("Move one disk from " + startPeg + " to " + endPeg + ". ");
		} else {
			hanoiRecursiveString(n - 1, startPeg, tempPeg, endPeg);
			System.out.println("Move one disk from " + startPeg + " to " + endPeg + ". ");
			hanoiRecursiveString(n - 1, tempPeg, endPeg, startPeg);
		}
	}
}
