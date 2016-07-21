package LeetCodePractice;

public class _110BalancedBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isBalanced(TreeNode tn) {
		if(tn!=null)
		{
			int leftHeight=0,rightHeight=0;
			if(tn.left!=null)
				leftHeight=getHeight(tn.left);
			if(tn.right!=null)
				rightHeight=getHeight(tn.right);
			return Math.abs(leftHeight-rightHeight)<=1 && isBalanced(tn.left) && isBalanced(tn.right);
		}
		return true;
	}

	public int getHeight(TreeNode tn) {
		if(tn!=null)
		{
			return 1+Math.max(getHeight(tn.left), getHeight(tn.right));
		}
		return 0;
	}



}

