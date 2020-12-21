package Nov2020_UberPrep;

import java.util.LinkedList;
import java.util.Queue;

public class _030ShortestBridge {

	public static void main(String[] args) {
		System.out.println(shortestBridge(new int[][] { new int[] { 0, 1 }, new int[] { 1, 0 } }));
		System.out.println(
				shortestBridge(new int[][] { new int[] { 0, 1, 0 }, new int[] { 0, 0, 0 }, new int[] { 0, 0, 1 } }));

		System.out.println(shortestBridge(new int[][] { new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 0, 0, 0, 1 },
				new int[] { 1, 0, 1, 0, 1 }, new int[] { 1, 0, 0, 0, 1 }, new int[] { 1, 1, 1, 1, 1 } }));
	}

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int shortestBridge(int[][] A) {
		if (A == null || A.length == 0)
			return 0;
		boolean islandFound = false;
		Queue<Pair> q = new LinkedList<Pair>();
		for (int i = 0; i < A.length; i++) {
			if (islandFound)
				break;
			for (int j = 0; j < A.length; j++) {
				if (A[i][j] == 1 && !islandFound) {
					dfs(i, j, A, q);
					islandFound = true;
					break;
				}
			}
		}
		int dirs[][] = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		int distance = 0;
		boolean[][] visited = new boolean[A.length][A[0].length];
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair p = q.poll();
				for (int j = 0; j < dirs.length; j++) {

					int newX = p.x + dirs[j][0];
					int newY = p.y + dirs[j][1];
					if (newX < 0 || newY < 0 || newX > A.length - 1 || newY > A[0].length - 1 || A[newX][newY] == 2
							|| visited[newX][newY]) {
						continue;
					}
					if (A[newX][newY] == 1)
						return distance;
					visited[newX][newY] = true;
					q.offer(new Pair(newX, newY));
				}
			}
			distance++;
		}

		return -1;
	}

	public static void dfs(int x, int y, int[][] A, Queue<Pair> q) {
		if (x < 0 || y < 0 || x > A.length - 1 || y > A[0].length - 1 || A[x][y] != 1)
			return;
		A[x][y] = 2;
		q.offer(new Pair(x, y));
		dfs(x - 1, y, A, q);
		dfs(x + 1, y, A, q);
		dfs(x, y - 1, A, q);
		dfs(x, y + 1, A, q);
	}

}
