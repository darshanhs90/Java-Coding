package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

import PracticeLeetCode._113PathSum2.TreeNode;

public class _257BinaryTreePaths {
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
		System.out.println(binaryTreePaths(tn));
	}
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> outputList=new ArrayList<>();
		if(root==null)
			return outputList;
		path=new int[500];
		dfs(root,0,outputList);
		return outputList;
	}
	static int[] path=new int[1000];

	private static void dfs(TreeNode root,int index,List<String> outputList) {
		if(root==null)
			return;
		if(root.left==null & root.right==null)
		{
			path[index]=root.val;
			String str=path[0]+"";
			for (int i = 1; i <=index; i++) {
				str+="->"+path[i];
			}
			outputList.add(str);
			return;
		}
		path[index]=root.val;
		dfs(root.left,index+1,outputList);
		dfs(root.right,index+1,outputList);
	}
}
