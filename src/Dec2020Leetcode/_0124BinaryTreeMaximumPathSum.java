package Dec2020Leetcode;

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

	static long maxSum = Long.MIN_VALUE;

	public static int maxPathSum(TreeNode root) {
		maxSum = Long.MIN_VALUE;
		findMaxSum(root);
		return (int) maxSum;
	}

	public static int findMaxSum(TreeNode root) {
		if (root == null)
			return 0;

		int leftSum = Math.max(findMaxSum(root.left), 0);
		int rightSum = Math.max(findMaxSum(root.right), 0);

		maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
		return root.val + Math.max(leftSum, rightSum);
	}

}
