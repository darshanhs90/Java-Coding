package leetCode;

/*
 * Link : https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

public class _104BinaryTreeMaxDepth {
	public int maxDepth(TreeNode root) {
		return maxDepth(root,1);
	}
	private int maxDepth(TreeNode root,int val){
		
		if(root!=null)
		{	
			int left=0,right=0;
			if(root.left!=null)
				left=maxDepth(root.left,1);
			if(root.right!=null)
				right=maxDepth(root.right,1);
			return 1+((left>right)?left:right);
		}
		return 0;
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}