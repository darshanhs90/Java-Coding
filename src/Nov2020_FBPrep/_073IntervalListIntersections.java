package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _073IntervalListIntersections {

	public static void main(String[] args) {
		int[][] out = intervalIntersection(
				new int[][] { new int[] { 0, 2 }, new int[] { 5, 10 }, new int[] { 13, 23 }, new int[] { 24, 25 } },
				new int[][] { new int[] { 1, 5 }, new int[] { 8, 12 }, new int[] { 15, 24 }, new int[] { 25, 26 } });

		for (int i = 0; i < out.length; i++) {
			System.out.println(Arrays.toString(out[i]));
		}

	}

	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> list = new ArrayList<int[]>();
		int i = 0, j = 0;
		while (i < A.length && j < B.length) {
			int min = Math.max(A[i][0], B[j][0]);
			int max = Math.min(A[i][1], B[j][1]);

			if (min <= max) {
				list.add(new int[] { min, max });
			}
			if (A[i][1] < B[j][1]) {
				i++;
			} else {
				j++;
			}
		}

		return list.toArray(new int[list.size()][]);
	}
}
