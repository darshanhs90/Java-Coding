package Nov2020_FBPrep;

public class _037DiameterOfBinaryTree {
	static public class TreeNode {
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
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		System.out.println(diameterOfBinaryTree(tn));
	}

	static int diameter;

	public static int diameterOfBinaryTree(TreeNode root) {
		diameter = 0;
		if (root == null)
			return diameter;
		findHeight(root);
		return diameter;
	}

	public static int findHeight(TreeNode root) {
		if (root == null)
			return 0;

		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);

		diameter = Math.max(diameter, leftHeight + rightHeight);
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
