package PracticeLeetCode;

public class _235LowestCommonAncestor {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {


	}
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)
			return root;
		if(root==p||root==q)
			return root;
		TreeNode left=lowestCommonAncestor(root.left, p, q);
		TreeNode right=lowestCommonAncestor(root.right, p, q);
		if(left==null && right==null)
			return null;
		else if(left!=null && right!=null)
		{
			return root;
		}
		else
			return left!=null?left:right;

	}
}
