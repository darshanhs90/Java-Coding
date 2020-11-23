package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0057InsertInterval {
	public static void main(String[] args) {
		System.out.println(insert(new int[][] { new int[] { 1, 3 }, new int[] { 6, 9 }, }, new int[] { 2, 5 }));
		System.out.println(insert(new int[][] { new int[] { 1, 2 }, new int[] { 3, 5 }, new int[] { 6, 7 },
				new int[] { 8, 10 }, new int[] { 12, 16 } }, new int[] { 4, 8 }));
		System.out.println(insert(new int[][] {}, new int[] { 5, 7 }));

		System.out.println(insert(new int[][] { new int[] { 1, 5 } }, new int[] { 2, 3 }));

		System.out.println(insert(new int[][] { new int[] { 1, 5 } }, new int[] { 2, 7 }));
		System.out.println(insert(new int[][] { new int[] { 1, 5 } }, new int[] { 6, 8 }));
		System.out.println(insert(new int[][] { new int[] { 3, 5 } }, new int[] { 0, 2 }));
		System.out.println(insert(new int[][] { new int[] { 3, 4 }, new int[] { 6, 9 }, }, new int[] { 1, 2 }));

	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals == null || intervals.length == 0) {
			return new int[][] { newInterval };
		}

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < intervals.length; i++) {
			list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
		}

		list.add(Arrays.asList(newInterval[0], newInterval[1]));
		return merge(list);
	}

	public static int[][] merge(List<List<Integer>> intervals) {
		Collections.sort(intervals, (list1, list2) -> list1.get(0).compareTo(list2.get(0)));
		int startInterval = intervals.get(0).get(0);
		int endInterval = intervals.get(0).get(1);
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for (int i = 1; i < intervals.size(); i++) {
			int currIntervalStart = intervals.get(i).get(0);
			int currIntervalEnd = intervals.get(i).get(1);

			if (endInterval >= currIntervalStart && endInterval < currIntervalEnd) {
				endInterval = currIntervalEnd;
			} else if (endInterval > currIntervalEnd) {
				// do nothing
			} else if (endInterval < currIntervalStart) {
				output.add(Arrays.asList(startInterval, endInterval));
				startInterval = currIntervalStart;
				endInterval = currIntervalEnd;
			}
		}
		output.add(Arrays.asList(startInterval, endInterval));

		System.out.println(output);
		int[][] out = new int[output.size()][2];
		for (int i = 0; i < output.size(); i++) {
			out[i][0] = output.get(i).get(0);
			out[i][1] = output.get(i).get(1);
		}
		return out;
	}
}
