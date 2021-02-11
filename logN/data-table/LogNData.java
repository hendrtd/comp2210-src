/**
 * Generates data to relate, N, lg N, and N^2.
 */
public class LogNData {

    public static void main(String[] args) {
        
        int N = 2;
        System.out.printf("%4s %8s %9s\n", "N", "N^2", "log_2 N");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%4d %8d %9d\n", N, N*N, (int)(Math.log(N) / Math.log(2)));
            N = N * 2;
        }

    }

}
