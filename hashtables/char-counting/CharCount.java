import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * CharCount.java
 * Counts the number of occurrences of each character in an input string.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-11-18
 */
public class CharCount {

	/** Drives execution. */
	public static void main(String[] args) {
		String input = "the quick brown fox jumps over the lazy dog";
		String text = new Scanner(input).useDelimiter("\\Z").next();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < text.length(); i++) {
			String ch = text.charAt(i) + "";
			Integer count = map.get(ch);
			if (count == null) {
				count = 0;
			}
			map.put(ch, count + 1);
		}
		System.out.println(map);
	}
}
