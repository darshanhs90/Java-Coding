package Leetcode2020Nov;

public class _0700SearchInABinarySearchTree {
	static public class TreeNode {
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
		TreeNode out = searchBST(tn, 2);
		preOrder(out);
		System.out.println();
		out = searchBST(tn, 5);
		preOrder(out);

	}

	public static TreeNode searchBST(TreeNode root, int val) {
		if (root == null)
			return null;
		if (root.val == val)
			return root;
		else if (val < root.val)
			return searchBST(root.left, val);
		else
			return searchBST(root.right, val);
	}

	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + "->");
		preOrder(root.left);
		preOrder(root.right);
	}
}
