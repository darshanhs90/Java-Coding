package Jan2021Leetcode;

public class _0695MaxAreaOfIsland {

	public static void main(String[] args) {
		System.out.println(maxAreaOfIsland(new int[][] { new int[] { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				new int[] { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				new int[] { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				new int[] { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));
		System.out.println(maxAreaOfIsland(new int[][] { new int[] { 0, 0, 0, 0, 0, 0, 0, 0 } }));
	}

	public static int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					max = Math.max(max, dfs(i, j, grid));
				}
			}
		}
		return max == Integer.MIN_VALUE ? 0 : max;
	}

	public static int dfs(int x, int y, int[][] grid) {
		if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] != 1)
			return 0;
		int count = 1;
		grid[x][y] = 2;
		count += dfs(x - 1, y, grid);
		count += dfs(x + 1, y, grid);
		count += dfs(x, y - 1, grid);
		count += dfs(x, y + 1, grid);
		return count;
	}
}
