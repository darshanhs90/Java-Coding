package June2021GoogLeetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0317ShortestDistanceFromAllBuildings {

	public static void main(String[] args) {
		System.out.println(shortestDistance(new int[][] { new int[] { 1, 0, 2, 0, 1 }, new int[] { 0, 0, 0, 0, 0 },
				new int[] { 0, 0, 1, 0, 0 }, }));
	}

	public static int shortestDistance(int[][] grid) {
		int[][] dist = new int[grid.length][grid[0].length];
		int[][] reach = new int[grid.length][grid[0].length];
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < reach.length; i++) {
			for (int j = 0; j < reach[0].length; j++) {
				if (grid[i][j] == 1) {
					q.offer(new int[] { i, j });
				}
			}
		}

		int noOfBuildings = q.size();
		while (!q.isEmpty()) {
			populatDist(q.poll(), grid, reach, dist);
		}

		int minDist = Integer.MAX_VALUE;
		for (int i = 0; i < reach.length; i++) {
			for (int j = 0; j < reach[0].length; j++) {
				if (reach[i][j] == noOfBuildings && grid[i][j] == 0) {
					minDist = Math.min(minDist, dist[i][j]);
				}
			}
		}
		return minDist == Integer.MAX_VALUE ? -1 : minDist;
	}

	public static void populatDist(int[] arr, int[][] grid, int[][] reach, int[][] dist) {
		HashSet<String> visited = new HashSet<String>();
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(arr);
		visited.add(arr[0] + "/" + arr[1]);
		int count = 0;
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
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

					if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length
							|| visited.contains(newX + "/" + newY))
						continue;

					if (grid[newX][newY] != 0)
						continue;

					q.offer(new int[] { newX, newY });
					visited.add(newX + "/" + newY);
				}
			}
			count++;
		}
	}
}
