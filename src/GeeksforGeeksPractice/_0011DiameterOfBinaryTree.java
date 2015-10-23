package GeeksforGeeksPractice;

public class _0011DiameterOfBinaryTree {
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
		System.out.println(diameter(tn));
	}
	private static int diameter(TreeNode tn) {
		if(tn!=null)
		{
			int leftValue=diameter(tn.left);
			int rightValue=diameter(tn.right);
			int leftHeight=height(tn.left);
			int rightHeight=height(tn.right);
			return Math.max(Math.max(leftValue, rightValue),1+leftHeight+rightHeight);
		}
		return 0;
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
