package servicenowPrep;

import java.util.Stack;

public class _053IterativePreOrderTraversal
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(20);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(22);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(12);
		tn.right.right=new TreeNode(25);
		tn.left.right.left=new TreeNode(10);
		tn.left.right.right=new TreeNode(14);	
		iterativeTraversal(tn);
		System.out.println();
		preOrder(tn);
	}
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			preOrder(tn.left);
			System.out.print(tn.value+"/");
			preOrder(tn.right);
		}		
	}
	private static void iterativeTraversal(TreeNode tn) {
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(tn);
		while(!stack.isEmpty())
		{
			TreeNode tn1=stack.pop();
			System.out.print(tn1.value+"/");
			if(tn1.right!=null)
				stack.push(tn1.right);
			if(tn1.left!=null)
				stack.push(tn1.left);
			
		}
		
	}

	
}