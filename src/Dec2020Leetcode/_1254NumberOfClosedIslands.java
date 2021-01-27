package Dec2020Leetcode;

public class _1254NumberOfClosedIslands {
	public static void main(String[] args) {
		System.out.println(closedIsland(new int[][] { new int[] { 1, 1, 1, 1, 1, 1, 1, 0 },
				new int[] { 1, 0, 0, 0, 0, 1, 1, 0 }, new int[] { 1, 0, 1, 0, 1, 1, 1, 0 },
				new int[] { 1, 0, 0, 0, 0, 1, 0, 1 }, new int[] { 1, 1, 1, 1, 1, 1, 1, 0 } }));

		System.out.println(closedIsland(
				new int[][] { new int[] { 0, 0, 1, 0, 0 }, new int[] { 0, 1, 0, 1, 0 }, new int[] { 0, 1, 1, 1, 0 } }));

		System.out.println(closedIsland(new int[][] { new int[] { 1, 1, 1, 1, 1, 1, 1 },
				new int[] { 1, 0, 0, 0, 0, 0, 1 }, new int[] { 1, 0, 1, 1, 1, 0, 1 }, new int[] { 1, 0, 1, 0, 1, 0, 1 },
				new int[] { 1, 0, 1, 1, 1, 0, 1 }, new int[] { 1, 0, 0, 0, 0, 0, 1 },
				new int[] { 1, 1, 1, 1, 1, 1, 1 } }));
	}

	public static int closedIsland(int[][] grid) {
		for (int i = 0; i < grid[0].length; i++) {
			if (grid[0][i] == 0)
				dfs(0, i, grid);
			if (grid[grid.length - 1][i] == 0)
				dfs(grid.length - 1, i, grid);
		}

		for (int i = 0; i < grid.length; i++) {
			if (grid[i][0] == 0)
				dfs(i, 0, grid);
			if (grid[i][grid[0].length - 1] == 0)
				dfs(i, grid[0].length - 1, grid);
		}

		int count = 0;
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					dfs(i, j, grid);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int x, int y, int[][] grid) {
		if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] != 0)
			return;
		grid[x][y] = 2;
		dfs(x - 1, y, grid);
		dfs(x + 1, y, grid);
		dfs(x, y - 1, grid);
		dfs(x, y + 1, grid);
	}

}
