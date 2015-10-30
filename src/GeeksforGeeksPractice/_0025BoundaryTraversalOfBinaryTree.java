package GeeksforGeeksPractice;

/*
 * Fuck You Navaneeth,Try copying the code now
 */
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
	}
	private static void boundaryTraversal(TreeNode tn) {
		TreeNode tnLeft=tn,tnLeaf=tn,tnRight=tn;
		printLeftNodes(tnLeft);
		System.out.println();
		printLeafNodes(tnLeaf);
		System.out.println();
		printRightNodes(tnRight);
	}
	private static void printRightNodes(TreeNode tnLeft) {
		while(tnLeft!=null)
		{
			System.out.print(tnLeft.val+"//");
			tnLeft=tnLeft.right;
		}

	}
	private static void printLeafNodes(TreeNode tn) {
		if(tn!=null)
		{
			if(tn.left==null && tn.right==null)
			{
				System.out.print(tn.val+"//");
			}
			printLeafNodes(tn.left);
			printLeafNodes(tn.right);
			
		}
	}
	private static void printLeftNodes(TreeNode tnLeft) {
		while(tnLeft!=null)
		{
			System.out.print(tnLeft.val+"//");
			tnLeft=tnLeft.left;
		}
	}

}
