package Dec2020Leetcode;

public class _0530MinimumAbsoluteDifferenceInBST {
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
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(2);
		System.out.println(getMinimumDifference(tn));
	}

	static Integer prev;
	static int minDiff;

	public static int getMinimumDifference(TreeNode root) {
		prev = null;
		minDiff = Integer.MAX_VALUE;
		inorder(root);
		return minDiff;
	}

	public static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			if (prev == null) {
				prev = root.val;
			} else {
				minDiff = Math.min(minDiff, Math.abs(prev - root.val));
				prev = root.val;
			}
			inorder(root.right);
		}
	}

}
