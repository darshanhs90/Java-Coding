package Leetcode2020Nov;

public class _0993CousinsInBinaryTree {
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
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.left = new TreeNode(4);
		System.out.println(isCousins(tn, 4, 3));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		tn.right.right = new TreeNode(5);
		System.out.println(isCousins(tn, 5, 4));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		System.out.println(isCousins(tn, 2, 3));
	}

	static class TreeDetails {
		int height;
		TreeNode parent;

		public TreeDetails(int height, TreeNode parent) {
			this.height = height;
			this.parent = parent;
		}
	}

	public static boolean isCousins(TreeNode root, int x, int y) {
		TreeDetails xDetails = getHeight(root, x, 0, root);
		TreeDetails yDetails = getHeight(root, y, 0, root);
		if (xDetails.height != yDetails.height || xDetails.parent == yDetails.parent)
			return false;
		return true;
	}

	public static TreeDetails getHeight(TreeNode root, int x, int currHeight, TreeNode parent) {
		if (root == null) {
			return new TreeDetails(-1, null);
		}
		if (root.val == x) {
			return new TreeDetails(currHeight, parent);
		}
		TreeDetails leftVal = getHeight(root.left, x, currHeight + 1, root);
		TreeDetails rightVal = getHeight(root.right, x, currHeight + 1, root);
		return leftVal.height != -1 ? leftVal : rightVal;
	}
}
