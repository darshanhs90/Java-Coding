package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

import PracticeLeetCode._102BinaryTreeLevelOrderTraversal.TreeNode;

public class _107BinaryTreeLevelOrderTraversal2 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		tn.right.right=new TreeNode(3);
		tn.right.left=new TreeNode(4);
		tn.left.right=new TreeNode(4);
		System.out.println(levelOrderBottom(tn));
		tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(2);
		tn.right.right=new TreeNode(3);
		tn.left.right=new TreeNode(3);
		System.out.println(levelOrderBottom(tn));
	}
	static List<Integer> list;
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(root==null)
			return outputList;
		int height=getHeight(root);
		for (int i = height-1; i >=0; i--) {
			list=new ArrayList<>();
			printLevel(i,root);
			outputList.add(list);
		}
		return outputList;
	}
	private static void printLevel(int level, TreeNode root) {
		if(root==null)
			return;
		if(level==0){
			list.add(root.val);
			return;
		}
		printLevel(level-1, root.left);
		printLevel(level-1, root.right);
	}
	private static int getHeight(TreeNode root) {
		return root==null?0:1+Math.max(getHeight(root.left), getHeight(root.right));
	}

}
