package PracticeLeetCode;

public class _104MaximumDepthOfBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
    public int maxDepth(TreeNode root) {
        return root==null?0:1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
