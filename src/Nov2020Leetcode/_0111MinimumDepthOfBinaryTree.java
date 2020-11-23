package Nov2020Leetcode;

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
		minDepth = Integer.MAX_VALUE;
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return 1;
		getDepth(root.left, 1);
		getDepth(root.right, 1);
		return minDepth;
	}

	public static void getDepth(TreeNode root, int currDepth) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			minDepth = Math.min(currDepth + 1, minDepth);
			return;
		}
		getDepth(root.left, currDepth + 1);
		getDepth(root.right, currDepth + 1);
	}
}
