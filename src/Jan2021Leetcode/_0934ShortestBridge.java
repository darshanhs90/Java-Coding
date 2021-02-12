package Jan2021Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0934ShortestBridge {

	public static void main(String[] args) {
		System.out.println(shortestBridge(new int[][] { new int[] { 0, 1 }, new int[] { 1, 0 } }));
		System.out.println(
				shortestBridge(new int[][] { new int[] { 0, 1, 0 }, new int[] { 0, 0, 0 }, new int[] { 0, 0, 1 } }));

		System.out.println(shortestBridge(new int[][] { new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 0, 0, 0, 1 },
				new int[] { 1, 0, 1, 0, 1 }, new int[] { 1, 0, 0, 0, 1 }, new int[] { 1, 1, 1, 1, 1 } }));
	}

	public static int shortestBridge(int[][] A) {
		Queue<int[]> q = new LinkedList<int[]>();
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					populateQueue(i, j, q, set, A);
					return findMinBridge(q, set, A);
				}
			}
		}

		return -1;
	}

	public static void populateQueue(int x, int y, Queue<int[]> q, HashSet<String> visited, int[][] A) {
		if (x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] != 1 || visited.contains(x + "/" + y))
			return;
		A[x][y] = -1;
		q.offer(new int[] { x, y });
		visited.add(x + "/" + y);
		populateQueue(x - 1, y, q, visited, A);
		populateQueue(x + 1, y, q, visited, A);
		populateQueue(x, y - 1, q, visited, A);
		populateQueue(x, y + 1, q, visited, A);
	}

	public static int findMinBridge(Queue<int[]> q, HashSet<String> visited, int[][] A) {
		int count = 0;

		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];

				if (A[x][y] == 1)
					return count - 1;

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];
					if (newX < 0 || newY < 0 || newX >= A.length || newY >= A[0].length || A[newX][newY] == -1
							|| visited.contains(newX + "/" + newY))
						continue;

					visited.add(newX + "/" + newY);
					q.offer(new int[] { newX, newY });
				}
			}
			count++;
		}
		return -1;
	}

}
