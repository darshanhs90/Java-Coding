package Jan2021Leetcode;

import java.util.HashMap;

public class _1027LongestArithmeticSubsequence {
	public static void main(String[] args) {
		System.out.println(longestArithSeqLength(new int[] { 3, 6, 9, 12 }));
		System.out.println(longestArithSeqLength(new int[] { 9, 4, 7, 2, 10 }));
		System.out.println(longestArithSeqLength(new int[] { 20, 1, 15, 3, 10, 5, 8 }));
		System.out.println(longestArithSeqLength(new int[] { 83, 20, 17, 43, 52, 78, 68, 45 }));
		System.out.println(longestArithSeqLength(new int[] { 1, 2, 6, 7 }));
	}

	public static int longestArithSeqLength(int[] A) {
		HashMap<Integer, Integer>[] dp = new HashMap[A.length];
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			dp[i] = new HashMap<Integer, Integer>();
			for (int j = 0; j < i; j++) {
				int diff = A[i] - A[j];
				dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
				max = Math.max(max, dp[i].get(diff));
			}
		}

		return max;
	}

}
