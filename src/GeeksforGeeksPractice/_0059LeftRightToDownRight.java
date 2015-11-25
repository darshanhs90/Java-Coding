package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/check-given-binary-tree-follows-height-property-red-black-tree/
 */
public class _0059LeftRightToDownRight {
	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(4);
		tn.right.right = new TreeNode(5);
		tn.right.left.left = new TreeNode(6);
		tn.right.right.left = new TreeNode(7);
		tn.right.right.right = new TreeNode(8);
		convertRepresentation(tn);
		downRightTraversal(tn);
	}


	private static void downRightTraversal(TreeNode tn) {
		if(tn!=null)
		{
			System.out.print(tn.value+"//");
			downRightTraversal(tn.right);
			downRightTraversal(tn.left);
		}
	}


	private static void convertRepresentation(TreeNode tn) {
		if(tn!=null)
		{
			convertRepresentation(tn.left);
			convertRepresentation(tn.right);
			if(tn.left==null)
				tn.left=tn.right;
			else
				tn.left.right=tn.right;
			tn.right=null;
		}

	}


	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
