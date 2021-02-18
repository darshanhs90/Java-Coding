package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0317ShortestDistanceFromAllBuildings {

	public static void main(String[] args) {
		System.out.println(shortestDistance(new int[][] { new int[] { 1, 0, 2, 0, 1 }, new int[] { 0, 0, 0, 0, 0 },
				new int[] { 0, 0, 1, 0, 0 }, }));
	}

	public static int shortestDistance(int[][] grid) {

		int noOfBuildings = 0;
		int[][] reach = new int[grid.length][grid[0].length];
		int[][] distance = new int[grid.length][grid[0].length];

		List<int[]> buildings = new ArrayList<int[]>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					buildings.add(new int[] { i, j });
					grid[i][j] = -2;
					noOfBuildings++;
				} else if (grid[i][j] == 2) {
					grid[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < buildings.size(); i++) {
			populateDistanceAndReach(buildings.get(i), grid, distance, reach);
		}

		int minDistance = Integer.MAX_VALUE;

		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance[0].length; j++) {
				if (grid[i][j] != -1 && grid[i][j] != -2) {
					if (reach[i][j] == noOfBuildings) {
						minDistance = Math.min(minDistance, distance[i][j]);
					}
				}
			}
		}
		return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	}

	public static void populateDistanceAndReach(int[] building, int[][] grid, int[][] distance, int[][] reach) {
		Queue<int[]> q = new LinkedList<int[]>();
		HashSet<String> visited = new HashSet<String>();
		q.offer(building);
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		int dist = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] point = q.poll();
				int x = point[0];
				int y = point[1];

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX > grid.length - 1 || newY > grid[0].length - 1
							|| grid[newX][newY] == -2 || grid[newX][newY] == -1 || visited.contains(newX + "/" + newY))
						continue;

					distance[newX][newY] += dist;
					reach[newX][newY] += 1;
					visited.add(newX + "/" + newY);
					q.offer(new int[] { newX, newY });
				}
			}
			dist++;
		}
	}

}
