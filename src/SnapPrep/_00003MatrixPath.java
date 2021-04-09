package SnapPrep;

public class _00003MatrixPath {
	public static void main(String[] args) {
		System.out.println(findLongestLength(
				new int[][] { new int[] { 1, 4, 2 }, new int[] { 0, 8, 3 }, new int[] { 10, 9, 6 } }));
	}

	public static int findLongestLength(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		int maxLength = 0;
		int[][] cache = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				maxLength = Math.max(maxLength, getMaxIncreasingLength(i, j, matrix[i][j], matrix, cache));
			}
		}
		return maxLength;
	}

	/*
	 * new int[]{1,4,2}, new int[]{0,8,3}, new int[]{10,9,6}
	 * 
	 * 
	 * // cache - 0,0,0 // - 0,0,0 - 0,0,0
	 * 
	 * 
	 * 
	 */
	public static int getMaxIncreasingLength(int x, int y, int currVal, int[][] matrix, int[][] cache) {
		if (cache[x][y] != 0) {
			return cache[x][y];
		}

		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 },
				new int[] { 0, 1 }, };

		int maxLength = 0;

		for (int[] arr : dirs) {
			int newX = x + arr[0];
			int newY = y + arr[1];

			if (newX < 0 || newY < 0 || newX >= matrix.length || newY >= matrix[0].length)
				continue;

			if (matrix[newX][newY] > currVal) {
				maxLength = Math.max(maxLength,
						getMaxIncreasingLength(newX, newY, matrix[newX][newY], matrix, cache) + 1);
			}
		}

		cache[x][y] = maxLength;
		return maxLength;
	}

}
