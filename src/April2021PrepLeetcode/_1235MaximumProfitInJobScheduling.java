package April2021PrepLeetcode;

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

	static class Job {
		int start, end, profit;

		public Job(int start, int end, int profit) {
			this.start = start;
			this.end = end;
			this.profit = profit;
		}
	}

	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		if (startTime == null || startTime.length == 0)
			return 0;
		Job[] jobs = new Job[startTime.length];
		for (int i = 0; i < jobs.length; i++) {
			jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		}

		Arrays.sort(jobs, new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				int val = o1.start - o2.start;
				if (val == 0)
					return o1.end - o2.end;
				return val;
			}
		});

		int[] dp = new int[jobs.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = jobs[i].profit;
		}
		int max = dp[0];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (!jobsOverLap(jobs[j], jobs[i])) {
					dp[i] = Math.max(dp[i], dp[j] + jobs[i].profit);
				}
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	public static boolean jobsOverLap(Job j1, Job j2) {
		int start1 = j1.start;
		int end1 = j1.end;
		int start2 = j2.start;
		int end2 = j2.end;

		if (start2 >= start1 && start2 < end1)
			return true;

		if (end2 >= start1 && end2 < end1)
			return true;

		return false;
	}

}
