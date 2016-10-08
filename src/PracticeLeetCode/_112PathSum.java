package PracticeLeetCode;

public class _112PathSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)
			return false;
		if(sum==root.val && root.left==null && root.right==null)
			return true;
		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
	}

}
