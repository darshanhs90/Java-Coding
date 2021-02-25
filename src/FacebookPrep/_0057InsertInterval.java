package FacebookPrep;

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
		List<int[]> output = new ArrayList<int[]>(Arrays.asList(intervals));
		output.add(newInterval);

		Collections.sort(output, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		List<int[]> newOut = new ArrayList<int[]>();
		int prevStart = output.get(0)[0];
		int prevEnd = output.get(0)[1];

		for (int i = 1; i < output.size(); i++) {
			int[] curr = output.get(i);
			int currStart = curr[0];
			int currEnd = curr[1];
			if (currStart >= prevStart && currStart <= prevEnd) {
				prevEnd = Math.max(prevEnd, currEnd);
			} else {
				newOut.add(new int[] { prevStart, prevEnd });
				prevStart = currStart;
				prevEnd = currEnd;
			}
		}

		newOut.add(new int[] { prevStart, prevEnd });

		int[][] outArr = new int[newOut.size()][2];
		for (int i = 0; i < outArr.length; i++) {
			outArr[i] = newOut.get(i);
		}
		return outArr;
	}

}
