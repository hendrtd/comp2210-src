/**
 * Client for ArrayIndexedList.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-02-25
 */
public class ArrayIndexedListClient {

	/** Drives execution. */
	public static void main(String[] args) {
		ArrayIndexedList<String> list = new ArrayIndexedList<>(5);
		list.add("A");
		list.add("B");

		list = new ArrayIndexedList<>(5);
		list.add("A", 0);
		list.add("B", 1);
		list.add("C", 2);
		list.add("D", 3);

		list.add("E", 5);

		list.add("E", 2);
      
	    list.add("F");
	}
}
