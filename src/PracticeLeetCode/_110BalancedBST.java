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
		int leftHeight=getHeight(root.left);
		int rightHeight=getHeight(root.right);
		return Math.abs(leftHeight-rightHeight)<=1 && isBalanced(root.left) && isBalanced(root.right);
	}
	private int getHeight(TreeNode root) {
		return root==null?0:1+Math.max(getHeight(root.left), getHeight(root.right));
	}
}
