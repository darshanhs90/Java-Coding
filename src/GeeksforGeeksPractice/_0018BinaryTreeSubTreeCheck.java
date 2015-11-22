package GeeksforGeeksPractice;

public class _0018BinaryTreeSubTreeCheck {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn1=new TreeNode(10);
		tn1.left=new TreeNode(8);
		tn1.right=new TreeNode(2);
		tn1.left.left=new TreeNode(3);
		tn1.left.right=new TreeNode(5);
		tn1.right.left=new TreeNode(1);
		tn1.right.right=new TreeNode(30);
		TreeNode tn2=new TreeNode(2);
		tn2.left=new TreeNode(1);
		tn2.right=new TreeNode(30);
		System.out.println(checkBinarySubTree(tn1, tn2));

	}
	public static boolean checkBinarySubTree(TreeNode tn1,TreeNode tn2){
		tn1=getNode(tn1,tn2);
		return isSubTree(tn1,tn2);
	}
	private static boolean isSubTree(TreeNode tn1, TreeNode tn2) {
		if(tn1!=null && tn2!=null)
		{
			return tn1.val==tn2.val && isSubTree(tn1.left, tn2.left) && isSubTree(tn1.right, tn2.right);
		}
		return (tn1!=null ||tn2!=null)?false:true;
	}
	private static TreeNode getNode(TreeNode tn1, TreeNode tn2) {
		if(tn1!=null){
			if(tn1.val==tn2.val)
				return tn1;
			else
			{
				if(getNode(tn1.left, tn2)!=null)
				{
					return getNode(tn1.left, tn2);
				}
				else
					return getNode(tn1.right, tn2);
			}
		}
		return null;
	}

}
