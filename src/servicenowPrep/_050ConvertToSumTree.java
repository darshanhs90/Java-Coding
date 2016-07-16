package servicenowPrep;
public class _050ConvertToSumTree
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(-2);
		tn.right=new TreeNode(6);
		tn.left.left=new TreeNode(8);
		tn.left.right=new TreeNode(-4);
		tn.right.left=new TreeNode(7);
		tn.right.right=new TreeNode(5);
		System.out.println(convertTree(tn));
		preOrder(tn);
	}

	private static int convertTree(TreeNode tn) {
		if(tn==null)
			return 0;
		int old_val=tn.value;
		tn.value=convertTree(tn.left)+convertTree(tn.right);
		return tn.value+old_val;
	}

	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			preOrder(tn.left);
			System.out.println(tn.value);
			preOrder(tn.right);
		}
	}

	


}