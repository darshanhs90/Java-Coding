package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0296BestMeetingPoint {

	public static void main(String[] args) {
		System.out.println(minTotalDistance(
				new int[][] { new int[] { 1, 0, 0, 0, 1 }, new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 1, 0, 0 } }));
	}

	public static int minTotalDistance(int[][] grid) {
		int[][] distance = new int[grid.length][grid[0].length];
		List<int[]> users = new ArrayList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					users.add(new int[] { i, j });
				}
			}
		}

		for (int i = 0; i < users.size(); i++) {
			int x = users.get(i)[0];
			int y = users.get(i)[1];

			dfs(x, y, x, y, grid, distance, new HashSet<String>());
		}

		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				minLength = Math.min(minLength, distance[i][j]);
			}
		}
		return minLength;
	}

	public static void dfs(int currX, int currY, int prevX, int prevY, int[][] grid, int[][] distance,
			HashSet<String> visited) {

		if (currX < 0 || currY < 0 || currX > grid.length - 1 || currY > grid[0].length - 1
				|| visited.contains(currX + "/" + currY))
			return;

		distance[currX][currY] += Math.abs(currX - prevX) + Math.abs(currY - prevY);
		visited.add(currX + "/" + currY);

		dfs(currX - 1, currY, prevX, prevY, grid, distance, visited);
		dfs(currX + 1, currY, prevX, prevY, grid, distance, visited);
		dfs(currX, currY - 1, prevX, prevY, grid, distance, visited);
		dfs(currX, currY + 1, prevX, prevY, grid, distance, visited);
	}
}
