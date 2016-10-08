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
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(root==null)
			return outputList;
		List<Integer> list=new ArrayList<>();
		list.add(root.val);
		hasPathSum(root, sum, outputList, list);
		return outputList;
	}
	public void hasPathSum(TreeNode root, int sum,List<List<Integer>> outputList,List<Integer> list) {
		if(root==null)
			return ;
		if(sum==root.val && root.left==null && root.right==null){
			outputList.add(new ArrayList<>(list));
			return ;
		}
		if(root.left!=null){
			list.add(root.left.val);
			hasPathSum(root.left, sum-root.val,outputList,list);
			list.remove(list.size()-1);
		}
		if(root.right!=null){
			list.add(root.right.val);
			hasPathSum(root.right, sum-root.val,outputList,list);
			list.remove(list.size()-1);
		}
	}
}
