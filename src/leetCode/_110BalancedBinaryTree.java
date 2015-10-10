package leetCode;

/*
 * Link : https://leetcode.com/problems/balanced-binary-tree/
 */

public class _110BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if(root!=null){
			int leftHeight=getHeight(root.left);
			int rightHeight=getHeight(root.right);
			return (Math.abs(leftHeight-rightHeight)<=1) && isBalanced(root.left) && isBalanced(root.right);
		}
		return true;
	}
	public int getHeight(TreeNode node)
	{
		if(node!=null)
		{
			int leftHeight=getHeight(node.left);
			int rightHeight=getHeight(node.right);			
			return 1+((leftHeight>rightHeight)?leftHeight:rightHeight);
		}
		return 0;
	}

	public static void main(String[] args) {

	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


}