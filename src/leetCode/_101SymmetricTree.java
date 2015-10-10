package leetCode;

/*
 * Link : https://leetcode.com/problems/symmetric-tree/
 */

public class _101SymmetricTree {
	public static boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		else
			return isSymmetricTree(root.left,root.right);
		
	}
	private static boolean isSymmetricTree(TreeNode left, TreeNode right) {
		if(left==null && right!=null
				||left!=null && right==null)
			return false;
		else
			if(left!=null && right!=null)
				return left.val==right.val && isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right,right.left);
		return true;
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		System.out.println(isSymmetric(tn));
	}
}