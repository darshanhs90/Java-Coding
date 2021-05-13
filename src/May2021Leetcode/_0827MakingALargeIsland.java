package May2021Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class _0827MakingALargeIsland {

	public static void main(String[] args) {
		System.out.println(largestIsland(new int[][] { new int[] { 1, 0 }, new int[] { 0, 1 } }));

		System.out.println(largestIsland(new int[][] { new int[] { 1, 1 }, new int[] { 1, 0 } }));

		System.out.println(largestIsland(new int[][] { new int[] { 1, 1 }, new int[] { 1, 1 } }));
	}

	static int count;

	public static int largestIsland(int[][] grid) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int islandNum = 2;
		int maxLength = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					count = 0;
					dfs(i, j, grid, islandNum);
					maxLength = Math.max(maxLength, count);
					map.put(islandNum, count);
					islandNum++;
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					maxLength = Math.max(maxLength, maxVal(i, j, grid, map) + 1);
				}
			}
		}
		return maxLength;
	}

	public static int maxVal(int x, int y, int[][] grid, HashMap<Integer, Integer> map) {
		HashSet<Integer> adj = new HashSet<Integer>();
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];

			if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] == 0)
				continue;
			adj.add(grid[newX][newY]);
		}

		int count = 0;
		Iterator<Integer> iter = adj.iterator();
		while (iter.hasNext()) {
			count += map.get(iter.next());
		}
		return count;
	}

	public static void dfs(int x, int y, int[][] grid, int island) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1)
			return;
		count++;
		grid[x][y] = island;
		dfs(x - 1, y, grid, island);
		dfs(x + 1, y, grid, island);
		dfs(x, y - 1, grid, island);
		dfs(x, y + 1, grid, island);
	}

}
