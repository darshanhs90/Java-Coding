package Leetcode2020Nov;

public class _0117PopulatingNextRightPointersInEachNodeII {
	public static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

	public static void main(String[] args) {
		Node tn = new Node(1);
		tn.left = new Node(2);
		tn.left.left = new Node(4);
		tn.left.right = new Node(5);
		tn.right = new Node(3);
		tn.right.left = new Node(6);
		tn.right.right = new Node(7);
		printNodes(connect(tn));
	}

	public static void printNodes(Node root) {
		if (root == null) {
			return;
		}

		if (root.next != null) {
			System.out.println(root.val + "->next->" + root.next.val);
		} else {
			System.out.println(root.val + "->next->null");

		}
		printNodes(root.left);
		printNodes(root.right);

	}

	static Node nextNode = null;

	public static Node connect(Node root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		int length = getLength(root);
		for (int i = 0; i < length; i++) {
			nextNode = null;
			getNodes(root, i);
		}
		return root;
	}

	public static void getNodes(Node root, int level) {
		if (root == null)
			return;
		if (level == 0) {
			root.next = nextNode;
			nextNode = root;
			return;
		}
		getNodes(root.right, level - 1);
		getNodes(root.left, level - 1);
	}

	public static int getLength(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.max(getLength(root.left), getLength(root.right));
	}
}
