package leetCode;

/*
 * Link : https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */

public class _111MinimumDepthOfBinaryTree {
	static int[] path=new int[10000];
	static int min=Integer.MAX_VALUE;
	public static int minDepth(TreeNode root) {
		if(root==null)
			return 0;
		min=Integer.MAX_VALUE;
		getMinimumDepthOfBinaryTree(root,path,0);
		return min;
	}
	private static void getMinimumDepthOfBinaryTree(TreeNode root, int[] path1, int pathLen) {
		if(root==null)
			return;
		path1[pathLen]=root.val;
		pathLen++;
		if(root.left==null && root.right==null)
		{
			if(pathLen<min)
				min=pathLen;
		}
		else{
			getMinimumDepthOfBinaryTree(root.left, path1, pathLen);
			getMinimumDepthOfBinaryTree(root.right, path1, pathLen);
		}
	}
	public static void main(String[] args) {
		TreeNode rootnode=new TreeNode(3);
		rootnode.left=new TreeNode(9);
		rootnode.right=new TreeNode(20);
		rootnode.right.left=new TreeNode(15);
		rootnode.right.right=new TreeNode(7);
		System.out.println(minDepth(rootnode));
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}