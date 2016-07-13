package servicenowPrep;
public class _046DoubleTree
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
		tn=(doubleTree(tn));
		preOrder(tn);
	}

	private static void preOrder(TreeNode tn) {
		if(tn==null)
			return;
		preOrder(tn.left);
		preOrder(tn.right);
		System.out.println(tn.value);
	}

	private static TreeNode doubleTree(TreeNode tn) {
		if(tn==null)
			return tn;
		doubleTree(tn.left);
		doubleTree(tn.right);
		TreeNode oldLeft=tn.left;
		tn.left=new TreeNode(tn.value);
		tn.left.left=oldLeft;
		return tn;
	}






}