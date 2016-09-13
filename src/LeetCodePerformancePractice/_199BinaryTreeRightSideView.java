package LeetCodePerformancePractice;

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
	static List<Integer> outputList;
	public static List<Integer> rightSideView(TreeNode root) {
		outputList=new ArrayList<>();
		if(root==null)
			return outputList;
		int length=getLength(root);
		for (int i = 0; i < length; i++) {
			added=false;
			getNode(root,i);
		}
		return outputList;
	}
	private static void getNode(TreeNode root,int level) {
		if(added||root==null)
			return;
		if(level==0)
		{
			outputList.add(root.val);
			added=true;
			return;
		}
		getNode(root.right, level-1);
		getNode(root.left, level-1);
	}
	private static int getLength(TreeNode root) {
		return root==null?0:1+Math.max(getLength(root.left), getLength(root.right));
	}

}