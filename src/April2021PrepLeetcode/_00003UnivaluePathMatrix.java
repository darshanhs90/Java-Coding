package April2021PrepLeetcode;

public class _00003UnivaluePathMatrix {
	public static void main(String[] args) {
		System.out.println(longestPath(
				new int[][] { 
					new int[] { 1, 1, 2, 1 }, 
					new int[] { 5, 5, 5, 5 }, 
					new int[] { 5, 5, 5, 1 } }));
		// 7

		System.out.println(longestPath(new int[][] { 
			new int[] { 1, 1 }, 
			new int[] { 5, 5 },
			new int[] { 5, 5 } }));
		// 4

		System.out.println(longestPath(
				new int[][] { 
					new int[] { 1, 2, 1, 1 }, 
					new int[] { 5, 5, 5, 5 },
					new int[] { 3, 5, 1, 1 } }));
		// 4

		System.out.println(
				longestPath(new int[][] { 
					{ 9, 9, 9, 9,  9, 9, 9 }, 
					{ 9, 9, 8, 9,  9, 9, 9 }, 
					{ 9, 9, 9, 12, 9, 9, 9 },
					{ 9, 9, 9, 12, 9, 9, 9 }, 
					{ 9, 9, 9, 12, 9, 9, 9 }, 
					{ 9, 9, 9, 12, 9, 9, 9 } }));
		// ?
	}

	public static int longestPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int maxLength = 0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				maxLength = Math.max(maxLength, dfs(i, j, matrix[i][j], matrix, visited));
			}
		}
		return maxLength;
	}

	public static int dfs(int x, int y, int currVal, int[][] matrix, boolean[][] visited) {
		if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || visited[x][y] || matrix[x][y] != currVal)
			return 0;
		visited[x][y] = true;
		int length = 1;
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];
			length = Math.max(length, 1 + dfs(newX, newY, currVal, matrix, visited));
		}

		visited[x][y] = false;
		return length;
	}
}
