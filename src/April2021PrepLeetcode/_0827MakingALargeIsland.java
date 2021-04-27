package April2021PrepLeetcode;

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
		if (grid == null || grid.length == 0)
			return 0;
		int maxIslandSize = 0;
		int islandNum = 2;
		HashMap<Integer, Integer> islandSizeMapping = new HashMap<Integer, Integer>();

		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && !visited.contains(i + "/" + j)) {
					count = 0;
					dfs(i, j, grid, islandNum, visited);
					islandSizeMapping.put(islandNum, count);
					islandNum++;
					maxIslandSize = Math.max(maxIslandSize, count);
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					maxIslandSize = Math.max(maxIslandSize, islandSize(i, j, grid, islandSizeMapping)+1);
				}
			}
		}

		return maxIslandSize;
	}

	public static int islandSize(int x, int y, int[][] grid, HashMap<Integer, Integer> islandSizeMapping) {
		HashSet<Integer> islandNumbers = new HashSet<Integer>();
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		int islandSum = 0;
		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];

			if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length)
				continue;
			if (grid[newX][newY] != 0)
				islandNumbers.add(grid[newX][newY]);
		}

		Iterator<Integer> iter = islandNumbers.iterator();
		while (iter.hasNext()) {
			islandSum += islandSizeMapping.get(iter.next());
		}
		return islandSum;
	}

	public static void dfs(int x, int y, int[][] grid, int islandNum, HashSet<String> visited) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited.contains(x + "/" + y)
				|| grid[x][y] != 1)
			return;

		count++;
		grid[x][y] = islandNum;
		visited.add(x + "/" + y);
		dfs(x - 1, y, grid, islandNum, visited);
		dfs(x + 1, y, grid, islandNum, visited);
		dfs(x, y - 1, grid, islandNum, visited);
		dfs(x, y + 1, grid, islandNum, visited);
	}

}
