package servicenowPrep;

import java.util.Arrays;

public class _039RootToLeafPath
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}
	static int[] path=new int[1000];
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		printPaths(tn,path,0);
	}

	private static void printPaths(TreeNode tn,int[] path,int level) {
		if(tn==null)
			return;
		path[level]=tn.value;
		if(tn.left==null && tn.right==null)
			System.out.println(Arrays.toString(path));
		printPaths(tn.left, path, level+1);
		printPaths(tn.right, path, level+1);
	}
}