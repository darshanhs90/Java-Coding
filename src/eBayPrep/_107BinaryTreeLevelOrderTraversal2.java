package LeetCodePractice;

public class _107BinaryTreeLevelOrderTraversal2 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int maxDepth(TreeNode tn) {
		if(tn!=null)
		{
			return 1+Math.max(maxDepth(tn.left), maxDepth(tn.right));
		}
		return 0;
	}



}

