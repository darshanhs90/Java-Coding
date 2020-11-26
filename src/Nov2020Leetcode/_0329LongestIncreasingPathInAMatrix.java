package Nov2020Leetcode;

public class _0329LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 9, 9, 4 }, new int[] { 6, 6, 8 }, new int[] { 2, 1, 1 } }));
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 3, 4, 5 }, new int[] { 3, 2, 6 }, new int[] { 2, 2, 1 } }));
	}

	public static int longestIncreasingPath(int[][] matrix) {
		int maxIncreasingLength = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				maxIncreasingLength = Math.max(maxIncreasingLength, dfs(i, j, null, matrix));
			}
		}

		return maxIncreasingLength;
	}

	public static int dfs(int x, int y, Integer prevVal, int[][] matrix) {
		if (x < 0 || y < 0 || x > matrix.length - 1 || y > matrix[0].length - 1
				|| (prevVal != null && matrix[x][y] <= prevVal))
			return 0;
		int leftCount = dfs(x, y - 1, matrix[x][y], matrix);
		int rightCount = dfs(x, y + 1, matrix[x][y], matrix);
		int topCount = dfs(x - 1, y, matrix[x][y], matrix);
		int bottomCount = dfs(x + 1, y, matrix[x][y], matrix);
		return 1 + Math.max(leftCount, Math.max(rightCount, Math.max(topCount, bottomCount)));
	}
}
