package servicenowPrep;
public class _049IsSumTree
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(26);
		tn.left=new TreeNode(10);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(6);
		//tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(31);
		System.out.println(isSumTree(tn));
	}

	private static boolean isSumTree(TreeNode tn) {
		if(tn==null||tn.left==null && tn.right==null)
			return true;
		int leftSum=getSum(tn.left);
		int rightSum=getSum(tn.right);
		return tn.value==leftSum+rightSum && isSumTree(tn.left) && isSumTree(tn.right);
	}

	private static int getSum(TreeNode tn) {
		if(tn==null)
			return 0;
		return tn.value+getSum(tn.left)+getSum(tn.right);
	}

	
	


}