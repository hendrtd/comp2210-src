/**
 * Example client for Dijkstra.java.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-04-12
 */
public class ExampleClient {

	/** Drives execution. */
	public static void main(String[] args) {
		int[][] graph = {
							{0, 10, 5, -1, -1},
							{-1, 0, 2, 1, -1},
							{-1, 3, 0, 9, 2},
							{-1, -1, -1, 0, 4},
							{7, -1, -1, 6, 0},
						};

		Dijkstra edsger = new Dijkstra(graph, 0);
		System.out.println(edsger);
	}
}
