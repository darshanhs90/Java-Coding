package PracticeLeetCode;

public class _110BalancedBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public boolean isBalanced(TreeNode root) {
		if(root==null)
			return true;
		return isBalancedNode(root);

	}
	a
}
