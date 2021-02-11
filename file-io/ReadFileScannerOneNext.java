import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Reads a text file into a String with a Scanner and one call
 * to next().
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-12-04
 */
public class ReadFileScannerOneNext {

	/** Drives execution. */
	public static void main(String[] args) {
        try {
        	File file = null;
			if (args.length > 0) {
				file = new File(args[0]);
			} else {
				file = new File("ReadFileScannerOneNext.java");
			}
            String text = new Scanner(file).useDelimiter("\\Z").next();
            System.out.println(text);
        }
        catch (IOException e) {
            System.out.println("Error loading file: " + e);
        }
	}

}
