package April2021Leetcode;

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
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					Queue<int[]> q = new LinkedList<int[]>();
					dfs(i, j, A, q);
					return bfs(A, q);
				}
			}
		}
		return 0;
	}

	public static int bfs(int[][] A, Queue<int[]> q) {
		HashSet<String> visited = new HashSet<String>();
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int currX = arr[0];
				int currY = arr[1];
				if (A[currX][currY] == 1)
					return count - 1;

				for (int j = 0; j < dirs.length; j++) {
					int newX = currX + dirs[j][0];
					int newY = currY + dirs[j][1];

					if (newX < 0 || newY < 0 || newX >= A.length || newY >= A[0].length || A[newX][newY] == -1
							|| visited.contains(newX + "/" + newY))
						continue;
					q.offer(new int[] { newX, newY });
					visited.add(newX + "/" + newY);
				}
			}
			count++;
		}
		return 0;
	}

	public static void dfs(int x, int y, int[][] A, Queue<int[]> q) {
		if (x < 0 || y < 0 | x >= A.length || y >= A[0].length || A[x][y] != 1)
			return;
		A[x][y] = -1;
		q.offer(new int[] { x, y });
		dfs(x - 1, y, A, q);
		dfs(x + 1, y, A, q);
		dfs(x, y - 1, A, q);
		dfs(x, y + 1, A, q);
	}

}
