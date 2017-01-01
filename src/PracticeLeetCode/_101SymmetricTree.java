package PracticeLeetCode;

public class _101SymmetricTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		tn.right.right=new TreeNode(3);
		tn.right.left=new TreeNode(4);
		tn.left.right=new TreeNode(4);
		System.out.println(isSymmetric(tn));
		tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(2);
		tn.right.right=new TreeNode(3);
		tn.left.right=new TreeNode(3);
		System.out.println(isSymmetric(tn));
	}
	public static boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		return isSymmetric(root.left,root.right);
	}
	private static boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left==null && right==null)
			return true;
		if(left==null||right==null)
			return false;
		return left.val==right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right,right.left);
	}

}
