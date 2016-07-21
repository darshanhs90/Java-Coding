package LeetCodePractice;

import java.util.ArrayList;
import java.util.List;

public class _102BinaryTreeLevelOrderTraversal {

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
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		levelOrder(tn);
	}
	static List<Integer> list;
	public static List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> outputList=new ArrayList<>();
		if(root!=null)
		{
			int height=getHeight(root);
			for (int i = 0; i < height; i++) {
				list=new ArrayList<>();
				printNodes(root,i,list);
				outputList.add(list);
			}
		}
		return outputList;
	}

	private static void printNodes(TreeNode tn, int level, List<Integer> list) {
		if(tn==null)
			return;
		if(level==0)
		{
			list.add(tn.val);
		}
		printNodes(tn.left, level-1,list);
		printNodes(tn.right, level-1,list);
	}

	private static int getHeight(TreeNode tn) {
		if(tn!=null)
		{
			return 1+Math.max(getHeight(tn.left), getHeight(tn.right));
		}
		return 0;
	}


}

