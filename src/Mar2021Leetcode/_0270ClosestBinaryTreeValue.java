package Mar2021Leetcode;

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
		System.out.println(closestValue(tn, 3.214286));
	}

	static double diff;
	static int closestValue;

	public static int closestValue(TreeNode root, double target) {
		diff = Long.MAX_VALUE;
		dfs(root, target);
		return closestValue;
	}

	public static void dfs(TreeNode root, double target) {
		if (root == null)
			return;

		if (Math.abs(root.val - target) < Math.abs(diff)) {
			diff = Math.abs(root.val - target);
			closestValue = root.val;
		}

		if (root.val > target) {
			dfs(root.left, target);
		} else {
			dfs(root.right, target);
		}
	}

}
