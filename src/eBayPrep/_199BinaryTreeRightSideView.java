package LeetCodePractice;

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
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(5);
		tn.right.right=new TreeNode(4);
		rightSideView(tn);
	}
	static List<Integer> list;
	public static List<Integer> rightSideView(TreeNode tn) {
		list=new ArrayList<>();
		int height=getHeight(tn);
		for (int i = 0; i < height; i++) {
			b=false;
			printNodes(tn,i);
		}
		return list;
	}
	static boolean b=false;
	private static void printNodes(TreeNode tn, int i) {
		if(tn==null||b)return;
		if(i==0 && !b){
			list.add(tn.val);
			b=true;
		}
		printNodes(tn.right, i-1);
		printNodes(tn.left, i-1);
	}
	private static int getHeight(TreeNode tn) {
		return tn!=null?1+Math.max(getHeight(tn.left), getHeight(tn.right)):0;
	}
}

