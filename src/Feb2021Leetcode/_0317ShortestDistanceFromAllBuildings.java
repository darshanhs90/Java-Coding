package Feb2021Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0317ShortestDistanceFromAllBuildings {

	public static void main(String[] args) {
		System.out.println(shortestDistance(new int[][] { new int[] { 1, 0, 2, 0, 1 }, new int[] { 0, 0, 0, 0, 0 },
				new int[] { 0, 0, 1, 0, 0 }, }));
	}

	public static int shortestDistance(int[][] grid) {
		Queue<int[]> buildings = new LinkedList<int[]>();
		int[][] distance = new int[grid.length][grid[0].length];
		int[][] reach = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					buildings.add(new int[] { i, j });
				}
			}
		}

		int noOfBuildings = buildings.size();

		while (!buildings.isEmpty()) {
			int[] building = buildings.poll();
			dfs(building, grid, distance, reach);
		}

		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0 && reach[i][j] == noOfBuildings) {
					minDistance = Math.min(minDistance, distance[i][j]);
				}
			}
		}
		return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	}

	public static void dfs(int[] building, int[][] grid, int[][] distance, int[][] reach) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(building);
		HashSet<String> visited = new HashSet<String>();
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		int currDistance = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] poll = q.poll();
				int x = poll[0];
				int y = poll[1];
				distance[x][y] += currDistance;
				reach[x][y] += 1;
				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 0
							&& !visited.contains(newX + "/" + newY)) {
						q.offer(new int[] { newX, newY });
						visited.add(newX + "/" + newY);
					}
				}
			}
			currDistance++;
		}
	}

}
