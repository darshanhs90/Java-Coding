package Jan2021Leetcode;

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
		int[][] seen = new int[grid.length][grid[0].length];
		for (int i = 0; i < seen.length; i++) {
			Arrays.fill(seen[i], Integer.MAX_VALUE);
		}

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0, grid[0][0] });
		seen[0][0] = grid[0][0];
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { +1, 0 }, new int[] { 0, -1 },
				new int[] { 0, +1 } };
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] pollVal = q.poll();
				int x = pollVal[0];
				int y = pollVal[1];
				int kVal = pollVal[2];

				if (x == grid.length - 1 && y == grid[0].length - 1)
					return count;

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length)
						continue;

					int newVal = kVal + grid[newX][newY];
					if (newVal > k || seen[newX][newY] <= newVal) {
						continue;
					}

					seen[newX][newY] = newVal;
					q.offer(new int[] { newX, newY, newVal });
				}
			}
			count++;
		}
		return -1;
	}

}
