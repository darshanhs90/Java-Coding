package LeetCodePerformancePractice;

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
		return isValidBSTChecker(root.left,Long.MIN_VALUE,root.val) && isValidBSTChecker(root.right,root.val,Long.MAX_VALUE);

	}
	private boolean isValidBSTChecker(TreeNode root, long minValue, long maxValue) {
		if(root!=null)
		{
			return root.val>minValue && root.val<maxValue && 
					isValidBSTChecker(root.left,minValue,root.val) 
					&& isValidBSTChecker(root.right,root.val,maxValue);
		}
		return true;
	}

}
