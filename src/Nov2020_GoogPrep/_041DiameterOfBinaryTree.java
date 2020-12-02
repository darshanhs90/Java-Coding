package Nov2020_GoogPrep;

public class _041DiameterOfBinaryTree {
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

	static int diameter = 0;

	public static int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		diameter = 0;
		getHeight(root);
		return diameter;
	}

	public static int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		diameter = Math.max(diameter, leftHeight + rightHeight);
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
