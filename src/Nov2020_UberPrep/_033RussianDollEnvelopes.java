package Nov2020_UberPrep;

import java.util.Arrays;
import java.util.Comparator;

public class _033RussianDollEnvelopes {
	
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
				// TODO Auto-generated method stub
				int val = o1[0] - o2[0];
				if (val == 0)
					return o2[1] - o1[1];
				return val;
			}
		});

		return lengthOfLIS(envelopes);
	}

	public static int lengthOfLIS(int[][] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		int max = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i][1] > nums[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}

}
