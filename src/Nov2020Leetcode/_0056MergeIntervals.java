package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
		if (intervals == null || intervals.length < 2)
			return intervals;
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		int startInterval = intervals[0][0];
		int endInterval = intervals[0][1];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 1; i < intervals.length; i++) {
			int currIntervalStart = intervals[i][0];
			int currIntervalEnd = intervals[i][1];

			if (endInterval >= currIntervalStart && endInterval < currIntervalEnd) {
				endInterval = currIntervalEnd;
			} else if (endInterval > currIntervalEnd) {
				// do nothing
			} else if (endInterval < currIntervalStart) {
				list.add(Arrays.asList(startInterval, endInterval));
				startInterval = currIntervalStart;
				endInterval = currIntervalEnd;
			}
		}
		list.add(Arrays.asList(startInterval, endInterval));

		int[][] out = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			out[i][0] = list.get(i).get(0);
			out[i][1] = list.get(i).get(1);
			System.out.println(Arrays.toString(out[i]));
		}
		return out;
	}
}
