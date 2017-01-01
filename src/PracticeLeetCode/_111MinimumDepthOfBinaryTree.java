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
		tn.left=new TreeNode(2);
		System.out.println(minDepth(tn));
	}
	public static int minDepth(TreeNode root) {

	}

}
