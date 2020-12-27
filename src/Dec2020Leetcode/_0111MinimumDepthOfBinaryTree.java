package Dec2020Leetcode;

public class _0111MinimumDepthOfBinaryTree {
	public static class TreeNode {
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
		System.out.println(minDepth(tn));
	}

	static int minDepth = Integer.MAX_VALUE;

	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return 1;
		minDepth = Integer.MAX_VALUE;
		findMinDepth(root, 0);
		return minDepth;
	}

	public static void findMinDepth(TreeNode root, int currLevel) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			minDepth = Math.min(minDepth, currLevel + 1);
			return;
		}

		findMinDepth(root.left, currLevel + 1);
		findMinDepth(root.right, currLevel + 1);
	}

}
