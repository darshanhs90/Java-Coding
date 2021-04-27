package April2021PrepLeetcode;

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
		int nodesCount;
		boolean isValid;
		int min, max;

		public Helper(int nodesCount, boolean isValid, int min, int max) {
			this.nodesCount = nodesCount;
			this.isValid = isValid;
			this.min = min;
			this.max = max;
		}
	}

	static int out;

	public static int largestBSTSubtree(TreeNode root) {
		out = 0;
		if (root == null)
			return 0;
		largestHelper(root);
		return out;
	}

	public static Helper largestHelper(TreeNode root) {
		if (root == null) {
			return new Helper(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
		} else if (root.left == null && root.right == null) {
			out = Math.max(1, out);
			return new Helper(1, true, root.val, root.val);
		}

		Helper h1 = largestHelper(root.left);
		Helper h2 = largestHelper(root.right);

		if (h1.isValid && h2.isValid) {
			if (h1.max < root.val && h2.min > root.val) {
				out = Math.max(h1.nodesCount + h2.nodesCount + 1, out);
				return new Helper(h1.nodesCount + h2.nodesCount + 1, true, h1.min, h2.max);
			}
		}
		return new Helper(0, false, 0, 0);
	}

}
