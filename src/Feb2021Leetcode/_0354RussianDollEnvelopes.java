package Feb2021Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0354RussianDollEnvelopes {

	public static void main(String[] args) {
		System.out.println(maxEnvelopes(
				new int[][] { new int[] { 5, 4 }, new int[] { 6, 4 }, new int[] { 6, 7 }, new int[] { 2, 3 } }));
	}

	public static int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0)
			return 0;

		Arrays.sort(envelopes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[0] == o2[0])
					return o2[1] - o1[1];
				return o1[0] - o2[0];
			}
		});

		return lis(envelopes);
	}

	public static int lis(int[][] envelopes) {
		int[] dp = new int[envelopes.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[i][1] > envelopes[j][1]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
