package leetCode;

/*
 * Link : https://leetcode.com/problems/move-zeroes/
 */

public class _235LCABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)
			return null;
		if(root.val==p.val||root.val==q.val)
			return root;
		TreeNode leftNode=lowestCommonAncestor(root.left, p, q);
		TreeNode rightNode=lowestCommonAncestor(root.right, p, q);
		if(leftNode!=null && rightNode!=null)
			return root;
		return leftNode!=null?leftNode:rightNode;
	}


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}