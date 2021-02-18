package Jan2021Leetcode;

import java.util.Arrays;
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
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					q.offer(new int[] { i, j });
				}
			}
		}

		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		int dist = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] point = q.poll();
				int x = point[0];
				int y = point[1];

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX > rooms.length - 1 || newY > rooms[0].length - 1
							|| rooms[newX][newY] == 0 || rooms[newX][newY] == -1)
						continue;

					if (rooms[newX][newY] <= dist)
						continue;

					rooms[newX][newY] = dist;
					q.offer(new int[] { newX, newY });
				}
			}
			dist++;
		}

		for (int i = 0; i < rooms.length; i++) {
			System.out.println(Arrays.toString(rooms[i]));
		}

	}

}
