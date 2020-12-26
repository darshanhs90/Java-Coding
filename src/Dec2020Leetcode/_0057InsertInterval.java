package Dec2020Leetcode;

import java.util.ArrayList;
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

		List<int[]> output = new ArrayList<int[]>();
		int i = 0;
		for (i = 0; i < intervals.length; i++) {
			if (intervals[i][0] < newInterval[0])
				output.add(intervals[i]);
			else {
				break;
			}
		}

		// check for overlap and then add
		if (output.size() == 0) {
			output.add(newInterval);
		} else {
			int[] prevInterval = output.get(output.size() - 1);
			int prevStart = prevInterval[0];
			int prevEnd = prevInterval[1];

			int currStart = newInterval[0];
			int currEnd = newInterval[1];

			if (currStart > prevEnd) {
				output.add(newInterval);
			} else if (currStart >= prevStart && currStart <= prevEnd) {
				int[] newIntervals = new int[] { Math.min(prevStart, currStart), Math.max(prevEnd, currEnd) };
				output.remove(output.size() - 1);
				output.add(newIntervals);
			}
		}

		for (int j = i; j < intervals.length; j++) {
			int[] prevInterval = output.get(output.size() - 1);
			int prevStart = prevInterval[0];
			int prevEnd = prevInterval[1];

			int[] currInterval = intervals[j];
			int currStart = currInterval[0];
			int currEnd = currInterval[1];

			if (currStart >= prevStart && currEnd <= prevEnd) {
				continue;
			} else if (currStart <= prevEnd) {
				int[] newIntervals = new int[] { Math.min(prevStart, currStart), Math.max(prevEnd, currEnd) };
				output.remove(output.size() - 1);
				output.add(newIntervals);
			} else if (currStart > prevEnd) {
				output.add(currInterval);
			}
		}

		int[][] outputArr = new int[output.size()][2];
		for (int j = 0; j < outputArr.length; j++) {
			outputArr[j] = output.get(j);
		}
		return outputArr;
	}

}
