package Nov2020_FBPrep;

import java.util.LinkedList;
import java.util.Queue;

public class _036ShortestDistanceFromAllBuildings {

	public static void main(String[] args) {
		System.out.println(shortestDistance(
				new int[][] { new int[] { 1, 0, 2, 0, 1 }, new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 1, 0, 0 } }));
		System.out.println(shortestDistance(new int[][] { new int[] { 1, 2, 0 } }));
	}

	public static int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int[][] distance = new int[grid.length][grid[0].length];
		int[][] reach = new int[grid.length][grid[0].length];
		int numOfBuildings = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					dfs(i, j, grid, distance, reach);
					numOfBuildings++;
				}
			}
		}
		int distanceOutput = Integer.MAX_VALUE;
		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance[0].length; j++) {
				if (grid[i][j] == 0 && reach[i][j] == numOfBuildings) {
					distanceOutput = Math.min(distance[i][j], distanceOutput);
				}
			}
		}
		return distanceOutput == Integer.MAX_VALUE ? -1 : distanceOutput;
	}

	public static void dfs(int x, int y, int[][] grid, int[][] distance, int[][] reach) {

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y });
		int dist = 1;
		int[][] directions = new int[][] { new int[] { 0, -1 }, new int[] { 0, +1 }, new int[] { +1, 0 },
				new int[] { -1, 0 } };

		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				int[] pollVal = q.poll();
				int currX = pollVal[0];
				int currY = pollVal[1];
				visited[x][y] = true;
				for (int j = 0; j < directions.length; j++) {
					int[] currDirection = directions[j];
					int newX = currDirection[0] + currX;
					int newY = currDirection[1] + currY;
					if (newX < 0 || newY < 0 || newX > grid.length - 1 || newY > grid[0].length - 1
							|| visited[newX][newY] || grid[newX][newY] != 0)
						continue;
					distance[newX][newY] += dist;
					visited[newX][newY] = true;
					reach[newX][newY]++;
					q.offer(new int[] { newX, newY });
				}
			}
			dist++;
		}
	}

}
