package Jan2021Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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
		HashSet<String> visitedStrings = new HashSet<String>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					bfs(i, j, grid, visitedStrings);
			}
		}

		System.out.println(visitedStrings);

		return visitedStrings.size();
	}

	static class Pair {
		int x, y, relX, relY;

		public Pair(int x, int y, int relX, int relY) {
			this.x = x;
			this.y = y;
			this.relX = relX;
			this.relY = relY;
		}
	}

	public static void bfs(int x, int y, int[][] grid, HashSet<String> visitedStrings) {
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 },
				new int[] { 0, 1 }, };
		StringBuilder sb = new StringBuilder();
		Queue<Pair> q = new LinkedList<Pair>();
		HashSet<String> visited = new HashSet<String>();
		q.offer(new Pair(x, y, 0, 0));
		visited.add(x + "/" + y);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair pair = q.poll();
				int currX = pair.x;
				int currY = pair.y;
				grid[currX][currY] = 0;
				
				sb.append(pair.relX + "/");
				sb.append(pair.relY + "/");
				for (int j = 0; j < dirs.length; j++) {
					int newX = currX + dirs[j][0];
					int newY = currY + dirs[j][1];

					if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length
							&& !visited.contains(newX + "/" + newY) && grid[newX][newY] == 1) {
						int relNewX = pair.relX + dirs[j][0];
						int relNewY = pair.relY + dirs[j][1];
						visited.add(newX + "/" + newY);
						q.offer(new Pair(newX, newY, relNewX, relNewY));
					}
				}
			}
		}

		visitedStrings.add(sb.toString());
	}

}
