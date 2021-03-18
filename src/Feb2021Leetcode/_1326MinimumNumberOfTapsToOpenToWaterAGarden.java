package Feb2021Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _1326MinimumNumberOfTapsToOpenToWaterAGarden {
	// https://www.youtube.com/watch?v=Gg64QXc9K0s
	public static void main(String[] args) {
		System.out.println(minTaps(5, new int[] { 3, 4, 1, 1, 0, 0 }));
		System.out.println(minTaps(3, new int[] { 0, 0, 0, 0 }));
		System.out.println(minTaps(7, new int[] { 1, 2, 1, 0, 2, 1, 0, 1 }));
		System.out.println(minTaps(8, new int[] { 4, 0, 0, 0, 0, 0, 0, 0, 4 }));
		System.out.println(minTaps(8, new int[] { 4, 0, 0, 0, 4, 0, 0, 0, 4 }));
	}

	public static int minTaps(int n, int[] ranges) {
		int[][] intervals = new int[ranges.length][2];

		for (int i = 0; i < ranges.length; i++) {
			int currRange = ranges[i];
			int min = Math.max(0, i - currRange);
			int max = Math.min(n, i + currRange);
			intervals[i] = new int[] { min, max };
		}

		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int val = o1[0] - o2[0];
				if (val == 0)
					return o2[1] - o1[1];
				return val;
			}
		});

		int currStart = intervals[0][0];
		int currEnd = intervals[0][1];
		int currCount = 1;

		while (currEnd < n) {
			int newStart = currStart;
			int newEnd = currEnd;

			for (int i = 0; i < intervals.length; i++) {
				int currIntervalStart = intervals[i][0];
				int currIntervalEnd = intervals[i][1];
				if (currIntervalStart >= currStart && currIntervalStart <= currEnd) {
					if (currIntervalEnd > newEnd) {
						newStart = currIntervalStart;
						newEnd = currIntervalEnd;
					}
				}
			}

			if (newEnd == currEnd)
				return -1;
			currEnd = newEnd;
			currStart = newStart;
			currCount++;
		}

		return currCount;
	}

}
