package April2021PrepLeetcode;

import java.util.Arrays;

public class _0062UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 7));
		System.out.println(uniquePaths(3, 2));
		System.out.println(uniquePaths(7, 3));
		System.out.println(uniquePaths(3, 3));
	}

	public static int uniquePaths(int m, int n) {
		int[][] out = new int[m][n];
		for (int i = 0; i < out.length; i++) {
			out[i][0] = 1;
		}
		Arrays.fill(out[0], 1);
		for (int i = 1; i < out.length; i++) {
			for (int j = 1; j < out[0].length; j++) {
				out[i][j] = out[i - 1][j] + out[i][j - 1];
			}
		}
		return out[m - 1][n - 1];
	}
}
