package June2021GoogLeetcode;

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
		if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
			return -1;

		int rows = grid.length, cols = grid[0].length;
		Queue<int[]> q = new LinkedList<int[]>();
		HashSet<String> visited = new HashSet<String>();
		int count = 0;
		q.offer(new int[] { 0, 0 });
		visited.add("0/0");

		int[][] dirs = new int[][] { new int[] { -1, -1 }, new int[] { -1, 0 }, new int[] { -1, 1 },
				new int[] { 0, -1 }, new int[] { 0, 1 }, new int[] { 1, -1 }, new int[] { 1, 0 }, new int[] { 1, 1 } };

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];
				if (x == rows - 1 && y == cols - 1)
					return count + 1;

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length)
						continue;

					if (visited.contains(newX + "/" + newY) || grid[newX][newY] != 0)
						continue;

					q.offer(new int[] { newX, newY });
					visited.add(newX + "/" + newY);
				}
			}
			count++;
		}
		return -1;
	}
}
