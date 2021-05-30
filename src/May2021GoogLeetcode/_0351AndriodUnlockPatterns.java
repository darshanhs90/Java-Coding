package May2021GoogLeetcode;

public class _0351AndriodUnlockPatterns {

	public static void main(String[] args) {
		System.out.println(numberOfPatterns(1, 1));
		System.out.println(numberOfPatterns(1, 2));
	}

	// 1 2 3
	// 4 5 6
	// 7 8 9
	public static int numberOfPatterns(int m, int n) {
		int count = 0;
		int[][] grid = new int[10][10];
		grid[1][3] = grid[3][1] = 2;
		grid[1][7] = grid[7][1] = 4;
		grid[3][9] = grid[9][3] = 6;
		grid[7][9] = grid[9][7] = 8;
		grid[2][8] = grid[8][2] = grid[4][6] = grid[6][4] = 5;
		grid[1][9] = grid[9][1] = grid[3][7] = grid[7][3] = 5;
		boolean[] visited = new boolean[10];
		for (int i = m; i <= n; i++) {
			count += dfs(grid, visited, i - 1, 1) * 4;
			count += dfs(grid, visited, i - 1, 2) * 4;
			count += dfs(grid, visited, i - 1, 5);
		}
		return count;
	}

	public static int dfs(int[][] grid, boolean[] visited, int remaining, int curr) {
		if (remaining < 0)
			return 0;
		if (remaining == 0)
			return 1;
		int out = 0;
		visited[curr] = true;
		for (int i = 1; i <= 9; i++) {
			if (!visited[i] && (grid[curr][i] == 0 || (visited[grid[curr][i]]))) {
				out += dfs(grid, visited, remaining - 1, i);
			}
		}

		visited[curr] = false;
		return out;
	}
}
