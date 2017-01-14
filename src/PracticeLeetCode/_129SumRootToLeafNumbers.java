package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

import PracticeLeetCode._113PathSum2.TreeNode;

public class _129SumRootToLeafNumbers {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
	static int[] path;
	static int sum=0;
	public int sumNumbers(TreeNode root) {
		if(root==null)
			return 0;
		path=new int[1000];
		sum=0;
		dfs(root,0);
		return sum;
	}
	private static void dfs(TreeNode root,int index) {
		if(root==null)
			return;
		if(root.left==null & root.right==null)
		{
			path[index]=root.val;
			String str="";
			for (int i = 0; i <=index; i++) {
				str+=(path[i]);
			}
			sum+=Integer.parseInt(str);
			return;
		}
		path[index]=root.val;
		dfs(root.left,index+1);
		dfs(root.right,index+1);
	}
}
