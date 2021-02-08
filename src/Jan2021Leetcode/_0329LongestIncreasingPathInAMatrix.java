package Jan2021Leetcode;

public class _0329LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 9, 9, 4 }, new int[] { 6, 6, 8 }, new int[] { 2, 1, 1 } }));
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 3, 4, 5 }, new int[] { 3, 2, 6 }, new int[] { 2, 2, 1 } }));
	}

	static int maxLength = 0;

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		maxLength = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				dfs(i, j, matrix, 1);
			}
		}
		return maxLength;
	}

	public static void dfs(int x, int y, int[][] matrix, int count) {
		maxLength = Math.max(count, maxLength);
		int currVal = matrix[x][y];

		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		for (int i = 0; i < dirs.length; i++) {
			int newX = dirs[i][0] + x;
			int newY = dirs[i][1] + y;
			if (newX >= 0 && newY >= 0 && newX < matrix.length && newY < matrix[0].length
					&& matrix[newX][newY] > currVal) {
				dfs(newX, newY, matrix, count + 1);
			}
		}
	}

}
