package Mar2021Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0296BestMeetingPoint {

	public static void main(String[] args) {
		System.out.println(minTotalDistance(
				new int[][] { new int[] { 1, 0, 0, 0, 1 }, new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 1, 0, 0 } }));
	}

	public static int minTotalDistance(int[][] grid) {
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					q.offer(new int[] { i, j });
				}
			}
		}
		int[][] distance = new int[grid.length][grid[0].length];
		while (!q.isEmpty()) {
			int[] src = q.poll();
			populateDistance(src, grid, distance);
		}
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				minDistance = Math.min(minDistance, distance[i][j]);
			}
		}
		return minDistance;
	}

	public static void populateDistance(int[] src, int[][] grid, int[][] distance) {
		HashSet<String> visited = new HashSet<String>();
		int x = src[0];
		int y = src[1];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(src);
		visited.add(x + "/" + y);
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int currX = arr[0];
				int currY = arr[1];
				distance[currX][currY] += Math.abs(currX - x) + Math.abs(currY - y);

				for (int j = 0; j < dirs.length; j++) {
					int newX = currX + dirs[j][0];
					int newY = currY + dirs[j][1];

					if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length
							|| visited.contains(newX + "/" + newY))
						continue;
					q.offer(new int[] { newX, newY });
					visited.add(newX + "/" + newY);
				}
			}
		}
	}
}
