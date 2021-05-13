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

	static int maxLen;

	public static int largestBSTSubtree(TreeNode root) {
		maxLen = 0;
		largest(root);
		return maxLen;
	}

	public static Helper largest(TreeNode root) {
		if (root == null) {
			return new Helper(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
		} else if (root.left == null && root.right == null) {
			maxLen = Math.max(maxLen, 1);
			return new Helper(root.val, root.val, 1, true);
		}

		Helper h1 = largest(root.left);
		Helper h2 = largest(root.right);

		if (h1.isValid && h2.isValid && root.val > h1.max && root.val < h2.min) {
			maxLen = Math.max(maxLen, h1.count + h2.count + 1);
			return new Helper(h1.min, h2.max, h1.count + h2.count + 1, true);
		}
		return new Helper(0, 0, 0, false);
	}

}
