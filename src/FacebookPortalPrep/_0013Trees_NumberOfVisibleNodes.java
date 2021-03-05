package FacebookPortalPrep;

public class _0013Trees_NumberOfVisibleNodes {

	public static void main(String[] args) {
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node() {
			this.data = 0;
			this.left = null;
			this.right = null;
		}

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static int visibleNodes(Node root) {
		// Write your code here
		if (root == null)
			return 0;
		return 1 + Math.max(visibleNodes(root.left), visibleNodes(root.right));
	}
}
