package Feb2021Leetcode;

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
		int startTime, endTime, profit;

		public Job(int startTime, int endTime, int profit) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.profit = profit;
		}
	}

	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		Job[] jobs = new Job[startTime.length];
		for (int i = 0; i < jobs.length; i++) {
			jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		}

		Arrays.sort(jobs, new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				// TODO Auto-generated method stub
				return o1.startTime - o2.startTime;
			}
		});

		int[] dp = new int[jobs.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = jobs[i].profit;
		}

		int max = dp[0];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (!overlaps(jobs[j], jobs[i])) {
					dp[i] = Math.max(dp[i], dp[j] + jobs[i].profit);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static boolean overlaps(Job job1, Job job2) {
		if (job2.startTime >= job1.startTime && job2.startTime < job1.endTime)
			return true;

		if (job2.endTime >= job1.startTime && job2.endTime < job1.endTime)
			return true;
		return false;
	}

}
