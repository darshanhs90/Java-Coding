package Nov2020Leetcode;

import java.util.Arrays;

public class _1337TheKWeakestRowsInAMatrix {
	public static void main(String[] args) {
		System.out
				.println(Arrays.toString(kWeakestRows(
						new int[][] { new int[] { 1, 1, 0, 0, 0 }, new int[] { 1, 1, 1, 1, 0 },
								new int[] { 1, 0, 0, 0, 0 }, new int[] { 1, 1, 0, 0, 0 }, new int[] { 1, 1, 1, 1, 1 } },
						3)));

		System.out.println(Arrays.toString(kWeakestRows(new int[][] { new int[] { 1, 0, 0, 0 },
				new int[] { 1, 1, 1, 1 }, new int[] { 1, 0, 0, 0 }, new int[] { 1, 0, 0, 0 } }, 2)));

	}

	public static int[] kWeakestRows(int[][] mat, int k) {
		int[] out = new int[k];
		int[] sumArr = new int[mat.length];
		for (int i = 0; i < mat.length; i++) {
			int sum = 0;
			for (int j = 0; j < mat[0].length; j++) {
				sum += mat[i][j];
			}
			sumArr[i] = sum;
		}
		int[] clone = sumArr.clone();
		Arrays.sort(sumArr);
		for (int i = 0; i < out.length; i++) {
			out[i] = findIndex(clone, sumArr[i]);
		}
		return out;
	}

	public static int findIndex(int[] mat, int k) {
		for (int i = 0; i < mat.length; i++) {
			if (mat[i] == k) {
				mat[i] = -1;
				return i;
			}
		}
		return 0;
	}
}
