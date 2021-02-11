/**
 * Hash table implementation using closed addressing with
 * separate chaining. Duplicates and nulls are not allowed.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-11-15
 */
public class HashTableClosedChaining<T> {

	/** Drives execution. */
	public static void main(String[] args) {
		int[] values = {22, 12, 35, 15, 6, 18, 56, 26, 94, 4, 48};
		java.util.Collections.shuffle(java.util.Arrays.asList(values));
		HashTableClosedChaining<Integer> hashtable = new HashTableClosedChaining<>();
		for (int value : values) {
			hashtable.add(value);
		}
		java.util.Collections.shuffle(java.util.Arrays.asList(values));
		for (int value : values) {
			hashtable.add(value);
		}
		System.out.println(hashtable);
	}

	/** Node class for collision chains. */
	private class Node {
		private T element;
		private Node next;

		/** Construct a node with the given element and next value. */
		public Node(T elem, Node nxt) {
			element = elem;
			next = nxt;
		}
	}

	// the hash table
	private Node[] table;

	// initial capacity of the table
	private static final int INITIAL_CAPACITY = 11;

	// number of elements stored in the table
	private int size;

	/**
	 * Construct an instance of the hash table class.
	 */
	@SuppressWarnings("unchecked")
	public HashTableClosedChaining() {
		table = (Node[]) new HashTableClosedChaining.Node[INITIAL_CAPACITY];
		size = 0;
	}

	/**
	 * The hash function. Maps the hashcode of given value onto
	 * the range of indices of the table.
	 */
	private int hash(T value) {
		int hashcode = value.hashCode();
		return (hashcode & Integer.MAX_VALUE) % table.length;
	}


	/**
	 * Ensures that the table contains the given value.
	 * Returns true if the table was changed.
	 */
	public boolean add(T value) {
		int index = hash(value);
		if (table[index] == null) {
			table[index] = new Node(value, null);
		} else {
			Node n = table[index];
			while (n.next != null) {
				if (n.element.equals(value)) {
					return false;
				}
				n = n.next;
			}
			if (n.element.equals(value)) {
				return false;
			}
			n.next = new Node(value, null);
		}
		size++;
		return true;
	}

	/**
	 * Ensures that the table does not contain the given value.
	 * Returns true if the table was changed.
	 */
	public boolean remove(T value) {
		int index = hash(value);
		return false;
	}

	/**
	 * Returns true if this hash table contains the given value,
	 * false otherwise.
	 */
	public boolean contains(T value) {
		int index = hash(value);
		Node n = table[index];
		while (n != null) {
			if (n.element.equals(value)) {
				return true;
			}
			n = n.next;
		}
		return false;
	}

	/**
	 * Returns a string representation of this hash table.
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < table.length; i++) {
			result.append(i + "-> ");
			Node n = table[i];
			while (n != null) {
				result.append(n.element);
				if (n.next != null) {
					result.append(", ");
				}
				n = n.next;
			}
			result.append("\n");
		}
		return result.toString();
	}
}

