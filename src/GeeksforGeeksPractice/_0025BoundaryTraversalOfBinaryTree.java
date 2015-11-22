package GeeksforGeeksPractice;

public class _0025BoundaryTraversalOfBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(20);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(22);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(12);
		tn.left.right.left=new TreeNode(10);
		tn.left.right.right=new TreeNode(14);
		tn.right.right=new TreeNode(25);
		boundaryTraversal(tn);
		//20//8//4//
		//4//10//14//25//
		//20//22//25//
	}
	private static void boundaryTraversal(TreeNode tn) {
		printLeftNodes(tn);System.out.println();
		printLeafNodes(tn);System.out.println();
		printRightNodes(tn);
	}
	private static void printLeafNodes(TreeNode tn) {
		if(tn!=null)
		{
			if(tn.left==null && tn.right==null)
				System.out.print(tn.val+"//");
			printLeafNodes(tn.left);
			printLeafNodes(tn.right);
		}
		
	}
	private static void printLeftNodes(TreeNode tn) {
		if(tn!=null)
		{
			System.out.print(tn.val+"//");
			printLeftNodes(tn.left);
		}
	}
	private static void printRightNodes(TreeNode tn) {
		if(tn!=null)
		{
			printRightNodes(tn.right);
			System.out.print(tn.val+"//");
		}
	}
	

}
