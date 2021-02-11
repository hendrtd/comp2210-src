import java.util.Arrays;
import java.util.Random;

/**
 * Generate random strings.
 *
 */
public class GetRandomStrings {

    /** Drives execution. */
    public static void main(String[] args) {

        // generate an array of ints in a specific range
        int size = 10;
        int from = 'A';
        int to = 'Z' + 1;
        int[] intArray = new Random().ints(size, from, to).toArray();
        System.out.println(Arrays.toString(intArray));

        // create an array of strings from the array of ints
        // String[] stringArray = Arrays.stream(intArray)
        //                             //.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        //                             .mapToObj(i -> (char)i)
        //                             .mapToObj(String::valueOf)
        //                             .toArray(String[]::new);

        String[] stringArray = Arrays.stream(intArray)
                                    .mapToObj(numbers -> Character.toString(numbers))
                                    .toArray(String[]::new);
        // String[] stringArray = new String[size];
        // for (char ch : intArray) {

        // }
        System.out.println(Arrays.toString(stringArray));                
    }
}
