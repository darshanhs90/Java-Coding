package Leetcode2020Nov;

public class _0114FlattenBinaryTreeToLinkedList {
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
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(5);
		tn.left.left = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		tn.right.right = new TreeNode(6);

		flatten(tn);
	}
	public static void printNodes(TreeNode root) {
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.right;
		}
		System.out.println();
	}
	
	public static void flatten(TreeNode root) {
		root = flattenList(root);
		printNodes(root);
	}

	public static TreeNode flattenList(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return root;

		TreeNode left = flattenList(root.left);
		TreeNode leftPtr = left;
		TreeNode right = flattenList(root.right);
		while (left != null && left.right != null) {
			left = left.right;
		}
		if (left != null) {
			left.right = right;
			left.left = null;
			root.right = leftPtr;
			root.left = null;
		}
		return root;
	}
}
