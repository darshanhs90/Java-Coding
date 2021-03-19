package Feb2021Leetcode;

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
		int[][] seen = new int[grid.length][grid[0].length];

		for (int i = 0; i < seen.length; i++) {
			Arrays.fill(seen[i], Integer.MAX_VALUE);
		}

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0, grid[0][0] });
		seen[0][0] = grid[0][0];
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		int dist = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currPosition = q.poll();
				int x = currPosition[0];
				int y = currPosition[1];
				int currKVal = currPosition[2];

				if (x == grid.length - 1 && y == grid[0].length - 1)
					return dist;

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX > grid.length - 1 || newY > grid[0].length - 1)
						continue;

					int newKVal = currKVal + grid[newX][newY];
					if (newKVal > k || seen[newX][newY] < newKVal)
						continue;
					seen[newX][newY] = newKVal;
					q.offer(new int[] { newX, newY, newKVal });
				}
			}
			dist++;
		}
		return -1;
	}

}
