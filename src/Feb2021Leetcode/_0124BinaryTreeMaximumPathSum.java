package Feb2021Leetcode;

public class _0124BinaryTreeMaximumPathSum {

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
		System.out.println(maxPathSum(tn));

		tn = new TreeNode(-10);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(20);
		tn.right.left = new TreeNode(15);
		tn.right.right = new TreeNode(7);
		System.out.println(maxPathSum(tn));

		tn = new TreeNode(-2);
		tn.right = new TreeNode(-3);
		System.out.println(maxPathSum(tn));
	}

	static int maxSum;

	public static int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		maxSum = Integer.MIN_VALUE;
		maxPathSumHelper(root);
		return maxSum;
	}

	public static int maxPathSumHelper(TreeNode root) {
		if (root == null)
			return 0;
		int leftSum = Math.max(maxPathSumHelper(root.left), 0);
		int rightSum = Math.max(maxPathSumHelper(root.right), 0);

		maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
		return Math.max(root.val + leftSum, root.val + rightSum);
	}

}
