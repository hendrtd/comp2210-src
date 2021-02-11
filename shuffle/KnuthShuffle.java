/**
 * Implementation of the Knuth (Fisher-Yates) Shuffle.
 * https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
 *
 * @author Dean Hendrix (dh@auburn.edu)
 */
public class KnuthShuffle {

    /** Sample calls. */
    public static void main(String[] args) {
        Integer[] a = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(java.util.Arrays.toString(a));
        for (int i = 0; i < 5; i++) {
            shuffle(a);
            System.out.println(java.util.Arrays.toString(a));
        }
    }

    /** Knuth shuffle. */
    public static void shuffle(Object[] a) {
         int N = a.length;
         java.util.Random rng = new java.util.Random();
         for (int i = N - 1; i > 0; i--) {
            int j = rng.nextInt(i + 1);
            Object temp = a[i];
            a[i] = a[j];
            a[j] = temp;
         }
    }

}
