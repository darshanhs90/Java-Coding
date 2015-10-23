package GeeksforGeeksPractice;

public class _0012HeightBalanceCheck {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(50);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(30);
		System.out.println(heightBalanceCheck(tn));
	}
	
	private static boolean heightBalanceCheck(TreeNode tn) {
		if(tn!=null)
		{
			int leftHeight=height(tn.left);
			int rightHeight=height(tn.right);
			return Math.abs(leftHeight-rightHeight)<2 && heightBalanceCheck(tn.left) && heightBalanceCheck(tn.right);
		}
		return true;
	}

	private static int height(TreeNode tn) {
		if(tn!=null)
		{
			int leftHeight=0,rightHeight=0;
			if(tn.left!=null)
				leftHeight=height(tn.left);
			if(tn.right!=null)
				rightHeight=height(tn.right);
			return Math.max(leftHeight, rightHeight)+1;
		}
		return 0;
	}


}
