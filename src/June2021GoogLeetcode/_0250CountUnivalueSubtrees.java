package June2021GoogLeetcode;

public class _0250CountUnivalueSubtrees {

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
		TreeNode tn = new TreeNode(5);
		tn.left = new TreeNode(1);
		tn.left.left = new TreeNode(5);
		tn.left.right = new TreeNode(5);
		tn.right = new TreeNode(5);
		tn.right.right = new TreeNode(5);
		System.out.println(countUnivalSubtrees(tn));
	}

	static int count = 0;

	public static int countUnivalSubtrees(TreeNode root) {
		count = 0;
		if (root == null)
			return 0;
		helper(root);
		return count;
	}

	static class Helper {
		boolean isValid;
		Integer childVal;

		public Helper(Integer childVal, boolean isValid) {
			this.childVal = childVal;
			this.isValid = isValid;
		}
	}

	public static Helper helper(TreeNode root) {
		if (root == null)
			return new Helper(null, true);
		if (root.left == null && root.right == null) {
			count++;
			return new Helper(root.val, true);
		}
		Helper helper1 = helper(root.left);
		Helper helper2 = helper(root.right);

		if (helper1.isValid && helper2.isValid && (helper1.childVal == null || helper1.childVal == root.val)
				&& (helper2.childVal == null || helper2.childVal == root.val)) {
			count++;
			return new Helper(root.val, true);
		} else {
			return new Helper(root.val, false);
		}
	}

}
