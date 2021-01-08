package Dec2020Leetcode;

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
		if (M == null || M.length == 0)
			return M;
		int[][] out = new int[M.length][M[0].length];
		for (int i = 0; i < out.length; i++) {
			for (int j = 0; j < out[0].length; j++) {
				out[i][j] = average(i, j, M);
			}
		}
		return out;
	}

	public static int average(int x, int y, int[][] M) {
		int count = 1, sum = M[x][y];
		if (x - 1 >= 0 && y - 1 >= 0) {
			count++;
			sum += M[x - 1][y - 1];
		}

		if (x - 1 >= 0 && y >= 0) {
			count++;
			sum += M[x - 1][y];
		}

		if (x - 1 >= 0 && y + 1 <= M[0].length - 1) {
			count++;
			sum += M[x - 1][y + 1];
		}

		if (x >= 0 && y - 1 >= 0) {
			count++;
			sum += M[x][y - 1];
		}

		if (x >= 0 && y + 1 <= M[0].length - 1) {
			count++;
			sum += M[x][y + 1];
		}

		if (x + 1 <= M.length - 1 && y - 1 >= 0) {
			count++;
			sum += M[x + 1][y - 1];
		}

		if (x + 1 <= M.length - 1 && y >= 0) {
			count++;
			sum += M[x + 1][y];
		}

		if (x + 1 <= M.length - 1 && y + 1 <= M[0].length - 1) {
			count++;
			sum += M[x + 1][y + 1];
		}

		return (int) Math.floor(sum / count);
	}

}
