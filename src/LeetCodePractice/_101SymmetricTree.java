package LeetCodePractice;

public class _101SymmetricTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isSymmetric(TreeNode root) {
		if(root!=null)
		{
			return checkSymmetry(root.left,root.right);
		}
		return true;
	}

	private boolean checkSymmetry(TreeNode left, TreeNode right) {
		if(left!=null && right!=null)
		{
			return left.val==right.val && checkSymmetry(left.right, right.left) && checkSymmetry(left.left, right.right);
		}
		else if(left!=null || right!=null)
			return false;
		return true;
	}


}

