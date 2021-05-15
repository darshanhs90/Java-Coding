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
		int leftMax[] = new int[nums.length];
		int rightMax[] = new int[nums.length];

		int minSoFar = nums[0];
		int maxProfit = 0;
		for (int i = 1; i < rightMax.length; i++) {
			if (nums[i] < minSoFar) {
				minSoFar = nums[i];
			}
			maxProfit = Math.max(maxProfit, nums[i] - minSoFar);
			leftMax[i] = maxProfit;
		}

		int maxSoFar = nums[nums.length - 1];
		maxProfit = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > maxSoFar) {
				maxSoFar = nums[i];
			}
			maxProfit = Math.max(maxProfit, maxSoFar - nums[i]);
			rightMax[i] = maxProfit;
		}

		maxProfit = 0;
		for (int i = 0; i < leftMax.length; i++) {
			int leftVal = leftMax[i];
			int rightVal = i + 1 < nums.length ? rightMax[i + 1] : 0;
			maxProfit = Math.max(maxProfit, leftVal + rightVal);
		}
		return maxProfit;
	}
}
