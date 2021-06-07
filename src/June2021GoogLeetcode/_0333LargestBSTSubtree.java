package June2021GoogLeetcode;

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
		boolean valid;
		int count;

		public Helper(int min, int max, boolean valid, int count) {
			this.min = min;
			this.max = max;
			this.count = count;
			this.valid = valid;
		}
	}

	static int maxVal;

	public static int largestBSTSubtree(TreeNode root) {
		maxVal = 0;
		if (root == null)
			return 0;
		helperfn(root);
		return maxVal;
	}

	public static Helper helperfn(TreeNode root) {
		if (root == null) {
			return new Helper(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
		}

		if (root.left == null && root.right == null) {
			maxVal = Math.max(maxVal, 1);
			return new Helper(root.val, root.val, true, 1);
		}

		Helper h1 = helperfn(root.left);
		Helper h2 = helperfn(root.right);

		if (h1.valid && h2.valid && root.val > h1.max && root.val < h2.min) {
			maxVal = Math.max(maxVal, h1.count + h2.count + 1);
			return new Helper(h1.min, h2.max, true, h1.count + h2.count + 1);
		}

		return new Helper(Integer.MIN_VALUE, Integer.MAX_VALUE, false, 0);
	}

}
