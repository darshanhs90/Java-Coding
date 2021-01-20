package Dec2020Leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0694NumberOfDistinctIslands {

	public static void main(String[] args) {
		System.out.println(numDistinctIslands(new int[][] { new int[] { 1, 1, 0, 0, 0 }, new int[] { 1, 1, 0, 0, 0 },
				new int[] { 0, 0, 0, 1, 1 }, new int[] { 0, 0, 0, 1, 1 } }));
		System.out.println(numDistinctIslands(new int[][] { new int[] { 1, 1, 0, 1, 1 }, new int[] { 1, 0, 0, 0, 0 },
				new int[] { 0, 0, 0, 0, 1 }, new int[] { 1, 1, 0, 1, 1 } }));
	}

	public static int numDistinctIslands(int[][] grid) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					dfs(i, j, 0, 0, sb, grid);
					set.add(sb.toString());
				}
			}
		}
		return set.size();
	}

	public static void dfs(int actualX, int actualY, int relativeX, int relativeY, StringBuilder sb, int[][] grid) {
		if (actualX < 0 || actualY < 0 || actualX > grid.length - 1 || actualY > grid[0].length - 1
				|| grid[actualX][actualY] != 1)
			return;

		grid[actualX][actualY] = 0;
		sb.append(relativeX + "/" + relativeY + "/");
		dfs(actualX - 1, actualY, relativeX - 1, relativeY, sb, grid);
		dfs(actualX + 1, actualY, relativeX + 1, relativeY, sb, grid);
		dfs(actualX, actualY - 1, relativeX, relativeY - 1, sb, grid);
		dfs(actualX, actualY + 1, relativeX, relativeY + 1, sb, grid);
	}

}
