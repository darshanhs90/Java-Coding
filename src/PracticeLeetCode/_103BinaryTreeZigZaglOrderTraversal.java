package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

import PracticeLeetCode._102BinaryTreeLevelOrderTraversal.TreeNode;

public class _103BinaryTreeZigZaglOrderTraversal {
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
		System.out.println(zigzagLevelOrder(tn));
		tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(2);
		tn.right.right=new TreeNode(3);
		tn.left.right=new TreeNode(3);
		System.out.println(zigzagLevelOrder(tn));
	}
	static List<Integer> list;
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(root==null)
			return outputList;
		int height=getHeight(root);
		for (int i = 0; i < height; i++) {
			list=new ArrayList<>();
			if(i%2==0)
				printLevel(true,i,root);
			else
				printLevel(false,i,root);
			outputList.add(list);
		}
		return outputList;
	}
	private static void printLevel(boolean flag,int level, TreeNode root) {
		if(root==null)
			return;
		if(level==0){
			list.add(root.val);
			return;
		}
		if(flag){
			printLevel(flag,level-1, root.left);
			printLevel(flag,level-1, root.right);
		}
		else{
			printLevel(flag,level-1, root.right);
			printLevel(flag,level-1, root.left);
		}
	}
	private static int getHeight(TreeNode root) {
		return root==null?0:1+Math.max(getHeight(root.left), getHeight(root.right));
	}
}
