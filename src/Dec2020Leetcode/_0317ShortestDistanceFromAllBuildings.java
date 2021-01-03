package Dec2020Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0317ShortestDistanceFromAllBuildings {

	public static void main(String[] args) {
		System.out.println(shortestDistance(new int[][] { new int[] { 1, 0, 2, 0, 1 }, new int[] { 0, 0, 0, 0, 0 },
				new int[] { 0, 0, 1, 0, 0 }, }));
	}

	public static int shortestDistance(int[][] grid) {
		int[][] distance = new int[grid.length][grid[0].length];
		int[][] reach = new int[grid.length][grid[0].length];
		int maxNumberOfBuildings = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					dfs(i, j, grid, distance, reach);
					maxNumberOfBuildings++;
				}
			}
		}

		int minDistance = Integer.MAX_VALUE;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0 && reach[i][j] == maxNumberOfBuildings) {
					minDistance = Math.min(minDistance, distance[i][j]);
				}
			}
		}

		return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	}

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void dfs(int i, int j, int[][] grid, int[][] distance, int[][] reach) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int distanceFromBuilding = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(i, j));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int index = 0; index < size; index++) {
				Pair p = q.poll();
				int x = p.x;
				int y = p.y;
				if (visited[x][y])
					continue;

				if (x - 1 >= 0 && grid[x - 1][y] == 0 && visited[x - 1][y] == false) {
					q.offer(new Pair(x - 1, y));
				}
				if (x + 1 < grid.length && grid[x + 1][y] == 0 && visited[x + 1][y] == false) {
					q.offer(new Pair(x + 1, y));
				}
				if (y - 1 >= 0 && grid[x][y - 1] == 0 && visited[x][y - 1] == false) {
					q.offer(new Pair(x, y - 1));
				}
				if (y + 1 < grid[0].length && grid[x][y + 1] == 0 && visited[x][y + 1] == false) {
					q.offer(new Pair(x, y + 1));
				}
				visited[x][y] = true;
				reach[x][y] += 1;
				distance[x][y] += distanceFromBuilding;
			}
			distanceFromBuilding++;
		}
	}

}
