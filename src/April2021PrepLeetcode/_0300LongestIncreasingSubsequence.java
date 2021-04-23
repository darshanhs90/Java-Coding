package April2021PrepLeetcode;

import java.util.Arrays;

public class _0300LongestIncreasingSubsequence {
	// https://www.youtube.com/watch?v=CE2b_-XfVDk
	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		System.out.println(lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));
		System.out.println(lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 }));
	}

	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int maxLength = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}
		return maxLength;
	}

}
