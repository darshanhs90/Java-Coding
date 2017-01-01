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
	static List<Integer> outputList;
	public List<Integer> inorderTraversal(TreeNode root) {
		outputList=new ArrayList<>();
		inorder(root);
		return outputList;
	}
	private void inorder(TreeNode root) {
		if(root!=null)
		{
			inorder(root.left);
			outputList.add(root.val);
			inorder(root.right);
		}
	}

}
