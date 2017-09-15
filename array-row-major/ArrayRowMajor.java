/**
 * Illustrates row-major order in an array.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-09-14
 */
public class ArrayRowMajor {

    // arrays need to be square

    static String[][] array2d = {
        {"A", "B", "C"},
        {"D", "E", "F"},
        {"G", "H", "I"}
    };

    static String[] array1d = {
        "a", "b", "c", "d", "e", "f", "g", "h", "i"
    };


    /** Accesses the 2d array by row, col. */
    private static String get2dByRowCol(int row, int col) {
        return array2d[row][col];
    }

    /** Accesses the 2d array by row-major position. */
    private static String get2dByRowMajor(int rowMajor) {
        int row = rowMajor / array2d.length;
        int col = rowMajor % array2d.length;
        return array2d[row][col];
    }

    /** Accesses the 1d array by row, col. */
    private static String get1dByRowCol(int row, int col) {
        int size = (int) Math.sqrt(array1d.length);
        int rowMajor = row * size + col;
        return array1d[rowMajor];
    }

    /** Accesses the 1d array by row-major position. */
    private static String get1dByRowMajor(int rowMajor) {
        return array1d[rowMajor];
    }

    /** Drives execution. */
    public static void main(String[] args) {

        // print the 2d array via row, col access
        for (int row = 0; row < array2d.length; row++) {
            for (int col = 0; col < array2d[0].length; col++) {
                System.out.print(get2dByRowCol(row, col));
                System.out.print(" ");
            }
        }
        System.out.println();

        // print the 2d array via row-major access
        int size = array2d.length * array2d[0].length;
        for (int rowMajor = 0; rowMajor < size; rowMajor++) {
            System.out.print(get2dByRowMajor(rowMajor));
            System.out.print(" " );
        }
        System.out.println();

        // print the 1d array via row, col access
        size = (int) Math.sqrt(array1d.length);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(get1dByRowCol(row, col));
                System.out.print(" ");
            }
        }
        System.out.println();

        // print the 1d array via row-major access
        for (int rowMajor = 0; rowMajor < array1d.length; rowMajor++) {
            System.out.print(get1dByRowMajor(rowMajor));
            System.out.print(" " );
        }
        System.out.println();

    }
}
