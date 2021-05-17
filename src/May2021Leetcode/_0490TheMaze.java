package May2021Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0490TheMaze {

	public static void main(String[] args) {

		System.out.println(hasPath(
				new int[][] { new int[] { 0, 0, 1, 0, 0 }, new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 1, 0 },
						new int[] { 1, 1, 0, 1, 1 }, new int[] { 0, 0, 0, 0, 0 } },
				new int[] { 0, 4 }, new int[] { 4, 4 }));
	}

	public static boolean hasPath(int[][] maze, int[] start, int[] destination) {

		Queue<int[]> q = new LinkedList<int[]>();
		HashSet<String> visited = new HashSet<String>();
		int rows = maze.length;
		int cols = maze[0].length;
		q.offer(start);
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int x = arr[0];
			int y = arr[1];

			if (x == destination[0] && y == destination[1])
				return true;

			if (visited.contains(x + "/" + y))
				continue;
			visited.add(x + "/" + y);
			for (int j = 0; j < dirs.length; j++) {
				int newX = x;
				int newY = y;

				while (newX >= 0 && newY >= 0 && newX < rows && newY < cols && maze[newX][newY] == 0) {
					newX += dirs[j][0];
					newY += dirs[j][1];
				}

				newX -= dirs[j][0];
				newY -= dirs[j][1];
				q.offer(new int[] { newX, newY });
			}
		}
		return false;
	}

}
