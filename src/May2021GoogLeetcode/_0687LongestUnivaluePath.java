package May2021GoogLeetcode;

public class _0687LongestUnivaluePath {

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(5);
		tn.left = new TreeNode(4);
		tn.left.left = new TreeNode(1);
		tn.left.right = new TreeNode(1);
		tn.right = new TreeNode(5);
		tn.right.right = new TreeNode(5);
		System.out.println(longestUnivaluePath(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(4);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(4);
		tn.right = new TreeNode(5);
		tn.right.right = new TreeNode(5);
		System.out.println(longestUnivaluePath(tn));
	}

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

	static int max;

	public static int longestUnivaluePath(TreeNode root) {
		max = 0;
		if (root == null)
			return 0;
		helper(root);
		return max;
	}

	public static int helper(TreeNode root) {
		if (root == null)
			return 0;
		int left = helper(root.left);
		int right = helper(root.right);

		int leftSum = 0, rightSum = 0;
		if (root.left != null && root.val == root.left.val) {
			leftSum = left + 1;
		}
		if (root.right != null && root.val == root.right.val) {
			rightSum = right + 1;
		}

		max = Math.max(max, leftSum + rightSum);
		return Math.max(leftSum, rightSum);
	}

}
