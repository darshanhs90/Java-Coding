package LeetCodePractice;

public class _111MinimumDepthofBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(2);
		tn.right.left=new TreeNode(2);
		
		System.out.println(minDepth(tn));
	}
	
	
	public static int minDepth(TreeNode root) {
		if(root==null)
			return 0;
		return getMinDepth(root);
		
	}


	private static int getMinDepth(TreeNode root) {
		if(root.left!=null && root.right!=null)
			return 1+Math.min(getMinDepth(root.left), getMinDepth(root.right));
		else if(root.left!=null)
			return 1+getMinDepth(root.left);
		else if(root.right!=null)
			return 1+getMinDepth(root.right);
		else 
			return 1;
	}



}

