package Dec2020Leetcode;

public class _0410SplitArrayLargestSum {

	public static void main(String[] args) {
		System.out.println(splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
		System.out.println(splitArray(new int[] { 1, 2, 3, 4, 5 }, 2));
		System.out.println(splitArray(new int[] { 1, 4, 4 }, 3));
	}

	public static int splitArray(int[] nums, int m) {
		int sum[] = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
		int dp[][] = new int[nums.length][m + 1];
		return findDiff(0, sum, nums, m, dp);
	}

	public static int findDiff(int start, int[] sumArray, int[] nums, int m, int[][] dp) {
		if (start >= dp.length || m < 0)
			return Integer.MAX_VALUE;
		if (m == 1) {
			return sumArray[nums.length] - sumArray[start];
		}

		if (dp[start][m] != 0)
			return dp[start][m];

		int maxSum = Integer.MAX_VALUE;
		for (int i = start; i < nums.length; i++) {
			int currVal = sumArray[i + 1] - sumArray[start];
			maxSum = Math.min(maxSum, Math.max(currVal, findDiff(i + 1, sumArray, nums, m - 1, dp)));
		}
		dp[start][m] = maxSum;
		return maxSum;
	}

}
