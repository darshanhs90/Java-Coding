package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.List;

public class _055InsertInterval {

	public static void main(String[] args) {
		System.out.println(insert(new int[][] { new int[] { 1, 3 }, new int[] { 6, 9 } }, new int[] { 2, 5 }));
		System.out.println(insert(new int[][] { new int[] { 1, 2 }, new int[] { 3, 5 }, new int[] { 6, 7 },
				new int[] { 8, 10 }, new int[] { 12, 16 } }, new int[] { 4, 8 }));
		System.out.println(insert(new int[][] {}, new int[] { 5, 7 }));
		System.out.println(insert(new int[][] { new int[] { 1, 5 } }, new int[] { 2, 3 }));
		System.out.println(insert(new int[][] { new int[] { 1, 5 } }, new int[] { 2, 7 }));
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {

		if (intervals.length == 0)
			return new int[][] { newInterval };

		List<int[]> list = new ArrayList<int[]>();
		int intervalIndex = 0;
		boolean newIntervalUsed = false;
		while (intervalIndex < intervals.length) {
			int[] currInterval = intervals[intervalIndex];
			if (list.size() == 0 || newIntervalUsed == false) {
				if (currInterval[1] < newInterval[0]) {
					list.add(currInterval);
					intervalIndex++;
				} else if (newInterval[1] < currInterval[0]) {
					list.add(newInterval);
					newIntervalUsed = true;
				} else {
					list.add(new int[] { Math.min(currInterval[0], newInterval[0]),
							Math.max(currInterval[1], newInterval[1]) });
					intervalIndex++;
					newIntervalUsed = true;
				}
			} else {
				int[] prevInterval = list.get(list.size() - 1);
				if (currInterval[0] <= prevInterval[1]) {
					list.remove(list.size() - 1);
					list.add(new int[] { Math.min(currInterval[0], prevInterval[0]),
							Math.max(currInterval[1], prevInterval[1]) });
					intervalIndex++;
				} else {
					list.add(currInterval);
					intervalIndex++;
				}
			}
		}
		if (!newIntervalUsed) {
			list.add(newInterval);
		}
		int[][] out = new int[list.size()][2];
		for (int i = 0; i < out.length; i++) {
			out[i] = (list.get(i));
		}
		return out;
	}
}
