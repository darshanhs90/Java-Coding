package May2021GoogLeetcode;

public class _0110BalancedBinaryTree {
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
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(20);
		tn.right.left = new TreeNode(15);
		tn.right.right = new TreeNode(7);
		System.out.println(isBalanced(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(2);
		tn.left.left = new TreeNode(3);
		tn.left.right = new TreeNode(3);
		tn.left.left.left = new TreeNode(4);
		tn.left.left.right = new TreeNode(4);
		System.out.println(isBalanced(tn));

		System.out.println(isBalanced(null));
	}

	static boolean isValid;

	public static boolean isBalanced(TreeNode root) {
		isValid = true;
		helper(root);
		return isValid;
	}

	public static int helper(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = helper(root.left);
		int rightHeight = helper(root.right);

		isValid = isValid && (Math.abs(leftHeight - rightHeight) <= 1);
		return 1 + Math.max(leftHeight, rightHeight);
	}

}
