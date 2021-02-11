/**
 * FiveChooseFour.java Illustrates a strategy for creating the combination of
 * five things taken four at a time.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-02-17
 */
public class FiveChooseFour {

    /**
     * Generate the combination of the integers [1..5] taken four at a time.
     */
    public static void fiveChooseFour() {
        for (int a = 1; a <= 5; a++) {
            for (int b = a + 1; b <= 5; b++) {
                for (int c = b + 1; c <= 5; c++) {
                    for (int d = c + 1; d <= 5; d++) {
                        System.out.println(a + ", " + b + ", " + c + ", " + d);
                    }
                }
            }
        }
    }

    /** Drives execution. */
    public static void main(String[] args) {
        fiveChooseFour();
    }
}


/*


RUNTIME OUTPUT:

dean (master *) combinations $ java FiveChooseFour
1, 2, 3, 4
1, 2, 3, 5
1, 2, 4, 5
1, 3, 4, 5
2, 3, 4, 5

 */
