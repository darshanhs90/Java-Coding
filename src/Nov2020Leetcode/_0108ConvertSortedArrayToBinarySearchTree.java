package Nov2020Leetcode;

public class _0108ConvertSortedArrayToBinarySearchTree {
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
		printNodes(sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 }));
	}

	public static void printNodes(TreeNode tn) {
		if (tn == null)
			return;
		System.out.print(tn.val + "->");
		printNodes(tn.left);
		printNodes(tn.right);
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;

		return helper(0, nums.length - 1, nums);
	}

	public static TreeNode helper(int start, int end, int[] nums) {
		if (start < 0 || start > end || end > nums.length - 1)
			return null;
		int midIndex = (start + end) / 2;
		TreeNode root = new TreeNode(nums[midIndex]);
		root.left = helper(start, midIndex - 1, nums);
		root.right = helper(midIndex + 1, end, nums);
		return root;
	}
}
