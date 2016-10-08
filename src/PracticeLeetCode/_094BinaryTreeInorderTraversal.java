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
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list=new ArrayList<>();
		if(root==null)
			return list;
		inOrder(root,list);
		return list;
	}
	private void inOrder(TreeNode root, List<Integer> list) {
		if(root==null)
			return ;
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}

}
