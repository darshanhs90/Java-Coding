package PracticeLeetCode;

public class _226InvertBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(4);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(7);
		tn.left.left=new TreeNode(1);
		tn.left.right=new TreeNode(3);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(9);
		preOrder(tn);
		tn=invertTree(tn);
		System.out.println();
		preOrder(tn);
	}
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			preOrder(tn.left);
			System.out.print(tn.val+"/");
			preOrder(tn.right);
		}

	}
	public static TreeNode invertTree(TreeNode root) {
		if(root==null)
			return root;
		TreeNode newLeft=invertTree(root.left);
		TreeNode newRight=invertTree(root.right);
		root.right=newLeft;
		root.left=newRight;
		return root;
	}
}
