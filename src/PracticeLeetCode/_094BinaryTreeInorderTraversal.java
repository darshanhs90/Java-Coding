package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _094BinaryTreeInorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static List<Integer> list;
	public List<Integer> inorderTraversal(TreeNode root) {
		list=new ArrayList<>();   
		if(root==null)
			return list;
		inOrder(root);
		return list;
	}
	private void inOrder(TreeNode root) {
		if(root!=null)
		{
			inOrder(root.left);
			list.add(root.val);
			inOrder(root.right);
		}
	}
	

}
