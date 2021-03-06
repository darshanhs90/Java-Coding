package Feb2021Leetcode;

public class _0426ConvertBinarySearchTreeToSortedDoublyLinkedList {

	public static void main(String[] args) {
		Node node = new Node(4);
		node.left = new Node(2);
		node.right = new Node(5);
		node.left.left = new Node(1);
		node.left.right = new Node(3);

		node = treeToDoublyList(node);
		printNodes(node);

	}

	public static void printNodes(Node node) {
		if (node != null) {
			System.out.println(node.val);
			Integer leftVal = node.left != null ? node.left.val : null;
			Integer rightVal = node.right != null ? node.right.val : null;
			System.out.println("left" + leftVal);
			System.out.println("right" + rightVal);
			printNodes(node.right);
		}
	}

	static class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	};

	public static Node treeToDoublyList(Node root) {

	}

}
