package May2021PrepLeetcode;

import java.util.HashSet;

public class _0983MinimumCostForTickets {
	public static void main(String[] args) {
		System.out.println(mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 }));
		System.out.println(mincostTickets(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, new int[] { 2, 7, 15 }));
	}

	public static int mincostTickets(int[] days, int[] costs) {
		int[] dp = new int[366];
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < days.length; i++) {
			set.add(days[i]);
		}

		for (int i = 1; i < dp.length; i++) {
			if (set.contains(i)) {

				int val1 = i - 1 >= 0 ? dp[i - 1] + costs[0] : costs[0];
				int val2 = i - 7 >= 0 ? dp[i - 7] + costs[1] : costs[1];
				int val3 = i - 30 >= 0 ? dp[i - 30] + costs[2] : costs[2];

				dp[i] = Math.min(val1, Math.min(val2, val3));
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[dp.length - 1];
	}
}
