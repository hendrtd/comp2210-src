import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * Generates an encoding for a text alphabet based on Huffman's algorithm.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-11-18
 */
public class Huffman {
	/** Drives execution. */
	public static void main(String[] args) {
        // String text = "go go gophers";
        // String text = "I slit the sheet, the sheet I slit, and on the slitted sheet I sit";
		// String text = "aaaaaaaaaabbbbbbbccccccdddde";
        // String text = "bodda getta, bodda getta, bodda getta, bah";
        String text = "she sells sea shells by the sea shore";
		Map<String, Integer> charMap = charCount(text.toLowerCase());
		CodeTreeNode codeTree = getHuffmanTree(text.toLowerCase());
		Map<String, String> codeTable = getCodeTable(codeTree);
		System.out.println(charMap);
		System.out.println(codeTable);
	}

	/** Consructs a code tree using Huffman's algorithm. */
	static CodeTreeNode getHuffmanTree(String text) {
		Map<String, Integer> charMap = charCount(text);
		PriorityQueue<CodeTreeNode> heap = new PriorityQueue<>();
		for (String ch : charMap.keySet()) {
			heap.add(new CodeTreeNode(ch, charMap.get(ch)));
		}

		while (heap.size() > 1) {
			CodeTreeNode n1 = heap.poll();
			CodeTreeNode n2 = heap.poll();
			heap.add(new CodeTreeNode("", n1.count + n2.count, n1, n2));
		}
		return heap.peek();
	}

	/** Returns the frequency of each char in text. */
	static Map<String, Integer> charCount(String text) {
		String chars = new Scanner(text).useDelimiter("\\Z").next();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < chars.length(); i++) {
			String ch = chars.charAt(i) + "";
			Integer count = map.get(ch);
			if (count == null) {
				count = 0;
			}
			map.put(ch, count + 1);
		}
		return map;
	}

	/** Returns (char,code) map defined by tree. */
	static Map<String, String> getCodeTable(CodeTreeNode tree) {
		Map<String, String> table = new HashMap<>();
		buildTablePreorder(tree, table, new StringBuilder());
		return table;
	}

    /** Builds the code table via preorder traversal. */
    static void buildTablePreorder(CodeTreeNode node, Map<String, String> map, StringBuilder code) {
        if (isLeaf(node)) {
            map.put(node.ch, code.toString());
            return;
        }
        buildTablePreorder(node.left, map, code.append("0"));
        code.delete(code.length() - 1, code.length());
        buildTablePreorder(node.right, map, code.append("1"));
        code.delete(code.length() - 1, code.length());
    }

	/** Returns true if n is a leaf node. */
	static boolean isLeaf(CodeTreeNode n) {
		return n != null && n.left == null && n.right == null;
	}

	/** Defines a node in a code tree. */
	static class CodeTreeNode implements Comparable<CodeTreeNode> {
		String ch;
		int count;
		CodeTreeNode left;
		CodeTreeNode right;

		/** Constructs a new CodeTreeNode. */
		public CodeTreeNode(String ch, int count) {
			this.ch = ch;
			this.count = count;
			this.left = null;
			this.right = null;
		}

		/** Constructs a new CodeTreeNode. */
		public CodeTreeNode(String ch, int count, CodeTreeNode left, CodeTreeNode right) {
			this.ch = ch;
			this.count = count;
			this.left = left;
			this.right = right;
		}

		/** Defines total order of nodes by count. */
		@Override
		public int compareTo(CodeTreeNode n) {
			return this.count - n.count;
		}

		/** Returns a string representation of this node. */
		@Override
		public String toString() {
			return "(" + ch + ", " + count + ")";
		}
	}
}
