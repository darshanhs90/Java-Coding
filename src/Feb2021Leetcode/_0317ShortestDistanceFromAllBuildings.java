package Feb2021Leetcode;

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
		if (grid == null || grid.length == 0)
			return -1;
		int[][] reach = new int[grid.length][grid[0].length];
		int[][] distance = new int[grid.length][grid[0].length];
		List<int[]> buildings = new ArrayList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					buildings.add(new int[] { i, j });
				}
			}
		}
		int noOfBuildings = buildings.size();

		for (int i = 0; i < buildings.size(); i++) {
			int[] pos = buildings.get(i);
			populateDistance(pos, reach, distance, grid);
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

	public static void populateDistance(int[] pos, int[][] reach, int[][] distance, int[][] grid) {
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(pos);
		int currDistance = 0;
		HashSet<String> visited = new HashSet<String>();

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currPos = q.poll();
				int currX = currPos[0];
				int currY = currPos[1];

				distance[currX][currY] += currDistance;
				reach[currX][currY] += 1;
				for (int j = 0; j < dirs.length; j++) {
					int newX = currX + dirs[j][0];
					int newY = currY + dirs[j][1];

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
