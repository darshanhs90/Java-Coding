package leetCode;

/*
 * Link : https://leetcode.com/problems/path-sum/
 */

public class _114FlattenBinaryTreeLinkedList {
	static TreeNode tn;
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void flatten(TreeNode root) {
		TreeNode tn=new TreeNode(0);
		TreeNode temp=tn;
		preOrderChange(root);
		root=tn.right;
	}
	private static void preOrderChange(TreeNode root) {
		if(root!=null)
		{
			tn=root;
			//System.out.println(root.val);
			tn=tn.right;
			preOrderChange(root.left);
			preOrderChange(root.right);
		}
	}
	private static void preOrder(TreeNode root) {
		if(root!=null)
		{
			System.out.println(root.val);
			//preOrder(root.left);
			preOrder(root.right);
		}
	}
	public static void main(String[] args) {
		TreeNode tNode=new TreeNode(1);
		tNode.left=new TreeNode(2);
		tNode.right=new TreeNode(5);
		tNode.left.left=new TreeNode(3);
		tNode.left.right=new TreeNode(4);
		tNode.right.right=new TreeNode(6);
		flatten(tNode);
		preOrder(tNode);
	}
}