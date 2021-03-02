package FacebookPrep;

import java.util.Arrays;
import java.util.Comparator;

public class _1235MaximumProfitInJobScheduling {
	public static void main(String[] args) {
		System.out.println(
				jobScheduling(new int[] { 1, 2, 3, 3 }, new int[] { 3, 4, 5, 6 }, new int[] { 50, 10, 40, 70 }));
		System.out.println(jobScheduling(new int[] { 1, 2, 3, 4, 6 }, new int[] { 3, 5, 10, 6, 9 },
				new int[] { 20, 20, 100, 70, 60 }));
		System.out.println(jobScheduling(new int[] { 1, 1, 1 }, new int[] { 2, 3, 4 }, new int[] { 5, 6, 4 }));
	}

	static class Interval {
		int startTime, endTime, profit;

		public Interval(int startTime, int endTime, int profit) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.profit = profit;
		}
	}

	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		if (startTime == null || startTime.length == 0)
			return 0;
		Interval[] intervals = new Interval[startTime.length];
		for (int i = 0; i < profit.length; i++) {
			intervals[i] = new Interval(startTime[i], endTime[i], profit[i]);
		}

		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.endTime - o2.endTime;
			}
		});

		int[] dp = new int[intervals.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = intervals[i].profit;
		}

		int maxProfit = intervals[0].profit;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (!overlaps(intervals[j], intervals[i])) {
					dp[i] = Math.max(dp[i], dp[j]+intervals[i].profit);
				}
			}
			maxProfit = Math.max(maxProfit, dp[i]);
		}
		return maxProfit;
	}
	
	public static boolean overlaps(Interval job1, Interval job2) {
		int j1start = job1.startTime;
		int j1end = job1.endTime;
		int j2start = job2.startTime;
		int j2end = job2.endTime;

		if (j2start >= j1start && j2start < j1end)
			return true;

		if (j1start >= j2start && j1start < j2end)
			return true;

		return false;
	}
}
