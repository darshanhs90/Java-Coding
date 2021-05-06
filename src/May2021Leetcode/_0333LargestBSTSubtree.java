package May2021Leetcode;

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
		int min, max, count;
		boolean isValid;

		public Helper(int min, int max, int count, boolean isValid) {
			this.min = min;
			this.max = max;
			this.count = count;
			this.isValid = isValid;
		}

	}

	static int max;

	public static int largestBSTSubtree(TreeNode root) {
		max = 0;
		helper(root);
		return max;
	}

	public static Helper helper(TreeNode root) {
		if (root == null) {
			return new Helper(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
		} else if (root.left == null && root.right == null) {
			max = Math.max(max, 1);
			return new Helper(root.val, root.val, 1, true);
		}

		Helper helper1 = helper(root.left);
		Helper helper2 = helper(root.right);

		if (root.val > helper1.max && root.val < helper2.min && helper1.isValid && helper2.isValid) {

			max = Math.max(max, helper1.count + helper2.count + 1);
			return new Helper(helper1.min, helper2.max, helper1.count + helper2.count + 1, true);
		}
		return new Helper(0, 0, 0, false);
	}

}
