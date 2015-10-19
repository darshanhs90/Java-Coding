package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * Link : https://leetcode.com/problems/binary-tree-right-side-view/
 */

public class _199RightSideViewBinaryTree {
	static int maxLevel=0;
	static List<Integer> list;
	public static List<Integer> rightSideView(TreeNode root) {
		maxLevel=0;
		list=new ArrayList<>();
		rightView(root,1);
		return list;
	}
	private static void rightView(TreeNode root, int level) {
		
		if(root==null)
			return;
		if(maxLevel<level){
			list.add(root.val);
			maxLevel=level;
		}
		rightView(root.right, level+1);//interchange for left side view
		rightView(root.left, level+1);
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
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(4);
		tn.left.right.left=new TreeNode(5);
		tn.left.left=new TreeNode(6);
		rightSideView(tn);
	}
}