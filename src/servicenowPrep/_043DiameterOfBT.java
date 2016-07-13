package servicenowPrep;
public class _043DiameterOfBT
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
		System.out.println(diameter(tn));
	}

	private static int diameter(TreeNode tn) {
		if(tn==null)
			return 0;
		int ld=diameter(tn.left);
		int rd=diameter(tn.right);
		return Math.max(getHeight(tn.left)+getHeight(tn.right)+1,Math.max(ld, rd));
	}

	private static int getHeight(TreeNode left) {
		return left==null?0:1+Math.max(getHeight(left.left), getHeight(left.right));
	}



}