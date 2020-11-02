package Leetcode2020Nov;

public class _0101SymmetricTree {
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
		tn.right = new TreeNode(2);
		tn.left.left = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		tn.right.left = new TreeNode(4);
		tn.right.right = new TreeNode(3);
		System.out.println(isSymmetric(tn));
		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(2);
		tn.left.right = new TreeNode(3);
		tn.right.right = new TreeNode(3);
		System.out.println(isSymmetric(tn));
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isMirror(root.left, root.right);
	}

	public static boolean isMirror(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		else if ((left == null && right != null) || (left != null && right == null))
			return false;
		return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
	}
}
