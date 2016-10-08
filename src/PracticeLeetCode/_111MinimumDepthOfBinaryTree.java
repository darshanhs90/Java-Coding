package PracticeLeetCode;

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
		if(root.left==null && root.right==null)
			return 1;
		return Math.min(getMinDepth(root.left,1), getMinDepth(root.right,1));
	}
	private static int getMinDepth(TreeNode root, int depth) {
		if(root==null)
			return Integer.MAX_VALUE;
		if(root.left==null && root.right==null)
			return depth+1;
		return Math.min(getMinDepth(root.left, depth+1), getMinDepth(root.right, depth+1));
	}

}
