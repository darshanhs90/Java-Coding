package Jan2021Leetcode;

public class _0361BombEnemy {

	public static void main(String[] args) {
		System.out.println(maxKilledEnemies(new char[][] { new char[] { '0', 'E', '0', '0' },
				new char[] { 'E', '0', 'W', 'E' }, new char[] { '0', 'E', '0', '0' } }));
	}

	public static int maxKilledEnemies(char[][] grid) {
		int maxEnemies = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0')
					maxEnemies = Math.max(maxEnemies, dfs(i, j, grid));
			}
		}
		return maxEnemies;
	}

	public static int dfs(int currRow, int currCol, char[][] grid) {
		int count = 0;
		for (int i = currCol + 1; i < grid[0].length; i++) {
			if (grid[currRow][i] == 'W')
				break;
			else if (grid[currRow][i] == 'E') {
				count++;
			}
		}

		for (int i = currCol - 1; i >= 0; i--) {
			if (grid[currRow][i] == 'W')
				break;
			else if (grid[currRow][i] == 'E') {
				count++;
			}
		}

		for (int i = currRow + 1; i < grid.length; i++) {
			if (grid[i][currCol] == 'W')
				break;
			else if (grid[i][currCol] == 'E') {
				count++;
			}
		}

		for (int i = currRow - 1; i >= 0; i--) {
			if (grid[i][currCol] == 'W')
				break;
			else if (grid[i][currCol] == 'E') {
				count++;
			}
		}
		return count;
	}

}
