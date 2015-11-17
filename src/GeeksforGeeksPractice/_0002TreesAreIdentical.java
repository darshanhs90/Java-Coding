package GeeksforGeeksPractice;

public class _0002TreesAreIdentical {
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(4);
		tn.left.left=new TreeNode(5);
		tn.left.left.left=new TreeNode(6);
		tn.left.left.left.left=new TreeNode(7);
		TreeNode tn1=new TreeNode(1);
		tn1.left=new TreeNode(2);
		tn1.right=new TreeNode(3);
		tn1.left.right=new TreeNode(4);
		tn1.left.left=new TreeNode(5);
		tn1.left.left.left=new TreeNode(6);
		tn1.left.left.left.left=new TreeNode(8);
		System.out.println(isIdentical(tn,tn1));//returns false
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static boolean isIdentical(TreeNode tn,TreeNode tn1)
	{	
		if(tn!=null || tn1!=null)
		{
			if(tn!=null && tn1!=null)
			{
				return tn.val==tn1.val && isIdentical(tn.left, tn1.left) && isIdentical(tn.right, tn1.right);
			}
			return false;
		}
		return true;
	}
}
