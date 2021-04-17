package April2021PrepLeetcode;

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

	}

}
