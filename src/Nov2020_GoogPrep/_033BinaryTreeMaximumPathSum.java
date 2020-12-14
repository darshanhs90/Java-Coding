package Nov2020_GoogPrep;

public class _033BinaryTreeMaximumPathSum {

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

		tn = new TreeNode(2);
		tn.left = new TreeNode(-1);
		System.out.println(maxPathSum(tn));
		
		tn = new TreeNode(-2);
		tn.left = new TreeNode(-1);
		System.out.println(maxPathSum(tn));
		
		tn = new TreeNode(-2);
		System.out.println(maxPathSum(tn));
	}

	static int maxSum;

	public static int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		findMaxPathSum(root);
		return maxSum;
	}

	public static int findMaxPathSum(TreeNode root) {
		if (root == null)
			return 0;

		int leftSum = Math.max(findMaxPathSum(root.left), 0);
		int rightSum = Math.max(findMaxPathSum(root.right), 0);
		maxSum = Math.max(maxSum, leftSum + root.val + rightSum);
		return root.val + Math.max(leftSum, rightSum);
	}
}
