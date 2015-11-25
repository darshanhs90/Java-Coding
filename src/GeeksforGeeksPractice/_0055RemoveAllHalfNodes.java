package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/given-a-binary-tree-how-do-you-remove-all-the-half-nodes/
 */
public class _0055RemoveAllHalfNodes {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(2);
		tn.left=new TreeNode(7);
		tn.right=new TreeNode(5);
		tn.left.right=new TreeNode(6);
		tn.left.right.left=new TreeNode(1);
		tn.left.right.right=new TreeNode(11);
		tn.right.right=new TreeNode(9);
		tn.right.right.left=new TreeNode(4);
		preOrder(tn);System.out.println();
		tn=removeAllHalfNodes(tn);
		preOrder(tn);
	}
	



	private static TreeNode removeAllHalfNodes(TreeNode tn) {
		if(tn!=null)
		{
			tn.left=removeAllHalfNodes(tn.left);
			tn.right=removeAllHalfNodes(tn.right);
			if(tn.left==null && tn.right==null)
				return tn;
			if(tn.left==null)
			{
				TreeNode temp=tn.right;
				tn=null;
				return temp;
			}
			
			if(tn.right==null)
			{
				TreeNode temp=tn.left;
				tn=null;
				return temp;
			}			
		}
		return tn;
	}

	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			System.out.print(tn.value+"->");
			preOrder(tn.left);
			preOrder(tn.right);
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
