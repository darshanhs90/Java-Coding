package Nov2020_UberPrep;

import java.util.Arrays;

public class _053LongestIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		System.out.println(lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));
		System.out.println(lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 }));

	}

	public static int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		int max = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}

}
