package LeetcodeTemplate;

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

	
}
