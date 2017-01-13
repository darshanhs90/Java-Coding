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
		mirror(root.left);
		boolean b=isSameTree(root.left,root.right);
		mirror(root.left);
		return b;
	}
	private static void mirror(TreeNode tn) {
		if(tn==null)
			return;
		mirror(tn.left);
		mirror(tn.right);
		TreeNode temp=tn.left;
		tn.left=tn.right;
		tn.right=temp;
	}
	private static boolean isSameTree(TreeNode left, TreeNode right) {
		if(left==null && right==null)
			return true;
		else if(left==null||right==null)
			return false;
		return left.val==right.val && isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
	}
}
