import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Provides an implementation of an AVL tree.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-05-02
 */
public class AvlTree<T extends Comparable<T>> implements Iterable<T> {


	/////////////////
	//   Fields    //
	/////////////////

	// the root of this avl tree
	private Node root;

	// the number of nodes in this avl tree
	private int size;

	/** The Node structure for this avl tree. */
	private class Node {
		private T element;
		private Node left;
		private Node right;
		private int height;

		/** Constructs a node containing the given element. */
		public Node(T elem) {
			element = elem;
			height = 1;
		}
	}


	////////////////////////
	//   Adding values    //
	////////////////////////

	/** Ensures this avl tree contains the specified element. */
	public void add(T element) {
		root = put(element, root);
	}

	/** Adds the specified value, if not already present, to this avl tree. */
	private Node put(T element, Node n) {
		// recursively walk down into the tree to add element
        if (n == null) {
            size++;
            return new Node(element);
        }
        int cmp = element.compareTo(n.element);
        if (cmp < 0) {
            n.left = put(element, n.left);
        } else if (cmp > 0) {
            n.right = put(element, n.right);
        }

        // backtrack to the root, rebalancing as needed
        n.height = 1 + Math.max(height(n.left), height(n.right));
        return rebalance(n);
	}



	/////////////////////////////////
	//   Rebalancing operations    //
	/////////////////////////////////

	/** Rebalance the 3-node neighborhood rooted at n, if needed. */
	private Node rebalance(Node n) {
		if (balanceFactor(n) == 2) {
			if (balanceFactor(n.right) < 0) {
				n.right = rotateRight(n.right);
			}
			n = rotateLeft(n);
		} else if (balanceFactor(n) == -2) {
			if (balanceFactor(n.left) > 0) {
				n.left = rotateLeft(n.left);
			}
			n = rotateRight(n);		
		}
		return n;
	}

	/** Rotate left over the n. */
	private Node rotateLeft(Node n) {
		Node m = n.right;
		n.right = m.left;
		m.left = n;
		n.height = 1 + Math.max(height(n.left), height(n.right));
		m.height = 1 + Math.max(height(m.left), height(m.right));
		return m;	
	}

	/** Rotate right over the n. */
	private Node rotateRight(Node n) {
		Node m = n.left;
		n.left = m.right;
		m.right = n;
		n.height = 1 + Math.max(height(n.left), height(n.right));
		m.height = 1 + Math.max(height(m.left), height(m.right));
		return m;	
	}

	/** Returns the balance factor of n. */
	private int balanceFactor(Node n) {
		return height(n.right) - height(n.left);
	}


	//////////////////////////////
	//   Metrics on the tree    //
	//////////////////////////////
	
	/** Returns the number of values in this avl tree. */
	public int size() {
		return size;
	}

	/** Returns the height of this avl tree. */
	public int height() {
		return height(root);
	}


	/** Returns the height of the given node. */
	private int height(Node n) {
		if (n == null) {
			return 0;
		}
		return n.height;
	}



	//////////////////////////////////
	//   toString and traversals    //
	//////////////////////////////////

    /**
     * Returns a string representation of the elements in this avl tree listed in
     * ascending natural order.
     */
    @Override
    public String toString() {
        return inorderList(root).toString();
    }

    /**
     * Returns a List containing the elements of this avl tree in ascending natural order.
     */
    private List<T> inorderList(Node n) {
        List<T> list = new ArrayList<>();
        buildInorderList(root, list);
        return list;
    }

    /**
     * Builds list from the elements of this avl tree in ascending natural order.
     */
    private void buildInorderList(Node n, List<T> list) {
        if (n != null) {
            buildInorderList(n.left, list);
            list.add(n.element);
            buildInorderList(n.right, list);
        }
    }



	////////////////////
	//   Iteration    //
	////////////////////

	/** Returns an iterator over the values in this avl tree. */
	@Override
	public Iterator<T> iterator() {
        return inorderList(root).iterator();      
	}

}
