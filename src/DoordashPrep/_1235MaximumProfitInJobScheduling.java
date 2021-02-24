package DoordashPrep;

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
		int start, end, profit;

		public Interval(int start, int end, int profit) {
			this.start = start;
			this.end = end;
			this.profit = profit;
		}
	}

	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		Interval[] intervals = new Interval[profit.length];
		for (int i = 0; i < intervals.length; i++) {
			intervals[i] = new Interval(startTime[i], endTime[i], profit[i]);
		}

		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.end - o2.end;
			}
		});

		int[] dp = new int[intervals.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = intervals[i].profit;
		}

		int max = dp[0];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (!jobsOverlap(intervals[i], intervals[j])) {
					dp[i] = Math.max(dp[i], dp[j] + intervals[i].profit);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static boolean jobsOverlap(Interval job1, Interval job2) {
		int j1start = job1.start;
		int j1end = job1.end;
		int j2start = job2.start;
		int j2end = job2.end;

		if (j2start >= j1start && j2start < j1end)
			return true;

		if (j1start >= j2start && j1start < j2end)
			return true;

		return false;
	}
}
