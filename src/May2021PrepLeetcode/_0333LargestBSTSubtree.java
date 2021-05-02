package May2021PrepLeetcode;

public class _0333LargestBSTSubtree {

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(10);
		tn.left = new TreeNode(5);
		tn.right = new TreeNode(15);
		tn.left.left = new TreeNode(1);
		tn.left.right = new TreeNode(8);
		tn.right.right = new TreeNode(7);
		System.out.println(largestBSTSubtree(tn));
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

	static class Helper {
		int min, max;
		int count;
		boolean isValid;

		public Helper(int max, int min, int count, boolean isValid) {
			this.min = min;
			this.max = max;
			this.count = count;
			this.isValid = isValid;
		}
	}

	static int maxCount;

	public static int largestBSTSubtree(TreeNode root) {
		maxCount = 0;
		if (root == null)
			return 0;
		subtreeHelper(root);
		return maxCount;
	}

	public static Helper subtreeHelper(TreeNode root) {
		if (root == null)
			return new Helper(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
		if (root.left == null && root.right == null) {
			maxCount = Math.max(maxCount, 1);
			return new Helper(root.val, root.val, 1, true);
		}

		Helper helper1 = subtreeHelper(root.left);
		Helper helper2 = subtreeHelper(root.right);

		if (helper1.max < root.val && root.val < helper2.min && helper1.isValid && helper2.isValid) {
			maxCount = Math.max(maxCount, helper1.count + helper2.count + 1);
			return new Helper(helper1.min, helper2.max, helper1.count + helper2.count + 1, true);
		} else {
			return new Helper(0, 0, 0, false);
		}
	}

}
