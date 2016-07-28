package eBayPrep;

public class _236LowestCommonAncestorofaBinaryTree{
	public static class TreeNode {
		int val;
		TreeNode left,right;
		TreeNode(int x) { val = x; }
	}
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null||p==root||q==root)
			return root;
		TreeNode left=lowestCommonAncestor(root.left, p, q);
		TreeNode right=lowestCommonAncestor(root.right, p, q);
		if(left!=null && right!=null)
			return root;
		return left==null?right:left;
	}
}

