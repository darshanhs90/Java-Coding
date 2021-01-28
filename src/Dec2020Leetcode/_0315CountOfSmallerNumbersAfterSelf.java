package Dec2020Leetcode;

import java.util.Arrays;
import java.util.List;

public class _0315CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		System.out.println(countSmaller(new int[] { 5, 2, 6, 1 }));
	}

	static class TreeNode {
		int val, sum, dup;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.sum = 0;
			this.dup = 1;
		}
	}

	public static List<Integer> countSmaller(int[] nums) {
		Integer[] ans = new Integer[nums.length];
		TreeNode root = null;
		for (int i = nums.length - 1; i >= 0; i--) {
			root = insert(nums[i], root, ans, i, 0);
		}
		return Arrays.asList(ans);
	}

	private static TreeNode insert(int num, TreeNode node, Integer[] ans, int i, int preSum) {
		if (node == null) {
			node = new TreeNode(num);
			ans[i] = preSum;
		} else if (node.val == num) {
			node.dup++;
			ans[i] = preSum + node.sum;
		} else if (node.val > num) {
			node.sum++;
			node.left = insert(num, node.left, ans, i, preSum);
		} else {
			node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
		}
		return node;
	}

}
