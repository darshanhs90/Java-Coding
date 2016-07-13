package servicenowPrep;
public class _044BTBalanced
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
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(2);
		System.out.println(isbalanced(tn));
	}


	private static boolean isbalanced(TreeNode tn) {
		if(tn==null)
			return true;
		int lh=getHeight(tn.left);
		int rh=getHeight(tn.right);
		return Math.abs(lh-rh)<=1 && isbalanced(tn.left) && isbalanced(tn.right);
	}


	private static int getHeight(TreeNode left) {
		return left==null?0:1+Math.max(getHeight(left.left), getHeight(left.right));
	}



}