package servicenowPrep;
public class _035TreeIdentical
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		TreeNode tn1=new TreeNode(1);
		tn1.left=new TreeNode(2);
		tn1.right=new TreeNode(3);
		tn1.left.left=new TreeNode(4);
		tn1.left.right=new TreeNode(5);
		tn1.right.left=new TreeNode(6);
		tn1.right.right=new TreeNode(7);
		System.out.println(isIdentical(tn,tn1));
	}

	private static boolean isIdentical(TreeNode tn, TreeNode tn1) {
		if(tn==null && tn1==null)
			return true;
		if(tn==null||tn1==null)
			return false;
		return tn.value==tn1.value && isIdentical(tn.left, tn1.left) && isIdentical(tn.right, tn1.right);
	}
	
	
	
}