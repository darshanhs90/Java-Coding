package Dec2020Leetcode;

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
		Queue<int[]> q = new LinkedList<int[]>();
		if (grid == null || grid.length == 0 || grid[0][0] != 0)
			return -1;

		int[][] dirs = new int[][] { new int[] { -1, -1 }, new int[] { -1, 0 }, new int[] { -1, +1 },
				new int[] { 0, -1 }, new int[] { 0, +1 }, new int[] { +1, -1 }, new int[] { +1, 0 },
				new int[] { +1, +1 }, };
		HashSet<String> visited = new HashSet<String>();
		q.add(new int[] { 0, 0 });
		int level = 0;
		visited.add(0 + "," + 0);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] poll = q.poll();
				int xCoord = poll[0];
				int yCoord = poll[1];
				if (xCoord == grid.length - 1 && yCoord == grid[0].length - 1)
					return level + 1;
				for (int j = 0; j < dirs.length; j++) {
					int newX = xCoord + dirs[j][0];
					int newY = yCoord + dirs[j][1];
					if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 0
							&& !visited.contains(newX + "," + newY)) {
						q.offer(new int[] { newX, newY });
						visited.add(newX + "," + newY);
					}
				}
			}
			level++;
		}
		return -1;
	}
}
