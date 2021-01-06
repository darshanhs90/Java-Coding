package Dec2020Leetcode;

public class _0404SumOfLeftLeaves {

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
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(20);
		tn.right.left = new TreeNode(15);
		tn.right.right = new TreeNode(7);
		System.out.println(sumOfLeftLeaves(tn));
	}

	static int sum;

	public static int sumOfLeftLeaves(TreeNode root) {
		sum = 0;
		if (root == null)
			return 0;
		sumOfLeftLeaves(root.left, true);
		sumOfLeftLeaves(root.right, false);
		return sum;
	}

	public static void sumOfLeftLeaves(TreeNode root, boolean isLeft) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (isLeft) {
				sum += root.val;
			}
			return;
		}

		sumOfLeftLeaves(root.left, true);
		sumOfLeftLeaves(root.right, false);
	}

}
