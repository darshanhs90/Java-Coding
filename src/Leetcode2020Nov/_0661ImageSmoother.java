package Leetcode2020Nov;

import java.util.Arrays;

public class _0661ImageSmoother {

	public static void main(String[] args) {
		int[][] image = new int[][] { new int[] { 1, 1, 1 }, new int[] { 1, 0, 1 }, new int[] { 1, 1, 1 } };
		image = imageSmoother(image);
		for (int i = 0; i < image.length; i++) {
			System.out.println(Arrays.toString(image[i]));
		}
	}

	public static int[][] imageSmoother(int[][] M) {
		int[][] output = new int[M.length][M[0].length];
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				output[i][j] = findAverage(i, j, M);
			}
		}
		return output;
	}

	public static int findAverage(int x, int y, int[][] M) {
		int sum = M[x][y];
		int count = 1;
		int rows = M.length - 1;
		int cols = M[0].length - 1;

		if (x - 1 >= 0) {
			sum += M[x - 1][y];
			count++;
		}

		if (x + 1 <= rows) {
			sum += M[x + 1][y];
			count++;
		}

		if (y - 1 >= 0) {
			sum += M[x][y - 1];
			count++;
		}

		if (y + 1 <= cols) {
			sum += M[x][y + 1];
			count++;
		}

		if (x - 1 >= 0 && y - 1 >= 0) {
			sum += M[x - 1][y - 1];
			count++;
		}

		if (x - 1 >= 0 && y + 1 <= cols) {
			sum += M[x - 1][y + 1];
			count++;
		}

		if (x + 1 <= rows && y - 1 >= 0) {
			sum += M[x + 1][y - 1];
			count++;
		}

		if (x + 1 <= rows && y + 1 <= cols) {
			sum += M[x + 1][y + 1];
			count++;
		}

		return (int) Math.floor(sum / count);
	}
}
