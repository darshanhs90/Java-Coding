package May2021Leetcode;

import java.util.HashMap;

public class _1027LongestArithmeticSubsequence {
	public static void main(String[] args) {
		System.out.println(longestArithSeqLength(new int[] { 3, 6, 9, 12 }));
		System.out.println(longestArithSeqLength(new int[] { 9, 4, 7, 2, 10 }));
		System.out.println(longestArithSeqLength(new int[] { 20, 1, 15, 3, 10, 5, 8 }));
	}

	public static int longestArithSeqLength(int[] A) {
		HashMap[] dp = new HashMap[A.length];
		int maxLength = 1;
		dp[0] = new HashMap<Integer, Integer>();
		for (int i = 1; i < dp.length; i++) {
			dp[i] = new HashMap<Integer, Integer>();
			for (int j = 0; j < i; j++) {
				int diff = A[i] - A[j];

				dp[i].put(diff, (int) dp[j].getOrDefault(diff, 1) + 1);
				maxLength = Math.max(maxLength, (int) dp[i].get(diff));
			}
		}

		return maxLength;
	}

}
