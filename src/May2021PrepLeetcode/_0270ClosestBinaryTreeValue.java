package May2021PrepLeetcode;

public class _0270ClosestBinaryTreeValue {
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
		TreeNode tn = new TreeNode(4);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(5);
		tn.left.left = new TreeNode(1);
		tn.left.right = new TreeNode(3);
		System.out.println(closestValue(tn, 3.714286));
	}

	static int closestVal;
	static double minDiff;

	public static int closestValue(TreeNode root, double target) {
		minDiff = Double.MAX_VALUE;
		closestVal = 0;
		dfs(root, target);
		return closestVal;
	}

	public static void dfs(TreeNode root, double target) {
		if (root == null)
			return;

		if (Math.abs(root.val - target) < minDiff) {
			minDiff = Math.abs(root.val - target);
			closestVal = root.val;
		}

		if (root.val > target) {
			dfs(root.left, target);
		} else {
			dfs(root.right, target);
		}
	}

}
