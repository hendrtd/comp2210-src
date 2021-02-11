/**
 * Example disjoint set data structure client.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-04-19
 */
public class ExampleClient {

	/** Drives execution. */
	public static void main(String[] args) {
		DisjointSet ds = new FastFindDS(10);
		System.out.println("Fast Find:");
		exampleSequence2(ds);
		System.out.println();

		ds = new FastUnionDS(10);
		System.out.println("Fast Union:");
		exampleSequence2(ds);
		System.out.println();

		ds = new PathCompressionDS(10);
		System.out.println("Path Compression:");
		exampleSequence2(ds);
		System.out.println();
		
	}

	/** Example 1. */
	public static void exampleSequence1(DisjointSet ds) {
		ds.union(3, 4);
		ds.union(4, 9);
		ds.union(8, 0);
		ds.union(2, 3);
		ds.union(5, 6);
	}

	/** Example 2. */
	public static void exampleSequence2(DisjointSet ds) {
		System.out.println(ds);
		ds.union(4, 3); System.out.println(ds);
		ds.union(3, 8); System.out.println(ds);
		ds.union(6, 5); System.out.println(ds);
		ds.union(9, 4); System.out.println(ds);
		ds.union(2, 1); System.out.println(ds);
		ds.union(5, 0); System.out.println(ds);
		ds.union(7, 2); System.out.println(ds);
		ds.union(6, 1); System.out.println(ds);
		ds.union(7, 3); System.out.println(ds);
	}
}
