package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/
 */
public class _0057RemoveNodesSumPath {
	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		tn.right.left = new TreeNode(6);
		tn.right.right = new TreeNode(7);
		tn.left.left.left = new TreeNode(8);
		tn.left.left.right = new TreeNode(9);
		tn.left.right.left = new TreeNode(12);
		tn.right.right.left = new TreeNode(10);
		tn.right.right.left.right = new TreeNode(11);
		tn.left.left.right.left = new TreeNode(13);
		tn.left.left.right.right = new TreeNode(14);
		tn.left.left.right.right.left = new TreeNode(15);
		preOrder(tn);System.out.println();
		tn=pruneTree(tn,20);
		preOrder(tn);

	}



	private static TreeNode pruneTree(TreeNode tn, int k) {
		return pruneTreeUtil(tn,k);
	}

	private static TreeNode pruneTreeUtil(TreeNode tn,int sum) {
		if(tn!=null)
		{
			tn.left=pruneTreeUtil(tn.left,sum-tn.value);
			tn.right=pruneTreeUtil(tn.right,sum-tn.value);
			if(tn.left==null && tn.right==null)
			{
				if(tn.value<sum)
				{
					tn=null;
				}
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
