package Dec2020Leetcode;

public class _0098ValidateBinarySearchTree {
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

		tn = new TreeNode(1);
		tn.left = new TreeNode(3);
		tn.right = new TreeNode(2);
		System.out.println(isValidBST(tn));

		tn = new TreeNode(3);
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(5);
		tn.left.left = new TreeNode(0);
		tn.left.right = new TreeNode(2);
		tn.right.left = new TreeNode(4);
		tn.right.right = new TreeNode(6);
		System.out.println(isValidBST(tn));
	}

	public static boolean isValidBST(TreeNode root) {
		return isValidBST(Long.MIN_VALUE, root, Long.MAX_VALUE);
	}

	public static boolean isValidBST(long minValue, TreeNode root, long maxValue) {
		if (root == null)
			return true;
		return root.val > minValue && root.val < maxValue && isValidBST(minValue, root.left, root.val)
				&& isValidBST(root.val, root.right, maxValue);
	}
}
