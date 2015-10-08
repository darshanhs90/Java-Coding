package leetCode;

/*
 * Link : https://leetcode.com/problems/invert-binary-tree/
 */

public class _226InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if(root.left!=null)
			invertTree(root.left);
		if(root.right!=null)
			invertTree(root.right);
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		return root;
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}