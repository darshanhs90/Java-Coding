package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _0056MergeIntervals {
	public static void main(String[] args) {
		System.out.println(merge(
				new int[][] { new int[] { 1, 3 }, new int[] { 2, 6 }, new int[] { 8, 10 }, new int[] { 15, 18 } }));
		System.out.println(merge(new int[][] { new int[] { 1, 4 }, new int[] { 4, 5 } }));

		System.out.println(merge(
				new int[][] { new int[] { 1, 3 }, new int[] { 2, 9 }, new int[] { 8, 15 }, new int[] { 15, 18 } }));

		System.out.println(merge(
				new int[][] { new int[] { 1, 20 }, new int[] { 2, 9 }, new int[] { 8, 15 }, new int[] { 15, 18 } }));

	}

	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return intervals;

		List<int[]> mergedIntervals = new ArrayList<int[]>();
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		int prevStart = intervals[0][0];
		int prevEnd = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {

			int currStart = intervals[i][0];
			int currEnd = intervals[i][1];
			if (currStart >= prevStart && currStart <= prevEnd) {
				prevEnd = Math.max(prevEnd, currEnd);
			} else {
				mergedIntervals.add(new int[] { prevStart, prevEnd });
				prevStart = currStart;
				prevEnd = currEnd;
			}
		}
		mergedIntervals.add(new int[] { prevStart, prevEnd });

		int[][] out = new int[mergedIntervals.size()][2];

		for (int i = 0; i < out.length; i++) {
			out[i] = mergedIntervals.get(i);
		}
		return out;
	}

}
