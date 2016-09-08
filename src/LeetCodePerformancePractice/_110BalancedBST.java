package LeetCodePerformancePractice;

public class _110BalancedBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static boolean isBalanced(TreeNode root) {
		if(root==null)
			return true;
		return Math.abs(getHeight(root.left)-getHeight(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
	}
	private static int getHeight(TreeNode tn) {
		return tn==null?0:1+Math.max(getHeight(tn.left), getHeight(tn.right));
	}

}
