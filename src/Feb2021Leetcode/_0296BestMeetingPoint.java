package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0296BestMeetingPoint {

	public static void main(String[] args) {
		System.out.println(minTotalDistance(
				new int[][] { new int[] { 1, 0, 0, 0, 1 }, new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 1, 0, 0 } }));
	}

	public static int minTotalDistance(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		List<int[]> homes = new ArrayList<int[]>();
		int[][] distance = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					homes.add(new int[] { i, j });
				}
			}
		}
		for (int i = 0; i < homes.size(); i++) {
			populateDistance(homes.get(i), grid, distance);
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
		Queue<int[]> q = new LinkedList<int[]>();
		HashSet<String> visited = new HashSet<String>();
		q.offer(src);
		visited.add(src[0] + "/" + src[1]);
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		int srcX = src[0];
		int srcY = src[1];
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];

				int dist = Math.abs(x - srcX) + Math.abs(y - srcY);
				distance[x][y] += dist;
				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];
					if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length
							&& !visited.contains(newX + "/" + newY)) {
						q.offer(new int[] { newX, newY });
						visited.add(newX + "/" + newY);
					}
				}
			}
		}
	}
}
