package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

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
	static List<List<Integer>> outputList;
	static List<Integer> levelList;
	public static List<List<Integer>> zigzagLevelOrder(TreeNode tn) {
		outputList=new ArrayList<>();
		int height=getHeight(tn);
		boolean order=true;
		for (int i = 0; i < height; i++) {
			levelList=new ArrayList<>();
			printNodes(tn,i,order);
			order=!order;
			outputList.add(levelList);
		}
		return outputList;
	}
	private static void printNodes(TreeNode tn, int level,boolean order) {
		if(tn==null||level<0)
			return;
		if(level==0)
			levelList.add(tn.val);
		if(order){
			printNodes(tn.left, level-1,order);
			printNodes(tn.right, level-1,order);
		}
		else{
			printNodes(tn.right, level-1,order);
			printNodes(tn.left, level-1,order);
		}
	}
	private static int getHeight(TreeNode tn) {
		if(tn==null)
			return 0;
		return 1+Math.max(getHeight(tn.left), getHeight(tn.right));
	}

}
