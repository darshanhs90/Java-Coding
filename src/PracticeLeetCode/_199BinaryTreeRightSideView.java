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
	static boolean added=false;
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list=new ArrayList<>();
		if(root==null)
			return list;
		int height=getHeight(root);
		for (int i = 0; i < height; i++) {
			printNodes(root,i,list);
			added=false;
		}
		return list;
	}
	private static void printNodes(TreeNode root, int i, List<Integer> list) {
		if(root==null||added)
			return;
		if(i==0){
			list.add(root.val);
			added=true;
			return;
		}
		printNodes(root.right, i-1, list);
		printNodes(root.left, i-1, list);
	}
	private static int getHeight(TreeNode root) {
		return root==null?0:1+Math.max(getHeight(root.left), getHeight(root.right));
	}
}