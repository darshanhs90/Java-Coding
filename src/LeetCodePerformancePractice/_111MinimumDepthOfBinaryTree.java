package LeetCodePerformancePractice;

public class _111MinimumDepthOfBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		//tn.left=new TreeNode(2);
		System.out.println(minDepth(tn));
	}
	public static int minDepth(TreeNode root) {
		if(root==null)
			return 0;
		return getMinDepth(root,1);
	}
	private static int getMinDepth(TreeNode tn, int depth) {
		if(tn!=null && (tn.left!=null || tn.right!=null))
			return Math.min(getMinDepth(tn.left,depth+1), getMinDepth(tn.right,depth+1));
		if(tn==null||tn.left!=null ||tn.right!=null)
			return Integer.MAX_VALUE;
		return depth;
	}

}
