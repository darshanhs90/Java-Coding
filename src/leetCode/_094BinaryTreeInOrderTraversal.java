package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * Link : https://leetcode.com/problems/merge-sorted-array/
 */

public class _094BinaryTreeInOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static List<Integer> list;
	public List<Integer> inorderTraversal(TreeNode root) {
		list=new ArrayList<>();
		inOrder(root);
		return list;
	}
	public void inOrder(TreeNode root)
	{
		if(root!=null)
		{
			inOrder(root.left);
			list.add(root.val);
			inOrder(root.right);
		}
	}
}