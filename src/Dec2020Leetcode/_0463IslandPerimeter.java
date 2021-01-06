package Dec2020Leetcode;

public class _0463IslandPerimeter {

	public static void main(String[] args) {
		System.out.println(islandPerimeter(new int[][] { new int[] { 0, 1, 0, 0 }, new int[] { 1, 1, 1, 0 },
				new int[] { 0, 1, 0, 0 }, new int[] { 1, 1, 0, 0 }, }));

		System.out.println(islandPerimeter(new int[][] { new int[] { 1 } }));
		System.out.println(islandPerimeter(new int[][] { new int[] { 1, 0 } }));
	}

	static int count = 0;

	public static int islandPerimeter(int[][] grid) {
		count = 0;
		if (grid == null || grid.length == 0)
			return 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					dfs(i, j, grid, visited);
					return count;
				}
			}
		}

		return count;
	}

	public static void dfs(int x, int y, int[][] grid, boolean[][] visited) {
		if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] == 0 || visited[x][y])
			return;

		visited[x][y] = true;

		count += 4;
		if (x - 1 >= 0 && y >= 0 && grid[x - 1][y] == 1) {
			count--;
			dfs(x - 1, y, grid, visited);
		}

		if (x >= 0 && y - 1 >= 0 && grid[x][y - 1] == 1) {
			count--;
			dfs(x, y - 1, grid, visited);
		}

		if (x + 1 < grid.length && y >= 0 && grid[x + 1][y] == 1) {
			count--;
			dfs(x + 1, y, grid, visited);
		}

		if (x >= 0 && y + 1 < grid[0].length && grid[x][y + 1] == 1) {
			count--;
			dfs(x, y + 1, grid, visited);
		}
	}

}
