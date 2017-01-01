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
	private boolean isBalancedNode(TreeNode node) {
		if(node==null)
			return true;
		int leftHeight=0;
		if(node.left!=null)
			leftHeight=getHeight(node.left);
		int rightHeight=0;
		if(node.right!=null)
			rightHeight=getHeight(node.right);
		return Math.abs(leftHeight-rightHeight)<=1 && isBalanced(node.left) && isBalanced(node.right);
	}
	private int getHeight(TreeNode tn) {
		return tn==null?0:1+Math.max(getHeight(tn.left), getHeight(tn.right));
	}
}
