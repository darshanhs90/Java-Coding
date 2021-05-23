package May2021GoogLeetcode;

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
		q.offer(start);
		HashSet<String> visited = new HashSet<String>();
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];
				visited.add(x + "/" + y);
				if (x == destination[0] && y == destination[1])
					return true;

				for (int j = 0; j < dirs.length; j++) {

					int newX = x;
					int newY = y;
					while (newX >= 0 && newY >= 0 && newX < maze.length && newY < maze[0].length
							&& maze[newX][newY] == 0) {
						newX += dirs[j][0];
						newY += dirs[j][1];
					}

					newX -= dirs[j][0];
					newY -= dirs[j][1];

					if (visited.contains(newX + "/" + newY)) {
						continue;
					}
					visited.add(newX + "/" + newY);
					q.offer(new int[] { newX, newY });
				}
			}
		}
		return false;
	}
}
