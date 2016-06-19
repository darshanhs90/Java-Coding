package LeetCodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _112PathSum {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(5);
		tn.left=new TreeNode(4);
		tn.right=new TreeNode(8);
		tn.left.left=new TreeNode(11);
		tn.right.left=new TreeNode(13);
		tn.right.right=new TreeNode(4);
		tn.left.left.left=new TreeNode(7);
		tn.left.left.right=new TreeNode(2);
		tn.right.right.left=new TreeNode(5);
		tn.right.right.right=new TreeNode(1);
		System.out.println(pathSum(tn, 22));
	}

	static int[] path=new int[1000];
	static List<List<Integer>> outputList;
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		outputList=new ArrayList<>();
		if(root==null)
			return outputList;
		storePath(root,path,0,sum);
		return outputList;
	}
	private static void storePath(TreeNode root, int[] path, int level,int mainSum) {
		if(root==null)
			return;
		if(root.left==null && root.right==null)
		{
			path[level]=root.val;
			int[] newArray=Arrays.copyOf(path, level+1);
			int sum=0;
			List<Integer> list=new ArrayList<>();
			for (int i = 0; i < newArray.length; i++) {
				sum+=newArray[i];
				list.add(newArray[i]);
			}
			if(sum==mainSum)
				outputList.add(list);
		}
		path[level]=root.val;
		storePath(root.left, path, level+1,mainSum);
		storePath(root.right, path, level+1,mainSum);
	}



}

