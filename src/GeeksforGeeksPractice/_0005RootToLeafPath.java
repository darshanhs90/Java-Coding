package GeeksforGeeksPractice;

import java.util.Arrays;

public class _0005RootToLeafPath {
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(4);
		tn.left.left=new TreeNode(5);
		tn.left.left.left=new TreeNode(6);
		tn.left.left.left.left=new TreeNode(7);
		rootToLeafPath(tn);
	}

	static int path[];
	public static void rootToLeafPath(TreeNode tn){
		path=new int[1000];
		getPath(tn,path,0);
	}


	public static void getPath(TreeNode tn,int[] path,int pathLen){
		if(tn!=null)
		{
			path[pathLen]=tn.val;
			pathLen++;
			if(tn.left==null && tn.right==null)
			{
				System.out.println(Arrays.toString(path));
			}
			else{
				getPath(tn.left,path,pathLen);
				getPath(tn.right,path,pathLen);
			}
		}
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


}
