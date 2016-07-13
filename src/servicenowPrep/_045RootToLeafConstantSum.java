package servicenowPrep;
public class _045RootToLeafConstantSum
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
		System.out.println(rootSum(tn,114));
	}



	private static boolean rootSum(TreeNode tn, int sum) {
		if(tn==null)
			return false;
		sum-=tn.value;
		if(sum==0 && tn.right==null && tn.left==null)
			return true;
		return rootSum(tn.left, sum)||rootSum(tn.right, sum);
	}



	private static int getHeight(TreeNode left) {
		return left==null?0:1+Math.max(getHeight(left.left), getHeight(left.right));
	}



}