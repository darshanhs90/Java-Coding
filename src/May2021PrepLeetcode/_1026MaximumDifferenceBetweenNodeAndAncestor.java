package May2021PrepLeetcode;

public class _1026MaximumDifferenceBetweenNodeAndAncestor {
	public static void main(String[] args) {
		TreeNode tn = new TreeNode(8);
		tn.left = new TreeNode(3);
		tn.right = new TreeNode(10);
		tn.left.left = new TreeNode(1);
		tn.left.right = new TreeNode(6);
		tn.left.right.left = new TreeNode(4);
		tn.left.right.right = new TreeNode(7);

		tn.right.right = new TreeNode(14);
		tn.right.right.left = new TreeNode(13);
		System.out.println(maxAncestorDiff(tn));

		tn = new TreeNode(1);
		tn.right = new TreeNode(2);
		tn.right.right = new TreeNode(0);
		tn.right.right.left = new TreeNode(3);
		System.out.println(maxAncestorDiff(tn));
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

	static int maxDiff;

	public static int maxAncestorDiff(TreeNode root) {
		maxDiff = Integer.MIN_VALUE;
		if (root == null)
			return 0;

		maxDiffHelper(root.val, root.val, root);
		return maxDiff;
	}

	public static void maxDiffHelper(int maxDiffCurr, int minDiffCurr, TreeNode root) {
		if (root == null)
			return;

		maxDiff = Math.max(maxDiff, Math.max(Math.abs(maxDiffCurr - root.val), Math.abs(minDiffCurr - root.val)));

		maxDiffCurr = Math.max(maxDiffCurr, root.val);
		minDiffCurr = Math.min(minDiffCurr, root.val);

		maxDiffHelper(maxDiffCurr, minDiffCurr, root.left);
		maxDiffHelper(maxDiffCurr, minDiffCurr, root.right);
	}
}
