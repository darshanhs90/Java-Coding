package May2021Leetcode;

public class _0123BestTimeToBuyAndSellStockIII {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
		System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
		System.out.println(maxProfit(new int[] { 1 }));

		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));

	}

	public static int maxProfit(int[] nums) {

		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		int minSoFar = nums[0];
		int maxProfitSoFar = 0;
		for (int i = 1; i < left.length; i++) {
			if (nums[i] < minSoFar) {
				minSoFar = nums[i];
			}
			maxProfitSoFar = Math.max(maxProfitSoFar, nums[i] - minSoFar);
			left[i] = maxProfitSoFar;
		}

		int maxSoFar = nums[nums.length - 1];
		maxProfitSoFar = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > maxSoFar) {
				maxSoFar = nums[i];
			}
			maxProfitSoFar = Math.max(maxProfitSoFar, maxSoFar - nums[i]);
			right[i] = maxProfitSoFar;
		}
		maxProfitSoFar = 0;
		for (int i = 0; i < right.length; i++) {

			int leftVal = left[i];
			int rightVal = i + 1 < nums.length ? right[i + 1] : 0;

			maxProfitSoFar = Math.max(maxProfitSoFar, leftVal + rightVal);
		}
		return maxProfitSoFar;
	}
}
