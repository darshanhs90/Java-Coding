package PracticeLeetCode;

public class _098ValidateBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public boolean isValidBST(TreeNode root) {
		if(root==null)
			return true;
		return isValidBST(Long.MIN_VALUE,root,Long.MAX_VALUE);
	}
	private boolean isValidBST(long minValue, TreeNode root, long maxValue) {
		if(root==null)
			return true;
		return root.val>minValue && root.val<maxValue && isValidBST(minValue, root.left, root.val) & isValidBST(root.val, root.right, maxValue);
	}
}
