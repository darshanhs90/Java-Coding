package servicenowPrep;
public class _047FoldableBinaryTrees
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
		tn.left=new TreeNode(7);
		tn.right=new TreeNode(15);
		tn.left.left=new TreeNode(9);
		//tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(11);
		System.out.println(isFoldable(tn));
	}

	private static boolean isFoldable(TreeNode tn) {
		if(tn==null)
			return true;
		mirror(tn.left);
		boolean res=isFoldableTrees(tn.left,tn.right);
		mirror(tn.left);
		return res;
	}

	private static boolean isFoldableTrees(TreeNode tn1, TreeNode tn2) {
		if(tn1==null && tn2==null)
			return true;
		if(tn1==null||tn2==null)
			return false;
		return isFoldableTrees(tn1.left,tn2.left) && isFoldableTrees(tn1.right,tn2.right);
	}

	private static void mirror(TreeNode tn) {
		if(tn==null)
			return;
		mirror(tn.left);
		mirror(tn.right);
		TreeNode temp=tn.left;
		tn.left=tn.right;
		tn.right=temp;
	}

	


}