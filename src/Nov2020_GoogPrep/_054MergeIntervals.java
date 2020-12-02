package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _054MergeIntervals {

	public static void main(String[] args) {
		merge(new int[][] { new int[] { 1, 3 }, new int[] { 2, 6 }, new int[] { 8, 10 }, new int[] { 15, 18 } });
		merge(new int[][] { new int[] { 1, 4 }, new int[] { 4, 5 } });
	}

	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length <= 1)
			return intervals;

		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		int prevStart = intervals[0][0];
		int prevEnd = intervals[0][1];
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for (int[] currInterval : intervals) {
			int currStart = currInterval[0];
			int currEnd = currInterval[1];

			if (prevEnd >= currStart) {
				prevEnd = Math.max(prevEnd, currEnd);
			} else {
				output.add(new ArrayList<Integer>(Arrays.asList(prevStart, prevEnd)));
				prevStart = currStart;
				prevEnd = currEnd;
			}
		}
		output.add(new ArrayList<Integer>(Arrays.asList(prevStart, prevEnd)));
		System.out.println(output);
		int[][] out = new int[output.size()][2];
		int index = 0;
		for (List<Integer> list : output) {
			out[index][0] = list.get(0);
			out[index][1] = list.get(1);
			index++;
		}
		return out;
	}
}
