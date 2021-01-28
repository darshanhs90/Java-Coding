package Dec2020Leetcode;

public class _0312BurstBalloons {
	// https://www.youtube.com/watch?v=IFNibRVgFBo&ab_channel=TusharRoy-CodingMadeSimple
	public static void main(String[] args) {
		System.out.println(maxCoins(new int[] { 3, 1, 5, 8 }));
		System.out.println(maxCoins(new int[] { 1, 5 }));
	}

	public static int maxCoins(int[] nums) {

		int[][] dp = new int[nums.length][nums.length];

		for (int length = 1; length <= nums.length; length++) {
			for (int left = 0; left <= nums.length - length; left++) {
				int right = left + length - 1;
				for (int i = left; i <= right; i++) {
					int leftVal = 1, rightVal = 1;
					if (left != 0) {
						leftVal = nums[left - 1];
					}

					if (right != nums.length - 1) {
						rightVal = nums[right + 1];
					}

					int beforeVal = 0, afterVal = 0;
					if (left != i) {
						beforeVal = dp[left][i - 1];
					}

					if (right != i) {
						afterVal = dp[i + 1][right];
					}

					dp[left][right] = Math.max(dp[left][right], leftVal * rightVal * nums[i] + beforeVal + afterVal);
				}
			}

		}

		return dp[0][nums.length - 1];
	}
}
