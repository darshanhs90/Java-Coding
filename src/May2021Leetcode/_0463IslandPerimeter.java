package May2021Leetcode;

import java.util.HashSet;

public class _0463IslandPerimeter {

	public static void main(String[] args) {
		System.out.println(islandPerimeter(new int[][] { new int[] { 0, 1, 0, 0 }, new int[] { 1, 1, 1, 0 },
				new int[] { 0, 1, 0, 0 }, new int[] { 1, 1, 0, 0 }, }));

		System.out.println(islandPerimeter(new int[][] { new int[] { 1 } }));
		System.out.println(islandPerimeter(new int[][] { new int[] { 1, 0 } }));
	}

	static int count;

	public static int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					dfs(i, j, grid, new HashSet<String>());
					return count;
				}
			}
		}
		return 0;
	}

	public static void dfs(int x, int y, int[][] grid, HashSet<String> visited) {
		if (visited.contains(x + "/" + y))
			return;
		count += 4;
		visited.add(x + "/" + y);

		if (x - 1 >= 0 && grid[x - 1][y] == 1) {
			count--;
			dfs(x - 1, y, grid, visited);
		}

		if (y - 1 >= 0 && grid[x][y - 1] == 1) {
			count--;
			dfs(x, y - 1, grid, visited);
		}

		if (x + 1 < grid.length && grid[x + 1][y] == 1) {
			count--;
			dfs(x + 1, y, grid, visited);
		}

		if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
			count--;
			dfs(x, y + 1, grid, visited);
		}
	}

}
