package June2021GoogLeetcode;

public class _0687LongestUnivaluePath {

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(5);
		tn.left = new TreeNode(4);
		tn.left.left = new TreeNode(1);
		tn.left.right = new TreeNode(1);
		tn.right = new TreeNode(5);
		tn.right.right = new TreeNode(5);
		System.out.println(longestUnivaluePath(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(4);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(4);
		tn.right = new TreeNode(5);
		tn.right.right = new TreeNode(5);
		System.out.println(longestUnivaluePath(tn));
	}

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

	static int max;

	public static int longestUnivaluePath(TreeNode root) {
		max = 0;
		if (root == null)
			return 0;
		helper(root);
		return max - 1;
	}

	public static int helper(TreeNode root) {
		if (root == null)
			return 0;

		int leftHelperVal = helper(root.left);
		int rightHelperVal = helper(root.right);

		int leftVal = 0, rightVal = 0;
		if (root.left != null) {
			if (root.left.val == root.val) {
				leftVal = leftHelperVal;
			}
		}

		if (root.right != null) {
			if (root.right.val == root.val) {
				rightVal = rightHelperVal;
			}
		}

		max = Math.max(max, 1 + leftVal + rightVal);
		return 1 + Math.max(leftVal, rightVal);
	}

}
