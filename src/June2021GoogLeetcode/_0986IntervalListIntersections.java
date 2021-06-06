package June2021GoogLeetcode;

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
		List<int[]> out = new ArrayList<int[]>();
		int index1 = 0, index2 = 0;
		while (index1 < firstList.length && index2 < secondList.length) {
			int start1 = firstList[index1][0];
			int end1 = firstList[index1][1];
			int start2 = secondList[index2][0];
			int end2 = secondList[index2][1];

			int low = Math.max(start1, start2);
			int high = Math.min(end1, end2);

			if (low <= high) {
				out.add(new int[] { low, high });
			}

			if (end1 < end2) {
				index1++;
			} else {
				index2++;
			}
		}

		int[][] output = new int[out.size()][2];
		for (int i = 0; i < output.length; i++) {
			output[i] = out.get(i);
		}
		return output;
	}
}
