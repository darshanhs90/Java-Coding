package May2021Leetcode;

public class _1123LowestCommonAncestorOfDeepestLeaves {

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
		tn.left = new TreeNode(5);
		tn.left.left = new TreeNode(6);
		tn.left.right = new TreeNode(2);
		tn.left.right.left = new TreeNode(7);
		tn.left.right.right = new TreeNode(4);

		tn.right = new TreeNode(1);
		tn.right.left = new TreeNode(0);
		tn.right.right = new TreeNode(8);
		tn = lcaDeepestLeaves(tn);
		printNodes(tn);
	}

	public static void printNodes(TreeNode tn) {
		if (tn == null)
			return;
		printNodes(tn.left);
		System.out.print(tn.val + "->");
		printNodes(tn.right);
	}

	static TreeNode lca;
	static int maxDepth;

	public static TreeNode lcaDeepestLeaves(TreeNode root) {
		maxDepth = 0;
		lca = null;
		helper(root, 1);
		return lca;
	}

	public static int helper(TreeNode root, int level) {
		maxDepth = Math.max(maxDepth, level);
		if (root == null)
			return level;
		int left = helper(root.left, level + 1);
		int right = helper(root.right, level + 1);

		if (left == maxDepth && right == maxDepth) {
			lca = root;
		}
		return Math.max(left, right);
	}
}
