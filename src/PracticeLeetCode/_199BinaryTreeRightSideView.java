package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _199BinaryTreeRightSideView {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		System.out.println(rightSideView(tn));
	}
	static List<Integer> outputList;
	static boolean added;
	public static List<Integer> rightSideView(TreeNode root) {
		outputList=new ArrayList<>();
		int height=getHeight(root);
		for (int i = 0; i < height; i++) {
			added=false;
			printNodes(i,root);
		}
		return outputList;
	}
	private static void printNodes(int level, TreeNode root) {
		if(root==null||added)
			return;
		if(level==0)
		{
			outputList.add(root.val);
			added=true;
			return;
		}
		printNodes(level-1, root.right);
		printNodes(level-1, root.left);
	}
	private static int getHeight(TreeNode root) {
		return root==null?0:1+Math.max(getHeight(root.left), getHeight(root.right));
	}
}