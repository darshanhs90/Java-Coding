package Nov2020_GoogPrep;

public class _038LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 3, 4, 5 }, new int[] { 3, 2, 6 }, new int[] { 2, 2, 1 } }));
	}

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int maxVal = 0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				maxVal = Math.max(maxVal, dfs(i, j, matrix, visited));
			}
		}
		return maxVal;
	}

	public static int dfs(int x, int y, int[][] matrix, boolean[][] visited) {
		if (x < 0 || y < 0 || x > matrix.length - 1 || y > matrix[0].length - 1 || visited[x][y] == true)
			return 0;
		visited[x][y] = true;
		int leftCount = 1, rightCount = 1, topCount = 1, bottomCount = 1;
		if (x - 1 >= 0 && matrix[x - 1][y] > matrix[x][y])
			leftCount = 1 + dfs(x - 1, y, matrix, visited);

		if (x + 1 < matrix.length && matrix[x + 1][y] > matrix[x][y])
			rightCount = 1 + dfs(x + 1, y, matrix, visited);

		if (y - 1 >= 0 && matrix[x][y - 1] > matrix[x][y])
			topCount = 1 + dfs(x, y - 1, matrix, visited);

		if (y + 1 < matrix[0].length && matrix[x][y + 1] > matrix[x][y])
			bottomCount = 1 + dfs(x, y + 1, matrix, visited);
		visited[x][y] = false;
		return Math.max(leftCount, Math.max(rightCount, Math.max(topCount, bottomCount)));
	}

}
