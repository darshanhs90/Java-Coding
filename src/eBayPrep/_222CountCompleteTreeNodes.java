package eBayPrep;

public class _222CountCompleteTreeNodes{
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int countNodes(TreeNode root) {
		if(root==null)
			return 0;
		int leftHeight=getLeftHeight(root.left);
		int rightHeight=getRightHeight(root.right);
		if(leftHeight==rightHeight)
			return 2<<(leftHeight-1)-1;
		return countNodes(root.left)+countNodes(root.right)+1;
	}

	private int getRightHeight(TreeNode tn) {
		if(tn!=null)
			return 1+getRightHeight(tn.right);
		return 0;
	}

	private int getLeftHeight(TreeNode tn) {
		if(tn!=null)
			return 1+getRightHeight(tn.left);
		return 0;
	}



}

