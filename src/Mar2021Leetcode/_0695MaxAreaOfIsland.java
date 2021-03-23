package Mar2021Leetcode;

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

	static int maxArea, currArea;

	public static int maxAreaOfIsland(int[][] grid) {
		maxArea = 0;
		currArea = 0;
		if (grid == null || grid.length == 0)
			return 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					currArea = 0;
					dfs(i, j, grid);
					maxArea = Math.max(maxArea, currArea);
				}
			}
		}
		return maxArea;
	}

	public static void dfs(int x, int y, int[][] grid) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1)
			return;
		grid[x][y] = 0;
		currArea++;
		dfs(x - 1, y, grid);
		dfs(x + 1, y, grid);
		dfs(x, y - 1, grid);
		dfs(x, y + 1, grid);
	}
}
