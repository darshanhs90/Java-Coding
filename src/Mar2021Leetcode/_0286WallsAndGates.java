package Mar2021Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0286WallsAndGates {

	public static void main(String[] args) {
		wallsAndGates(new int[][] { new int[] { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
				new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
				new int[] { Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 },
				new int[] { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE }, });

	}

	public static void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0)
			return;
		Queue<int[]> q = new LinkedList<int[]>();
		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					q.offer(new int[] { i, j });
					visited.add(i + "/" + j);
				}
			}
		}
		int count = 0;
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];

				rooms[x][y] = count;

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX >= rooms.length || newY >= rooms[0].length
							|| visited.contains(newX + "/" + newY) || rooms[newX][newY] == 0 || rooms[newX][newY] == -1)
						continue;

					q.offer(new int[] { newX, newY });
					visited.add(newX + "/" + newY);
				}
			}
			count++;
		}
	}

}
