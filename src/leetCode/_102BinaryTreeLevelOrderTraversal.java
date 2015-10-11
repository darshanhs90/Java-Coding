package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * Link : https://leetcode.com/problems/binary-tree-level-order-traversal/
 */

public class _102BinaryTreeLevelOrderTraversal {
	static List<List<Integer>> list=new ArrayList<List<Integer>>();
	static List<Integer> innerList=new ArrayList<Integer>();
	public static List<List<Integer>> levelOrder(TreeNode root) {
		list=new ArrayList<List<Integer>>();
		levelOrderTraversal(root);
		return list;
	}
	public static void levelOrderTraversal(TreeNode root)
	{
		for (int i = 1; i <=height(root); i++) {
			innerList=new ArrayList<Integer>();
			printNodes(root,i);
			list.add(innerList);
		}
	}
	private static void printNodes(TreeNode root, int level) {
		if(root==null)
			return;
		if(level==1){
			innerList.add(root.val);
			System.out.println(root.val);
		}
		else if(level>1)
		{
			printNodes(root.left, level-1);
			printNodes(root.right, level-1);
		}

	}
	private static  int height(TreeNode root) {

		if(root!=null)
		{
			int leftHeight=height(root.left);
			int rightHeight=height(root.right);
			return 1+Math.max(leftHeight, rightHeight);
		}
		return 0;
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		/*tn.right=new TreeNode(20);
		tn.left.left=new TreeNode(15);
		tn.left.right=new TreeNode(7);*/
		System.out.println(levelOrder(tn).size());


	}
}