package LeetCodePractice;

import java.util.ArrayList;
import java.util.List;

public class _103BinaryTreeZigzagLevelOrderTraversal {

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
		zigzagLevelOrder(tn);
	}
	static List<Integer> list;
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(root!=null)
		{
			int height=getHeight(root);
			boolean flag=false;
			for (int i = 0; i < height; i++) {
				list=new ArrayList<>();
				printNodes(root,i,list,flag);
				outputList.add(list);
				flag=!flag;
			}
		}
		return outputList;
	}

	private static void printNodes(TreeNode tn, int level, List<Integer> list, boolean flag) {
		if(tn==null)
			return;
		if(level==0)
		{
			list.add(tn.val);
		}
		if(!flag){
			printNodes(tn.left, level-1,list,flag);
			printNodes(tn.right, level-1,list,flag);
		}
		else{
			printNodes(tn.right, level-1,list,flag);
			printNodes(tn.left, level-1,list,flag);
		}
	}

	private static int getHeight(TreeNode tn) {
		if(tn!=null)
		{
			return 1+Math.max(getHeight(tn.left), getHeight(tn.right));
		}
		return 0;
	}


}

