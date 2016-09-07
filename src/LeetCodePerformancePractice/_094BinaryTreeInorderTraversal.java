package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

public class _094BinaryTreeInorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static List<Integer> output;
	public List<Integer> inorderTraversal(TreeNode root) {
		output=new ArrayList<>();
		inorder(root);
		return output;
	}
	private void inorder(TreeNode root) {
		if(root!=null)
		{
			inorder(root.left);
			output.add(root.val);
			inorder(root.right);
		}
	}

}
