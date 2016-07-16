package servicenowPrep;

import java.util.HashMap;

public class _052BoundaryTraversal
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
		boundaryTraversal(tn);
	}

	private static void boundaryTraversal(TreeNode tn) {
		printLeftNodes(tn);System.out.println();
		printLeafNodes(tn);System.out.println();
		printRightNodes(tn);
	}

	private static void printRightNodes(TreeNode tn) {
		if(tn!=null)
		{	
			printLeftNodes(tn.right);
			System.out.print(tn.value+"/");
		}
	}

	private static void printLeafNodes(TreeNode tn) {
		if(tn!=null)
		{
			if(tn.left==null && tn.right==null)
				System.out.print(tn.value+"/");
			printLeafNodes(tn.left);
			printLeafNodes(tn.right);			
		}
	}

	private static void printLeftNodes(TreeNode tn) {
		if(tn!=null)
		{	
			System.out.print(tn.value+"/");
			printLeftNodes(tn.left);
		}
	}

}