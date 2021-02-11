import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implements the DisjointSet interface with the union
 * operation optimized. Ack: Kevin Wayne.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2019-04-19
 *
 */
public class FastUnionDS implements DisjointSet {

	/** component ids: id[i] = component id of vertex i. */
	private int[] id;

	/** number of components. */
	private int count;

	/**
	 * instantiate N disjoint components [0..N-1]
	 */
	public FastUnionDS(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
        }
	}

	/**
	 * combine components containing p and q
	 */
	public void union(int p, int q) {
		int pid = find(p);
		int qid = find(q);
		if (pid == qid) {
			return;
        }

		id[pid] = qid;
		count--;
	}
	
	/**
	 * return component id for p
	 */
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}
	
	/**
	 * are p and q in the same component?
	 */
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	/**
	 * return number of connected components
	 */
	public int count() {
		return count;
	}

	/** Return an array representation of this. */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(java.util.Arrays.toString(id));
		result.append("   ");

		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < id.length; i++) {
			List<Integer> vertices = map.get(find(i));
			if (vertices == null) {
				vertices = new ArrayList<Integer>();
			}
			vertices.add(i);
			map.put(find(i), vertices);
		}
		for (Integer component : map.keySet()) {
			result.append(map.get(component).toString().replace('[','{').replace(']','}'));
			result.append(" ");
		}
		return result.toString();
	}

    /**
     * Return a tikz string of the id array.
     */
    public String toTikzString() {
        StringBuilder result = new StringBuilder();

        result.append("\\begin{tabular}");
        result.append("{|");
        for (int i = 0; i < id.length; i++) {
            result.append("c|");
        }
        result.append("}\n");
        result.append("\\hline\n");

        for (int value : id) {
            result.append(value + " & ");
        }
        result.delete(result.length() - 2, result.length());
        result.append(" \\\\ \\hline\n");

        for (int i = 0; i < id.length; i++) {
            result.append("\\multicolumn{1}{c}" + i + " &\n");
        }
        result.delete(result.length() - 2, result.length());
        result.append("\n");

        result.append("\\end{tabular}\n");

        return result.toString();
    }
	

}