package eBayPrep;

public class _110BalancedBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public boolean isBalanced(TreeNode tn) {
		if(tn==null)
			return true;
		return Math.abs(getHeight(tn.left)-getHeight(tn.right))<=1 && isBalanced(tn.left) && isBalanced(tn.right);
	}
	private int getHeight(TreeNode tn) {
		return tn==null?0:1+Math.max(getHeight(tn.left), getHeight(tn.right));
	}


}

