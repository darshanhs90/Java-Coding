package April2021PrepLeetcode;

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
		HashSet<String> output = new HashSet<String>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					List<String> list = new ArrayList<String>();
					dfs(i, j, 0, 0, grid, list);
					output.add(String.join(",", list));
				}
			}
		}
		return output.size();
	}

	public static void dfs(int x, int y, int baseX, int baseY, int[][] grid, List<String> list) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1)
			return;
		list.add(baseX + "");
		list.add(baseY + "");
		grid[x][y] = 0;

		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];
			int baseNewX = baseX + dirs[i][0];
			int baseNewY = baseY + dirs[i][1];
			dfs(newX, newY, baseNewX, baseNewY, grid, list);
		}
	}

}
