package LeetCodePerformancePractice;

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
		return isSymmetricUtil(root.left,root.right);
	}
	private static boolean isSymmetricUtil(TreeNode tn,TreeNode tn1) {
		if(tn!=null && tn1!=null)
		{
			return tn.val==tn1.val && isSymmetricUtil(tn.left, tn1.right) && isSymmetricUtil(tn.right, tn1.left);
		}
		if(tn1!=null ||tn!=null)
			return false;
		return true;
	}

}
