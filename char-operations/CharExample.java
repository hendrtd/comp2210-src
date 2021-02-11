/**
 * Example involving the char type.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 1.0
 */
public class CharExample {

	/** Drives execution. */
	public static void main(String[] args) {
		printLowerCaseAlphabet();
	}


	/**
	 * Prints the alphabet.
	 */
	public static void printLowerCaseAlphabet() {
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.print(ch + " ");
		}
		System.out.println();
	}
}
