package June2021GoogLeetcode;

public class _0562LongestLineOfConsecutiveOneInMatrix {
	public static void main(String[] args) {
		System.out.println(longestLine(
				new int[][] { new int[] { 0, 1, 1, 0 }, new int[] { 0, 1, 1, 0 }, new int[] { 0, 0, 0, 1 } }));

		System.out.println(longestLine(
				new int[][] { new int[] { 1, 1, 1, 1 }, new int[] { 0, 1, 1, 0 }, new int[] { 0, 0, 0, 1 } }));
	}

	public static int longestLine(int[][] mat) {
		if (mat == null || mat.length == 0)
			return 0;

		int max = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					max = Math.max(max, dfs(i, j, mat));
				}
			}
		}
		return max;
	}

	public static int dfs(int x, int y, int[][] mat) {
		int max = 1;
		max = Math.max(max, dfsTopDown(x, y, mat));
		max = Math.max(max, dfsLeftRight(x, y, mat));
		max = Math.max(max, dfsFwDiag(x, y, mat));
		max = Math.max(max, dfsBwDiag(x, y, mat));
		return max;
	}

	public static int dfsBwDiag(int x, int y, int[][] mat) {
		int max = 1;
		int currX = x - 1;
		int currY = y + 1;
		while (currX < mat.length && currY < mat[0].length && currX >= 0 && currY >= 0 && mat[currX][currY] == 1) {
			max += mat[currX][currY];
			currY++;
			currX--;
		}

		currX = x + 1;
		currY = y - 1;
		while (currX >= 0 && currX < mat.length && currY >= 0 && currY < mat[0].length && mat[currX][currY] == 1) {
			max += mat[currX][currY];
			currY--;
			currX++;
		}

		return max;
	}

	public static int dfsFwDiag(int x, int y, int[][] mat) {
		int max = 1;
		int currX = x - 1;
		int currY = y - 1;
		while (currX >= 0 && currY >= 0 && mat[currX][currY] == 1) {
			max += mat[currX][currY];
			currY--;
			currX--;
		}

		currX = x + 1;
		currY = y + 1;
		while (currX < mat.length && currY < mat[0].length && mat[currX][currY] == 1) {
			max += mat[currX][currY];
			currY++;
			currX++;
		}

		return max;
	}

	public static int dfsLeftRight(int x, int y, int[][] mat) {
		int max = 1;
		int currY = y - 1;
		while (currY >= 0 && mat[x][currY] == 1) {
			max += mat[x][currY];
			currY--;
		}

		currY = y + 1;
		while (currY < mat[0].length && mat[x][currY] == 1) {
			max += mat[x][currY];
			currY++;
		}

		return max;
	}

	public static int dfsTopDown(int x, int y, int[][] mat) {
		int max = 1;
		int currX = x - 1;
		while (currX >= 0 && mat[currX][y] == 1) {
			max += mat[currX][y];
			currX--;
		}

		currX = x + 1;
		while (currX < mat.length && mat[currX][y] == 1) {
			max += mat[currX][y];
			currX++;
		}

		return max;
	}
}
