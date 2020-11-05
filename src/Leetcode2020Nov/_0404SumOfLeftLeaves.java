package Leetcode2020Nov;

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

	public static int sumOfLeftLeaves(TreeNode root) {
		if(root == null)
			return 0;
		return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
	}
	
	public static int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null && isLeft)
		{
			return root.val;
		}
		return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
	}
}
