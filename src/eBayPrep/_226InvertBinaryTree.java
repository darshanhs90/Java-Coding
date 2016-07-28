package eBayPrep;

public class _226InvertBinaryTree{
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
		preOrder(tn);System.out.println();
		tn=invertTree(tn);
		preOrder(tn);
	}
	private static TreeNode invertTree(TreeNode tn) {
		if(tn==null)
			return tn;
		invertTree(tn.left);
		invertTree(tn.right);
		TreeNode tn1=tn.left;
		tn.left=tn.right;
		tn.right=tn1;
		return tn;
	}
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			preOrder(tn.left);System.out.print(tn.val+"/");preOrder(tn.right);
		}
	}


}

