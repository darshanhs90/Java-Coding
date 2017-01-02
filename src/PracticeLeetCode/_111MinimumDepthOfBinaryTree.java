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
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		int leftDepth=0,rightDepth=0;
		if(root.left==null)
			leftDepth=Integer.MAX_VALUE;
		else
			leftDepth=minDepth(root.left)+1;
		if(root.right==null)
			rightDepth=Integer.MAX_VALUE;
		else
			rightDepth=minDepth(root.right)+1;
		return Math.min(leftDepth,rightDepth);
	}

}
