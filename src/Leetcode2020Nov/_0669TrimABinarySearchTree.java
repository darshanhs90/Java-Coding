package Leetcode2020Nov;

public class _0669TrimABinarySearchTree {
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
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(0);
		tn.right = new TreeNode(2);
		tn = trimBST(tn, 1, 2);
		preOrder(tn);
		System.out.println();

		tn = new TreeNode(3);
		tn.left = new TreeNode(0);
		tn.right = new TreeNode(4);
		tn.left.right = new TreeNode(2);
		tn.left.right.left = new TreeNode(1);
		tn = trimBST(tn, 1, 3);
		preOrder(tn);
		System.out.println();
	}

	public static TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null)
			return root;
		if (root.val == low) {
			root.left = null;
			root.right = trimBST(root.right, low, high);
			return root;
		}

		if (root.val == high) {
			root.right = null;
			root.left = trimBST(root.left, low, high);
			return root;
		}

		if (root.val > low && root.val > high) {
			return trimBST(root.left, low, high);
		}

		if (root.val < low && root.val < high) {
			return trimBST(root.right, low, high);
		}
		
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		return root;
	}

	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
}
