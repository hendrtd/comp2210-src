/**
 * Provides a sample client for the RedBlackTree class.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-05-03
 */
public class RedBlackTreeClient {

	/** Drives execution. */
	public static void main(String[] args) {
        Integer[] values = {10,85,15,70,20,60,30,50,65,80,90,40,5,55};
        RedBlackTree<Integer> rbtree = new RedBlackTree<>();
        for (Integer value : values) {
            rbtree.add(value);
        }
        System.out.println(rbtree);
        System.out.println(rbtree.size());
	}
}
