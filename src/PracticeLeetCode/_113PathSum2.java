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
	static List<List<Integer>> outputList;
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		outputList=new ArrayList<>();
		if(root==null)
			return outputList;
		List<Integer> list=new ArrayList<>();
		dfs(root,sum,list);
		return outputList;
	}
	private void dfs(TreeNode root, int sum, List<Integer> list) {
		if(root==null)
			return;
		if(sum-root.val==0 && root.left==null && root.right==null)
		{
			list.add(root.val);
			outputList.add(new ArrayList<>(list));
			list.remove(list.size()-1);
			return;
		}
		if(root.left!=null)
		{
			list.add(root.val);
			dfs(root.left,sum-root.val,list);
			list.remove(list.size()-1);
		}
		if(root.right!=null)
		{
			list.add(root.val);
			dfs(root.right,sum-root.val,list);
			list.remove(list.size()-1);
		}
	}
}
