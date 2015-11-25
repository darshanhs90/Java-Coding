package GeeksforGeeksPractice;

/*
 * Link : http://geeksquiz.com/find-maximum-or-minimum-in-binary-tree/
 */
public class _0053MaximumValueBinaryTree {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(2);
		tn.left=new TreeNode(7);
		tn.right=new TreeNode(5);
		tn.left.right=new TreeNode(6);
		tn.left.right.left=new TreeNode(1);
		tn.left.right.right=new TreeNode(11);
		tn.right.right=new TreeNode(9);
		tn.right.right.left=new TreeNode(4);
		System.out.println(findMax(tn));
		System.out.println(findMin(tn));
		
	}

	

	private static int findMin(TreeNode tn) {
		if(tn!=null)
		{
			return Math.min(tn.value,Math.min(findMin(tn.left),findMin(tn.right)));
		}
		return Integer.MAX_VALUE;
	}



	private static int findMax(TreeNode tn) {
		if(tn!=null)
		{
			return Math.max(tn.value,Math.max(findMax(tn.left),findMax(tn.right)));
		}
		return Integer.MIN_VALUE;
	}



	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
