package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * Link : https://leetcode.com/problems/binary-tree-preorder-traversal/
 */

public class _144BinaryTreePreOrderTraversal {
	static List<Integer> list;
	public List<Integer> preorderTraversal(TreeNode root) {
		list=new ArrayList<>();
		preOrder(root);
		return list;
	}
	public void preOrder(TreeNode root)
	{
		if(root!=null)
		{
			list.add(root.val);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}