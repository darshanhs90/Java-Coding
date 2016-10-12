package PracticeLeetCode;

import java.util.Stack;

public class _114FlattenBinaryTreeLL {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		flatten(tn);
	}

	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			System.out.println(tn.val);
			preOrder(tn.right);
		}

	}

	public static void flatten(TreeNode root) {
		if(root==null)
			return;
		Stack<TreeNode> stack=new Stack<>();
		while(root!=null || !stack.isEmpty())
		{
			if(root.right!=null)
				stack.push(root.right);
			if(root.left!=null)
			{
				root.right=root.left;
				root.left=null;
			}
			else{
				if(!stack.isEmpty())
					root.right=stack.pop();
			}
			root=root.right;
		}
	}
}
