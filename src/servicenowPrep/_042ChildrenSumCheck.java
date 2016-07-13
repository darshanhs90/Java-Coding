package servicenowPrep;
public class _042ChildrenSumCheck
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
		System.out.println(checkSum(tn));
	}

	private static boolean checkSum(TreeNode tn) {
		if(tn==null||tn.left==null&&tn.right==null)
			return true;
		int leftValue=tn.left!=null?tn.left.value:0;
		int rightValue=tn.right!=null?tn.right.value:0;
		return tn.value==leftValue+rightValue && checkSum(tn.left) && checkSum(tn.right);
	}	

}