package Nov2020_FBPrep;

public class _027ValidateBinarySearchTree {
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
		TreeNode tn = new TreeNode(2);
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(3);
		System.out.println(isValidBST(tn));

		tn = new TreeNode(5);
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(4);
		tn.right.left = new TreeNode(3);
		tn.right.right = new TreeNode(6);
		System.out.println(isValidBST(tn));
	}

	public static boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return isValidBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
	}

	public static boolean isValidBST(long minVal, long maxVal, TreeNode tn) {
		if (tn == null)
			return true;
		if (tn.val <= minVal || tn.val >= maxVal)
			return false;

		boolean isValid = true;
		if (tn.left != null) {
			isValid = isValidBST(minVal, tn.val, tn.left);
		}

		if (isValid && tn.right != null) {
			isValid = isValidBST(tn.val, maxVal, tn.right);
		}
		return isValid;
	}
}
