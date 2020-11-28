package Nov2020_GfG;

public class _019MinimumDepthOfBinaryTree {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		Node tn = new Node(1);
		tn.left = new Node(3);
		tn.right = new Node(2);
		tn.left.left = new Node(4);
		System.out.println(minDepth(tn));

		tn = new Node(10);
		tn.left = new Node(20);
		tn.left.right = new Node(40);
		tn.right = new Node(30);
		tn.right.right = new Node(60);
		tn.right.right.left = new Node(2);
		System.out.println(minDepth(tn));
	}

	static int minDepth = Integer.MAX_VALUE;

	static int minDepth(Node root) {
		if (root == null)
			return 0;
		minDepth = Integer.MAX_VALUE;
		minDepth(root, 1);
		return minDepth;
	}

	static void minDepth(Node root, int currDepth) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			minDepth = Math.min(minDepth, currDepth);
			return;
		}
		minDepth(root.left, currDepth + 1);
		minDepth(root.right, currDepth + 1);
	}
}
