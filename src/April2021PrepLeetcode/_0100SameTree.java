package April2021PrepLeetcode;

public class _0100SameTree {
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
		TreeNode tn1 = new TreeNode(1);
		tn1.left = new TreeNode(2);
		tn1.right = new TreeNode(3);
		TreeNode tn2 = new TreeNode(1);
		tn2.left = new TreeNode(2);
		tn2.right = new TreeNode(3);
		System.out.println(isSameTree(tn1, tn2));

		tn1 = new TreeNode(1);
		tn1.left = new TreeNode(2);
		tn2 = new TreeNode(1);
		tn2.right = new TreeNode(2);
		System.out.println(isSameTree(tn1, tn2));

		tn1 = new TreeNode(1);
		tn1.left = new TreeNode(2);
		tn1.right = new TreeNode(1);
		tn2 = new TreeNode(1);
		tn2.left = new TreeNode(1);
		tn2.right = new TreeNode(2);
		System.out.println(isSameTree(tn1, tn2));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		
	}

}
