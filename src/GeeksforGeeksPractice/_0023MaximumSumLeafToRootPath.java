package GeeksforGeeksPractice;

import java.util.Arrays;

public class _0023MaximumSumLeafToRootPath {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(-2);
		tn.right=new TreeNode(7);
		tn.left.left=new TreeNode(8);
		tn.left.right=new TreeNode(-4);
		System.out.println(maxSumPath(tn));//17
	}
	static int[]path=new int[1000];
	static int sum=Integer.MIN_VALUE;
	private static int maxSumPath(TreeNode tn) {
		printPath(tn,path,0);
		return sum;
	}
	private static void printPath(TreeNode tn, int[] path, int pathLen) {
		if(tn!=null)
		{
			path[pathLen]=tn.val;
			pathLen++;
			if(tn.left==null && tn.right==null)
			{	
				System.out.println(Arrays.toString(Arrays.copyOfRange(path,0,pathLen)));
				int newSum=0;
				for (int i = 0; i <pathLen; i++) {
					newSum+=path[i];
				}
				if(newSum>sum)
					sum=newSum;				
			}
			printPath(tn.left, path, pathLen);
			printPath(tn.right, path, pathLen);	
		}

	}

}
