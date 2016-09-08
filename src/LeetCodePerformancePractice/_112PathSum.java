package LeetCodePerformancePractice;

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
		return checkPathSum(root,0,sum);
	}
	private boolean checkPathSum(TreeNode root, int currSum, int target) {
		if(root==null)
			return false;
		if(root.left==null && root.right==null && currSum+root.val==target)
			return true;
		return checkPathSum(root.left, currSum+root.val, target)||checkPathSum(root.right, currSum+root.val, target);
	}
}
