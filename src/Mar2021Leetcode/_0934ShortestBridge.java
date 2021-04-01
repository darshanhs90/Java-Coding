package Mar2021Leetcode;

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
		if (A == null || A.length == 0)
			return 0;
		Queue<int[]> q = new LinkedList<int[]>();
		HashSet<String> visited = new HashSet<String>();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					populateQueue(i, j, A, q, visited);
					return bfs(q, visited, A);
				}
			}
		}
		return 0;
	}

	public static int bfs(Queue<int[]> q, HashSet<String> visited, int[][] A) {
		int count = 0;
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] poll = q.poll();
				int x = poll[0];
				int y = poll[1];
				if (A[x][y] == 1) {
					return count - 1;
				}
				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX >= A.length || newY >= A[0].length
							|| visited.contains(newX + "/" + newY) || A[newX][newY] == -1)
						continue;
					q.offer(new int[] { newX, newY });
					visited.add(newX + "/" + newY);
				}
			}
			count++;
		}
		return 0;
	}

	public static void populateQueue(int x, int y, int[][] A, Queue<int[]> q, HashSet<String> visited) {
		if (x < 0 || y < 0 || x >= A.length || y >= A[0].length || visited.contains(x + "/" + y) || A[x][y] == 0
				|| A[x][y] == -1)
			return;

		q.offer(new int[] { x, y });
		visited.add(x + "/" + y);
		A[x][y] = -1;
		populateQueue(x - 1, y, A, q, visited);
		populateQueue(x + 1, y, A, q, visited);
		populateQueue(x, y - 1, A, q, visited);
		populateQueue(x, y + 1, A, q, visited);
	}

}
