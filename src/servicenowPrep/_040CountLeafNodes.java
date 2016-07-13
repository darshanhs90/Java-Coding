package servicenowPrep;

public class _040CountLeafNodes
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}
	static int[] path=new int[1000];
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		System.out.println(countLeafNodes(tn));
	}
	private static int countLeafNodes(TreeNode tn) {
		if(tn==null)
			return 0;
		if(tn.left==null && tn.right==null)
			return 1;
		return countLeafNodes(tn.left)+countLeafNodes(tn.right);
	}

	
}