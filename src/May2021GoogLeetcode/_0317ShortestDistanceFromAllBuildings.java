package May2021GoogLeetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0317ShortestDistanceFromAllBuildings {

	public static void main(String[] args) {
		System.out.println(shortestDistance(new int[][] { new int[] { 1, 0, 2, 0, 1 }, new int[] { 0, 0, 0, 0, 0 },
				new int[] { 0, 0, 1, 0, 0 }, }));
	}

	public static int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0)
			return -1;
		Queue<int[]> buildings = new LinkedList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					buildings.add(new int[] { i, j });
				}
			}
		}

		int noOfBuildings = buildings.size();
		int[][] dist = new int[grid.length][grid[0].length];
		int[][] reach = new int[grid.length][grid[0].length];
		while (!buildings.isEmpty()) {
			populateDist(buildings.poll(), grid, dist, reach);
		}

		int minDist = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0 && reach[i][j] == noOfBuildings) {
					minDist = Math.min(minDist, dist[i][j]);
				}
			}
		}
		return minDist == Integer.MAX_VALUE ? -1 : minDist;
	}

	public static void populateDist(int[] arr, int[][] grid, int[][] dist, int[][] reach) {
		HashSet<String> visited = new HashSet<String>();
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, 1 }, new int[] { 0, -1 } };
		visited.add(arr[0] + "/" + arr[1]);

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(arr);
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				arr = q.poll();
				int x = arr[0];
				int y = arr[1];
				reach[x][y] += 1;
				dist[x][y] += count;
				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length)
						continue;

					if (grid[newX][newY] != 0 || visited.contains(newX + "/" + newY))
						continue;
					q.offer(new int[] { newX, newY });
					visited.add(newX + "/" + newY);
				}
			}
			count++;
		}
	}
}
