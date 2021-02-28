package FacebookPrep;

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
		int noOfBuildings = 0;
		int[][] reach = new int[grid.length][grid[0].length];
		int[][] distance = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					buildings.offer(new int[] { i, j });
			}
		}
		noOfBuildings = buildings.size();

		for (int i = 0; i < noOfBuildings; i++) {
			int[] poll = buildings.poll();
			populateDistanceAndReach(poll, grid, reach, distance);
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0 && reach[i][j] == noOfBuildings) {
					min = Math.min(min, distance[i][j]);
				}
			}
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public static void populateDistanceAndReach(int[] startPoint, int[][] grid, int[][] reach, int[][] distance) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(startPoint);
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		HashSet<String> visited = new HashSet<String>();
		int currDistance = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] != 0
							|| visited.contains(newX + "/" + newY))
						continue;

					q.offer(new int[] { newX, newY });
					distance[newX][newY] += currDistance;
					reach[newX][newY] += 1;
					visited.add(newX + "/" + newY);
				}
			}
			currDistance++;
		}
	}

}
