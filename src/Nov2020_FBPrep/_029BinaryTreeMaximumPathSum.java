package Nov2020_FBPrep;

public class _029BinaryTreeMaximumPathSum {
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
	}

	static int max = Integer.MIN_VALUE;

	public static int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		treePath(root);
		return max;
	}

	public static int treePath(TreeNode root) {
		if (root == null)
			return 0;
		int leftSum = Math.max(treePath(root.left), 0);
		int rightSum = Math.max(treePath(root.right), 0);
		max = Math.max(max, root.val + leftSum + rightSum);
		return root.val + Math.max(leftSum, rightSum);
	}

}
