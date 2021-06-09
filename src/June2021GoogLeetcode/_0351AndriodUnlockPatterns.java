package June2021GoogLeetcode;

import java.util.HashSet;

public class _0351AndriodUnlockPatterns {

	public static void main(String[] args) {
		System.out.println(numberOfPatterns(1, 1));
		System.out.println(numberOfPatterns(1, 2));
	}

	// 1 2 3
	// 4 5 6
	// 7 8 9
	public static int numberOfPatterns(int m, int n) {
		int[][] grid = new int[10][10];
		grid[1][3] = grid[3][1] = 2;
		grid[1][7] = grid[7][1] = 4;
		grid[7][9] = grid[9][7] = 8;
		grid[3][9] = grid[9][3] = 6;

		grid[1][9] = grid[9][1] = grid[3][7] = grid[7][3] = 5;
		grid[2][8] = grid[8][2] = grid[4][6] = grid[6][4] = 5;

		int count = 0;
		for (int i = m; i <= n; i++) {
			count += dfs(1, i - 1, grid, new HashSet<Integer>()) * 4;
			count += dfs(2, i - 1, grid, new HashSet<Integer>()) * 4;
			count += dfs(5, i - 1, grid, new HashSet<Integer>());
		}
		return count;
	}

	public static int dfs(int src, int n, int[][] grid, HashSet<Integer> visited) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		int count = 0;
		visited.add(src);
		for (int i = 1; i <= 9; i++) {
			if (!visited.contains(i) && (grid[src][i] == 0 || visited.contains(grid[src][i]))) {
				count += dfs(i, n - 1, grid, visited);
			}
		}
		visited.remove(Integer.valueOf(src));
		return count;
	}
}
