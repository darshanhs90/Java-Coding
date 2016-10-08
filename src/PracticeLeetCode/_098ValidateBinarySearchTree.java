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
		return isValidBST(root.left,Long.MIN_VALUE,root.val) && isValidBST(root.right,root.val,Long.MAX_VALUE);
	}
	private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
		if(root==null)
			return true;
		return root.val>minValue && root.val<maxValue && isValidBST(root.left,minValue,root.val) && isValidBST(root.right,root.val,maxValue);
	}

}
