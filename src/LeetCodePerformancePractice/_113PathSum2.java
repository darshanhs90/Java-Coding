package LeetCodePerformancePractice;

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
	static List<Integer> list;
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		outputList=new ArrayList<>();
		list=new ArrayList<>();
		if(root==null)
			return outputList;
		list.add(root.val);
		findPaths(root,0,sum,list);
		return outputList;
	}

	private static void findPaths(TreeNode root, int currSum,int target, List<Integer> list) {
		if(root==null)
			return;
		if(root.left==null && root.right==null && currSum+root.val==target)
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(list);
			outputList.add(temp);
			return;
		}
		if(root.left!=null){
			list.add(root.left.val);
			findPaths(root.left, currSum+root.val, target,list);
			list.remove(list.size()-1);
		}
		if(root.right!=null){
			list.add(root.right.val);
			findPaths(root.right, currSum+root.val, target,list);
			list.remove(list.size()-1);
		}
	}
}
