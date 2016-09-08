package LeetCodePerformancePractice;

public class _104MaximumDepthOfBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
	static int maxDepth(TreeNode tn) {
		if(tn==null)
			return 0;
		return 1+Math.max(maxDepth(tn.left), maxDepth(tn.right));
	}

}
