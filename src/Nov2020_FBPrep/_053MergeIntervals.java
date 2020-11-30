package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _053MergeIntervals {

	public static void main(String[] args) {
		merge(new int[][] { new int[] { 1, 3 }, new int[] { 2, 6 }, new int[] { 8, 10 }, new int[] { 15, 18 } });

		merge(new int[][] { new int[] { 1, 4 }, new int[] { 4, 5 } });
	}

	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length <= 1)
			return intervals;
		Integer prevStart = null, prevEnd = null;
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (int[] interval : intervals) {
			if (prevStart == null && prevEnd == null) {
				prevStart = interval[0];
				prevEnd = interval[1];
			} else {
				int currStart = interval[0];
				int currEnd = interval[1];

				if (currStart >= prevStart && currStart <= prevEnd) {
					prevEnd = Math.max(prevEnd, currEnd);
				} else {
					list.add(new ArrayList<Integer>(Arrays.asList(prevStart, prevEnd)));
					prevStart = currStart;
					prevEnd = currEnd;
				}

			}
		}
		list.add(new ArrayList<Integer>(Arrays.asList(prevStart, prevEnd)));

		int[][] output = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			output[i][0] = list.get(i).get(0);
			output[i][1] = list.get(i).get(1);
		}
		System.out.println(list);
		return output;
	}
}
