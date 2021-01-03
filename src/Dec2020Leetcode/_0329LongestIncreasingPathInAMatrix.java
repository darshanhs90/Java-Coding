package Dec2020Leetcode;

public class _0329LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 9, 9, 4 }, new int[] { 6, 6, 8 }, new int[] { 2, 1, 1 } }));
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 3, 4, 5 }, new int[] { 3, 2, 6 }, new int[] { 2, 2, 1 } }));
	}

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int[][] cache = new int[matrix.length][matrix[0].length];
		int out = 1;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				out = Math.max(out, dfs(i, j, matrix, cache, visited));
			}
		}

		return out;
	}

	public static int dfs(int x, int y, int[][] matrix, int[][] cache, boolean[][] visited) {

		if (cache[x][y] != 0)
			return cache[x][y];
		visited[x][y] = true;

		int leftVal = 1;
		if (x - 1 >= 0 && !visited[x - 1][y] && matrix[x - 1][y] > matrix[x][y]) {
			leftVal = dfs(x - 1, y, matrix, cache, visited) + 1;
		}

		if (y - 1 >= 0 && !visited[x][y - 1] && matrix[x][y - 1] > matrix[x][y]) {
			leftVal = Math.max(leftVal, dfs(x, y - 1, matrix, cache, visited) + 1);
		}

		if (x + 1 < matrix.length && !visited[x + 1][y] && matrix[x + 1][y] > matrix[x][y]) {
			leftVal = Math.max(leftVal, dfs(x + 1, y, matrix, cache, visited) + 1);
		}

		if (y + 1 < matrix[0].length && !visited[x][y + 1] && matrix[x][y + 1] > matrix[x][y]) {
			leftVal = Math.max(leftVal, dfs(x, y + 1, matrix, cache, visited) + 1);
		}

		cache[x][y] = leftVal;
		visited[x][y] = false;
		return leftVal;
	}

}
