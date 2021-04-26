package April2021PrepLeetcode;

import java.util.HashSet;

public class _0983MinimumCostForTickets {
	public static void main(String[] args) {
		System.out.println(mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 }));
	}

	public static int mincostTickets(int[] days, int[] costs) {
		int[] dp = new int[366];
		HashSet<Integer> daySet = new HashSet<Integer>();
		for (int i = 0; i < days.length; i++) {
			daySet.add(days[i]);
		}

		for (int i = 1; i < dp.length; i++) {
			if (daySet.contains(i)) {
				int dayVal = i - 1 >= 0 ? dp[i - 1] + costs[0] : Integer.MAX_VALUE;
				int sevenVal = i - 7 >= 0 ? dp[i - 7] + costs[1] : Integer.MAX_VALUE;
				int monthVal = i - 30 >= 0 ? dp[i - 30] + costs[2] : Integer.MAX_VALUE;
				dp[i] = Math.min(dayVal, Math.min(sevenVal, monthVal));
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[dp.length - 1];
	}
}
