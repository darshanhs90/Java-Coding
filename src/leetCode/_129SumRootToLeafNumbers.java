package leetCode;

/*
 * Link : https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */

public class _129SumRootToLeafNumbers {
	static int paths[]=new int[1000];
	static int sum=0;
	public static int sumNumbers(TreeNode root) {
		paths=new int[1000];
		sum=0;
		printPaths(root,paths,0);
		return sum;
	}

	private static void printPaths(TreeNode root, int[] paths, int pathLen) {
		if(root==null)
			return;
		paths[pathLen]=root.val;
		pathLen++;
		if(root.left==null && root.right==null)
		{
			printElements(paths,pathLen);
		}
		else{
			printPaths(root.left, paths, pathLen);
			printPaths(root.right, paths, pathLen);
		}
	}

	private static void printElements(int[] paths, int pathLen) {
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < pathLen; i++) {
			sb.append(paths[i]);
		}
		System.out.println(sb.toString());
		sum+=Integer.parseInt(sb.toString());
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(5);
		tn.left.left=new TreeNode(4);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		
		System.out.println(sumNumbers(tn));
	}
}