import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Provides an implementation of a Red-Black tree.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-05-03
 */
public class RedBlackTree<T extends Comparable<T>> implements Iterable<T> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;


	/////////////////
	//   Fields    //
	/////////////////

	// the root of this red-black tree
	private Node root;

	// the number of nodes in this red-black tree
	private int size;

	/** The Node structure for this red-black tree. */
	private class Node {
		private T element;
		private Node left;
		private Node right;
		private boolean color;

		/** Constructs a node containing the given element. */
		public Node(T elem) {
			element = elem;
			color = RED;
		}
	}



	////////////////////////
	//   Adding values    //
	////////////////////////

    /**
     * Ensures this bst contains the specified element. Uses an iterative implementation.
     */
    public void add(T element) {
        // special case if empty
        if (root == null) {
            root = new Node(element);
            size++;
            return;
        }

        // find where this element should be in the tree
        // and remember the path to it
        Node n = root;
        Node parent = null;
        int cmp = 0;
        List<Node> path = new LinkedList<>();
        while (n != null) {
            parent = n;
            path.add(0, parent);
            cmp = element.compareTo(parent.element);
            if (cmp == 0) {
                // don't add a duplicate
                return;
            } else if (cmp < 0) {
                n = n.left;
            } else {
                n = n.right;
            }
        }

        // add element to the appropriate empty subtree of parent
        Node newNode = new Node(element);
        path.add(0, newNode);
        if (cmp < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        size++;

        // backtrack through path, rebalancing as needed
       	while (!path.isEmpty()) {
       		n = path.remove(0);

       	}
        root.color = BLACK;
    }

	/** Ensures this red-black tree contains the specified element. */
	// public void add(T element) {
	// 	root = put(element, root);
	// }

	/** Adds the specified value, if not already present, to this red-black tree. */
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
        return rebalance(n);
	}



	/////////////////////////////////
	//   Rebalancing operations    //
	/////////////////////////////////

	/** Rebalance the 4-node neighborhood around n, if needed. */
	private Node rebalance(Node n) {
		return n;
	}

	/** Rotate left over the n. */
	private Node rotateLeft(Node n) {
		Node m = n.right;
		n.right = m.left;
		m.left = n;
		return m;	
	}

	/** Rotate right over the n. */
	private Node rotateRight(Node n) {
		Node m = n.left;
		n.left = m.right;
		m.right = n;
		return m;	
	}

	/** Returns the color of n. */
	private boolean colorOf(Node n) {
		if (n == null) {
			return BLACK;
		}
		return n.color;
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
		int leftHeight = height(n.left);
		int rightHeight = height(n.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}



	//////////////////////////////////
	//   toString and traversals    //
	//////////////////////////////////

    /**
     * Returns a string representation of the elements in this red-black tree listed in
     * ascending natural order.
     */
    @Override
    public String toString() {
        return inorderList(root).toString();
    }

    /**
     * Returns a List containing the elements of this red-black tree in ascending natural order.
     */
    private List<T> inorderList(Node n) {
        List<T> list = new ArrayList<>();
        buildInorderList(root, list);
        return list;
    }

    /**
     * Builds list from the elements of this red-black tree in ascending natural order.
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

	/** Returns an iterator over the values in this red-black tree. */
	@Override
	public Iterator<T> iterator() {
        return inorderList(root).iterator();      
	}

}
