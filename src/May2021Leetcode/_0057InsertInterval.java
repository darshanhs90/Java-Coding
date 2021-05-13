package May2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
		List<int[]> allIntervals = new ArrayList<int[]>(Arrays.asList(intervals));
		allIntervals.add(newInterval);

		Collections.sort(allIntervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		List<int[]> mergedIntervals = new ArrayList<int[]>();
		int prevStart = allIntervals.get(0)[0];
		int prevEnd = allIntervals.get(0)[1];

		for (int i = 1; i < allIntervals.size(); i++) {
			int currStart = allIntervals.get(i)[0];
			int currEnd = allIntervals.get(i)[1];

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
