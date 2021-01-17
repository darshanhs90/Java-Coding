package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
		int first = 0, second = 0;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		while (first < firstList.length && second < secondList.length) {
			int low = Math.max(firstList[first][0], secondList[second][0]);
			int high = Math.min(firstList[first][1], secondList[second][1]);

			if (low <= high) {
				list.add(new ArrayList<Integer>(Arrays.asList(low, high)));
			}

			if (firstList[first][1] < secondList[second][1])
				first++;
			else
				second++;
		}
		System.out.println(list);
		int[][] output = new int[list.size()][2];
		for (int i = 0; i < output.length; i++) {
			output[i][0] = list.get(i).get(0);
			output[i][1] = list.get(i).get(1);

		}
		return output;
	}
}
