package Dec2020Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _1293ShortestPathInAGridWithObstaclesElimination {
	public static void main(String[] args) {
		System.out.println(shortestPath(new int[][] { new int[] { 0, 0, 0 }, new int[] { 1, 1, 0 },
				new int[] { 0, 0, 0 }, new int[] { 0, 1, 1 }, new int[] { 0, 0, 0 } }, 1));

		System.out.println(
				shortestPath(new int[][] { new int[] { 0, 1, 1 }, new int[] { 1, 1, 1 }, new int[] { 1, 0, 0 } }, 1));
	}

	public static int shortestPath(int[][] grid, int k) {
		if (grid == null || grid.length == 0)
			return -1;
		int dirs[][] = new int[][] { new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, 1 }, new int[] { 0, -1 } };
		int rows = grid.length;
		int cols = grid[0].length;

		int[][] seen = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			Arrays.fill(seen[i], Integer.MAX_VALUE);
		}

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0, grid[0][0] });
		seen[0][0] = grid[0][0];
		int steps = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] poll = q.poll();
				int x = poll[0];
				int y = poll[1];
				if (x == rows - 1 && y == cols - 1)
					return steps;
				int dist = poll[2];
				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];
					if (newX < 0 || newY < 0 || newX > rows - 1 || newY > cols - 1) {
						continue;
					}
					int val = dist + grid[newX][newY];
					if (val >= seen[newX][newY] || val > k)
						continue;
					seen[newX][newY] = val;
					q.offer(new int[] { newX, newY, val });
				}
			}
			steps++;
		}
		return -1;
	}

}
