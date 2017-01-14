package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _113PathSum2 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
	static int[] path=new int[1000];
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(root==null)
			return outputList;
		path=new int[500];
		dfs(root,0,sum,outputList);
		return outputList;
	}
	private static void dfs(TreeNode root,int index,int sum, List<List<Integer>> outputList) {
		if(root==null)
			return;
		if(root.left==null & root.right==null)
		{
			if(sum==root.val){
				path[index]=root.val;
				List<Integer> list=new ArrayList<>();
				for (int i = 0; i <=index; i++) {
					list.add(path[i]);
				}
				outputList.add(list);
			}
			return;
		}
		path[index]=root.val;
		dfs(root.left,index+1,sum-root.val,outputList);
		dfs(root.right,index+1,sum-root.val,outputList);
	}
}
