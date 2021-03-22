package Feb2021Leetcode;

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
		printNodes(tn.left);
		System.out.println(tn.val);
		printNodes(tn.right);
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return arrToBst(0, nums.length - 1, nums);
	}

	public static TreeNode arrToBst(int left, int right, int[] nums) {
		if (left > right)
			return null;

		int mid = (left + right) / 2;
		TreeNode tn = new TreeNode(nums[mid]);
		tn.left = arrToBst(left, mid - 1, nums);
		tn.right = arrToBst(mid + 1, right, nums);
		return tn;
	}

}
