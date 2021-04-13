package April2021Leetcode;

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
		if (grid == null || grid.length == 0)
			return 0;
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					List<String> list = new ArrayList<String>();
					dfs(i, j, 0, 0, grid, list);
					set.add(String.join("/", list));
				}
			}
		}
		return set.size();
	}

	public static void dfs(int x, int y, int baseX, int baseY, int[][] grid, List<String> list) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1)
			return;

		grid[x][y] = 0;
		list.add(baseX + "");
		list.add(baseY + "");
		dfs(x - 1, y, baseX - 1, baseY, grid, list);
		dfs(x + 1, y, baseX + 1, baseY, grid, list);
		dfs(x, y - 1, baseX, baseY - 1, grid, list);
		dfs(x, y + 1, baseX, baseY + 1, grid, list);
	}

}
