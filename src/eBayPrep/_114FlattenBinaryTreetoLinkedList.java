package eBayPrep;

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
		System.out.println();
		flatten(tn);
	}
	private static void flatten(TreeNode tn) {
		if(tn==null)
			return;
		Stack<TreeNode> stack=new Stack<>();
		TreeNode pointer=tn;
		while(tn!=null)
		{
			if(tn.right!=null)
				stack.push(tn.right);
			if(tn.left!=null){
				tn.right=tn.left;
				tn.left=null;
			}
			else if(!stack.isEmpty()){
				tn.right=stack.pop();
			}
			tn=tn.right;
		}
		preOrder(pointer);
	}
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			preOrder(tn.left);
			System.out.print(tn.val+"/");
			preOrder(tn.right);
		}

	}

}

