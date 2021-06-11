package June2021GoogLeetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0354RussianDollEnvelopes {

	public static void main(String[] args) {
		System.out.println(maxEnvelopes(
				new int[][] { new int[] { 5, 4 }, new int[] { 6, 4 }, new int[] { 6, 7 }, new int[] { 2, 3 } }));
	}

	public static int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int start1 = o1[0];
				int end1 = o1[1];
				int start2 = o2[0];
				int end2 = o2[1];

				if (start1 == start2)
					return end2 - end1;
				return start1 - start2;
			}
		});

		return lis(envelopes);
	}

	public static int lis(int[][] envelopes) {
		int[] dp = new int[envelopes.length];
		Arrays.fill(dp, 1);
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[i][1] > envelopes[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
