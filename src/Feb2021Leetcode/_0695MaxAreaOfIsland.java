package Feb2021Leetcode;

import java.util.HashSet;

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

	static int currArea;

	public static int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int maxArea = 0;
		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && !visited.contains(i + "/" + j)) {
					currArea = 0;
					dfs(i, j, grid, visited);
					maxArea = Math.max(maxArea, currArea);
				}
			}
		}
		return maxArea;
	}

	public static void dfs(int x, int y, int[][] grid, HashSet<String> visited) {
		if (x < 0 || y < 0 | x > grid.length - 1 || y > grid[0].length - 1 || visited.contains(x + "/" + y)
				|| grid[x][y] != 1)
			return;

		visited.add(x + "/" + y);
		currArea++;
		dfs(x - 1, y, grid, visited);
		dfs(x + 1, y, grid, visited);
		dfs(x, y - 1, grid, visited);
		dfs(x, y + 1, grid, visited);
	}
}
