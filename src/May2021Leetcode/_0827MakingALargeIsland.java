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
		HashMap<Integer, Integer> areaMap = new HashMap<Integer, Integer>();
		int islandNum = 2;
		int maxIsland = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					count = 0;
					dfs(i, j, islandNum, grid);
					areaMap.put(islandNum, count);
					islandNum++;
					maxIsland = Math.max(maxIsland, count);
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					maxIsland = Math.max(maxIsland, 1 + maxVal(i, j, grid, areaMap));
				}
			}
		}
		return maxIsland;
	}

	public static int maxVal(int x, int y, int[][] grid, HashMap<Integer, Integer> areaMap) {
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		HashSet<Integer> islands = new HashSet<Integer>();

		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];

			if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] == 0)
				continue;

			islands.add(grid[newX][newY]);
		}

		int val = 0;
		Iterator<Integer> iter = islands.iterator();
		while (iter.hasNext()) {
			val += areaMap.get(iter.next());
		}
		return val;
	}

	public static void dfs(int x, int y, int currIslandNum, int[][] grid) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1)
			return;
		grid[x][y] = currIslandNum;
		count++;
		dfs(x - 1, y, currIslandNum, grid);
		dfs(x + 1, y, currIslandNum, grid);
		dfs(x, y - 1, currIslandNum, grid);
		dfs(x, y + 1, currIslandNum, grid);
	}

}
