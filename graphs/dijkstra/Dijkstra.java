import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An implementation of Dijkstra's algorithm for single-source,
 * all-destinations LCP in weighted directed graphs.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-04-12
 */
public class Dijkstra {

	/** The graph. */
	int[][] graph;

	/** Cost of LCP from source to each vertex. */
	int[] cost;

	/** Predecessor of each vertex on LCP from source. */
	int[] path;

	/** Run Dijkstra's algorithm on the given graph from the given source. */
	public Dijkstra(int[][] g, int source) {
		graph = new int[g.length][g[0].length];
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[i].length; j++) {
				graph[i][j] = g[i][j];
			}
		}
		lcp(source);
	}

	/** Returns a String representation of cost and path. */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("cost = ");
		result.append(Arrays.toString(cost));
		result.append("\n");
		result.append("path = ");
		result.append(Arrays.toString(path));
		result.append("\n");
		return result.toString();
	}

	/** Computes LCP from source to all vertices. */
	public void lcp(int source) {
		// initialize cost
		cost = Arrays.copyOf(graph[source], graph.length);

		// initialize path
		path = new int[graph.length];
		for (int vertex = 0; vertex < graph.length; vertex++) {
			if (graph[source][vertex] >= 0) {
				path[vertex] = source;
			} else {
				path[vertex] = -1;
			}
		}

		// initialize list of unsettled vertices
		List<Integer> unsettled = new ArrayList<>();
		for (int i = 0; i < graph.length; i++) {
			if (i != source) {
				unsettled.add(i);
			}
		}

		// settle all vertices
		while (!unsettled.isEmpty()) {
			int vertex = getMin(unsettled);
			unsettled.remove((Integer)vertex);
			int[] neighbors = getNeighbors(vertex);
			for (int neighbor : neighbors) {
				int costThroughVertex = cost[vertex] + graph[vertex][neighbor];
				if ((cost[neighbor] < 0) || (cost[neighbor] > costThroughVertex)) {
					cost[neighbor] = costThroughVertex;
					path[neighbor] = vertex;
				}
			}
		}
	}

	/** Returns the vertex with minimum cost. */
	private int getMin(List<Integer> vertexList) {
		assert !vertexList.isEmpty();
		int min = vertexList.iterator().next();
		for (int vertex : vertexList) {
			if ((cost[vertex] > 0) && (cost[vertex] < cost[min])) {
				min = vertex;
			}
		}
		return min;
	}

	/** Returns the vertices adjacent to the given vertex. */
	private int[] getNeighbors(int vertex) {
		int[] neighbors = new int[graph.length];
		int count = 0;
		for (int v = 0; v < graph.length; v++) {
			if (graph[vertex][v] > 0) {
				neighbors[count] = v;
				count++;
			}
		}
		return Arrays.copyOf(neighbors, count);
	}

	/** Drives execution. */
	public static void main(String[] args) {
		int[][] graph = {{0, 2, -1, -1, 6, 16, 14},
						 {-1, 0, 8, 3, 7, -1, -1},
						 {-1, -1, 0, -1, -1, -1, 1},
						 {-1, -1, -1, 0, -1, 4, 10},
						 {-1, -1, -1, -1, 0, 5, -1},
						 {-1, -1, -1, -1, -1, 0, 3},
						 {-1, -1, -1, -1, -1, -1, 0},
						};
		Dijkstra edsger = new Dijkstra(graph, 0);
		System.out.println(edsger);		
	}

}
