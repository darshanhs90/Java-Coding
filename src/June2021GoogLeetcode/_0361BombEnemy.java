package June2021GoogLeetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0361BombEnemy {

	public static void main(String[] args) {
		System.out.println(maxKilledEnemies(new char[][] { new char[] { '0', 'E', '0', '0' },
				new char[] { 'E', '0', 'W', 'E' }, new char[] { '0', 'E', '0', '0' } }));

		System.out.println(maxKilledEnemies(new char[][] { new char[] { 'W', 'W', 'W' }, new char[] { '0', '0', '0' },
				new char[] { 'E', 'E', 'E' } }));

	}

	public static int maxKilledEnemies(char[][] grid) {
		int max = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0') {
					q.offer(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			max = Math.max(max, dfs(arr[0], arr[1], grid));
		}

		return max;
	}

	public static int dfs(int x, int y, char[][] grid) {
		int count = 0;

		int currX = x;
		while (currX >= 0 && grid[currX][y] != 'W') {
			count += grid[currX][y] == 'E' ? 1 : 0;
			currX--;
		}

		currX = x;
		while (currX < grid.length && grid[currX][y] != 'W') {
			count += grid[currX][y] == 'E' ? 1 : 0;
			currX++;
		}

		int currY = y;
		while (currY >= 0 && grid[x][currY] != 'W') {
			count += grid[x][currY] == 'E' ? 1 : 0;
			currY--;
		}

		currY = y;
		while (currY < grid[0].length && grid[x][currY] != 'W') {
			count += grid[x][currY] == 'E' ? 1 : 0;
			currY++;
		}
		return count;
	}
}
