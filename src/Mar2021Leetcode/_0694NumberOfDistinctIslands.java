package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0694NumberOfDistinctIslands {

	public static void main(String[] args) {
		System.out.println(numDistinctIslands(new int[][] { new int[] { 1, 1, 0, 0, 0 }, new int[] { 1, 1, 0, 0, 0 },
				new int[] { 0, 0, 0, 1, 1 }, new int[] { 0, 0, 0, 1, 1 } }));
		System.out.println(numDistinctIslands(new int[][] { new int[] { 1, 1, 0, 1, 1 }, new int[] { 1, 0, 0, 0, 0 },
				new int[] { 0, 0, 0, 0, 1 }, new int[] { 1, 1, 0, 1, 1 } }));
	}

	public static int numDistinctIslands(int[][] grid) {
		HashSet<String> visited = new HashSet<String>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					List<String> list = new ArrayList<String>();
					dfs(i, j, 0, 0, grid, list);
					visited.add(String.join("/", list));
				}
			}
		}
		return visited.size();
	}

	public static void dfs(int x, int y, int baseX, int baseY, int[][] grid, List<String> list) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1)
			return;
		list.add(baseX + "");
		list.add(baseY + "");
		grid[x][y] = 0;
		dfs(x - 1, y, baseX - 1, baseY, grid, list);
		dfs(x + 1, y, baseX + 1, baseY, grid, list);
		dfs(x, y - 1, baseX, baseY - 1, grid, list);
		dfs(x, y + 1, baseX, baseY + 1, grid, list);
	}

}
