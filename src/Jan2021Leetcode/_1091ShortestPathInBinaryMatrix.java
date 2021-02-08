package Jan2021Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _1091ShortestPathInBinaryMatrix {
	public static void main(String[] args) {
		System.out.println(shortestPathBinaryMatrix(new int[][] { new int[] { 0, 1 }, new int[] { 1, 0 } }));

		System.out.println(shortestPathBinaryMatrix(
				new int[][] { new int[] { 0, 0, 0 }, new int[] { 1, 1, 0 }, new int[] { 1, 1, 0 } }));
	}

	public static int shortestPathBinaryMatrix(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
			return -1;

		Queue<int[]> q = new LinkedList<int[]>();
		HashSet<String> visited = new HashSet<String>();
		q.offer(new int[] { 0, 0 });
		visited.add("0/0");
		int count = 1;
		int[][] dirs = new int[][] { new int[] { -1, -1 }, new int[] { -1, 0 }, new int[] { -1, +1 },
				new int[] { 0, -1 }, new int[] { 0, +1 }, new int[] { +1, -1 }, new int[] { +1, 0 },
				new int[] { +1, +1 } };
		int rows = grid.length;
		int cols = grid[0].length;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] point = q.poll();
				if (point[0] == rows - 1 && point[1] == cols - 1)
					return count;
				int x = point[0];
				int y = point[1];
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
			count++;
		}

		return -1;
	}
}
