package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0986IntervalListIntersections {
	public static void main(String[] args) {
		System.out.println(intervalIntersection(
				new int[][] { new int[] { 0, 2 }, new int[] { 5, 10 }, new int[] { 13, 23 }, new int[] { 24, 25 } },
				new int[][] { new int[] { 1, 5 }, new int[] { 8, 12 }, new int[] { 15, 24 }, new int[] { 25, 26 } }));

		System.out
				.println(intervalIntersection(new int[][] { new int[] { 1, 3 }, new int[] { 5, 9 } }, new int[][] {}));

		System.out.println(
				intervalIntersection(new int[][] {}, new int[][] { new int[] { 4, 8 }, new int[] { 10, 12 } }));

		System.out
				.println(intervalIntersection(new int[][] { new int[] { 1, 7 } }, new int[][] { new int[] { 3, 10 } }));

		System.out.println(intervalIntersection(new int[][] { new int[] { 3, 5 }, new int[] { 9, 20 } },
				new int[][] { new int[] { 4, 5 }, new int[] { 7, 10 }, new int[] { 11, 12 }, new int[] { 14, 15 },
						new int[] { 16, 20 } }));

	}

	public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		int firstIndex = 0, secondIndex = 0;
		List<int[]> output = new ArrayList<int[]>();
		while (firstIndex < firstList.length && secondIndex < secondList.length) {
			int start1 = firstList[firstIndex][0];
			int end1 = firstList[firstIndex][1];
			int start2 = secondList[secondIndex][0];
			int end2 = secondList[secondIndex][1];

			int low = Math.max(start1, start2);
			int high = Math.min(end1, end2);

			if (low <= high) {
				output.add(new int[] { low, high });
			}

			if (end1 < end2) {
				firstIndex++;
			} else {
				secondIndex++;
			}
		}
		int[][] out = new int[output.size()][2];
		for (int i = 0; i < out.length; i++) {
			out[i] = output.get(i);
		}
		return out;
	}
}
