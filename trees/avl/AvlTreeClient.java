/**
 * Provides a sample client for the AvlTree class.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-05-02
 */
public class AvlTreeClient {

	/** Drives execution. */
	public static void main(String[] args) {
        Integer[] values = {10,85,15,70,20,60,30,50,65,80,90,40,5,55};
        AvlTree<Integer> avl = new AvlTree<>();
        for (Integer value : values) {
            avl.add(value);
        }
        System.out.println(avl);
        System.out.println(avl.size());
	}
}
