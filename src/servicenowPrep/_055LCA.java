package servicenowPrep;

import java.util.Arrays;
import java.util.Stack;

public class _055LCA
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		System.out.println(lca(tn,4,5));
	}
	static int[] path1=new int[10];
	static int[] path2=new int[10];
	private static int lca(TreeNode tn, int nodeVal1, int nodeVal2) {
		if(tn==null)
			return 0;
		fillPath(tn,nodeVal1,path1,0);
		exit=false;
		fillPath(tn,nodeVal2,path2,0);
		int length=Math.min(path1.length, path2.length);
		for (int i = 0; i < length; i++) {
			if(path1[i]!=path2[i])
				return path1[i-1];
		}
		return path1[length-1];
	}
	static boolean exit=false;
	private static void fillPath(TreeNode tn, int nodeVal1, int[] path,int level) {
		if(tn==null||exit)
			return;
		if(tn.value==nodeVal1)
		{
			path[level]=tn.value;
			exit=true;
			return;
		}
		path[level]=tn.value;
		fillPath(tn.left, nodeVal1, path, level+1);
		fillPath(tn.right, nodeVal1, path, level+1);
	}
	

}