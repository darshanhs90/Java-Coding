package leetCode;

/*
 * Link : https://leetcode.com/problems/path-sum/
 */

public class _112PathSum {
	static int path[]=new int[1000];
	static boolean found=false;
	public static boolean hasPathSum(TreeNode root, int sum) {
		found=false;
		printPaths(root,path,0,sum);		
		return found;
	}
	private static void printPaths(TreeNode root, int[] path2, int pathLen,int sum) {

		if(root==null)
			return;
		path[pathLen]=root.val;
		pathLen++;
		if(root.left==null && root.right==null)
		{
			printArray(path,pathLen,sum);
		}
		else{
			printPaths(root.left, path, pathLen,sum);
			printPaths(root.right, path, pathLen,sum);
		}
	}
	private static void printArray(int[] path2, int pathLen,int sum) {
		int resultSum=0;
		for (int i = 0; i < pathLen; i++) {
			resultSum+=path2[i];
		}
		if(resultSum==sum)
			found=true;

	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		/*tn.left=new TreeNode(4);
		tn.right=new TreeNode(8);
		tn.right.left=new TreeNode(13);
		tn.right.right=new TreeNode(4);
		tn.right.right.right=new TreeNode(1);
		tn.left.left=new TreeNode(11);
		tn.left.left.left=new TreeNode(7);
		tn.left.left.right=new TreeNode(2);*/
		System.out.println(hasPathSum(tn,0));
	}
}