/**
 * Client for LinkedIndexedList.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-27
 */
public class LinkedIndexedListClient {

	/** Drives execution. */
	public static void main(String[] args) {
		LinkedIndexedList<String> list = new LinkedIndexedList<>();
		list.add("A");
		list.add("B");

		list = new LinkedIndexedList<>();
		list.add("A", 0);
		list.add("B", 1);
		list.add("C", 2);
		list.add("D", 3);

		list.add("E", 5);

		list.add("E", 2);
	}
}
