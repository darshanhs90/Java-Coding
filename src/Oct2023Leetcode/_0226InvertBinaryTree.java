package Oct2023Leetcode;

public class _0226InvertBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(4);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(7);
		tn.left.left = new TreeNode(1);
		tn.left.right = new TreeNode(3);
		tn.right.left = new TreeNode(6);
		tn.right.right = new TreeNode(9);
		preOrder(tn);
		System.out.println();

		preOrder(invertTree(tn));
		System.out.println();
	}

	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		preOrder(root.left);
		System.out.print(root.val + "->");
		preOrder(root.right);
	}

	public static TreeNode invertTree(TreeNode root) {

	}

}
