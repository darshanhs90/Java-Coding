package LeetCodePractice;

import java.util.Stack;

public class _114FlattenBinaryTreetoLinkedList {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(5);
		tn.left.left=new TreeNode(3);
		tn.left.right=new TreeNode(4);
		tn.right.right=new TreeNode(6);
		preOrder(tn);
		flatten(tn);
	}
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			System.out.println(tn.val);
			preOrder(tn.left);
			preOrder(tn.right);
		}

	}
	public static void flatten(TreeNode root) {
		if(root==null)
			return;
		Stack<TreeNode> stack=new Stack<>();
		while(root!=null)
		{
			if(root.right!=null)
				stack.push(root.right);
			if(root.left!=null)
			{
				root.right=root.left;
				root.left=null;
			}else if(!stack.isEmpty()){
				root.right=stack.pop();
			}
			root=root.right;
		}
	}
	
}

