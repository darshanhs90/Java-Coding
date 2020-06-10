package PracticeLeetCode;

public class _110BalancedBST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(3);
		tn1.left = new TreeNode(9);
		tn1.right = new TreeNode(20);
		tn1.right.left = new TreeNode(15);
		tn1.right.right = new TreeNode(7);
		System.out.println(isBalanced(tn1));

		tn1 = new TreeNode(1);
		tn1.left = new TreeNode(2);
		tn1.right = new TreeNode(2);
		tn1.left.left = new TreeNode(3);
		tn1.left.right = new TreeNode(3);
		tn1.left.left.left = new TreeNode(4);
		tn1.left.left.right = new TreeNode(4);
		System.out.println(isBalanced(tn1));
	}

	public static boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		return Math.abs(leftHeight - rightHeight) <=1 && isBalanced(root.left) && isBalanced(root.right);
	}
	
	public static int getHeight(TreeNode tn)
	{
		if(tn == null)
			return 0;
		return 1 + Math.max(getHeight(tn.left), getHeight(tn.right)); 
	}

}
