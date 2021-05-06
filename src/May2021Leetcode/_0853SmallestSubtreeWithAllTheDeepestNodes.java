package May2021Leetcode;

public class _0853SmallestSubtreeWithAllTheDeepestNodes {
	public static void main(String[] args) {
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

	static int deepestLevel = 0;
	static TreeNode res = null;

	public static TreeNode subtreeWithAllDeepest(TreeNode root) {
		deepestLevel = 0;
		res = null;
		dfs(root, 0);
		return res;
	}

	private static int dfs(TreeNode root, int level) {
		if (root == null)
			return level;

		int leftLevel = dfs(root.left, level + 1);
		int rightLevel = dfs(root.right, level + 1);

		int curLevel = Math.max(leftLevel, rightLevel);
		deepestLevel = Math.max(deepestLevel, curLevel);
		if (leftLevel == deepestLevel && rightLevel == deepestLevel)
			res = root;
		return curLevel;
	}
}
