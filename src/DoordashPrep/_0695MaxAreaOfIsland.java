package DoordashPrep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0695MaxAreaOfIsland {

	public static void main(String[] args) {
		System.out.println(maxAreaOfIsland(new int[][] { new int[] { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				new int[] { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				new int[] { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				new int[] { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));
		System.out.println(maxAreaOfIsland(new int[][] { new int[] { 0, 0, 0, 0, 0, 0, 0, 0 } }));
	}

	public static int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int maxArea = 0;
		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && !visited.contains(i + "," + j)) {
					maxArea = Math.max(maxArea, dfs(i, j, grid, visited));
				}
			}
		}
		return maxArea;
	}

	public static int dfs(int row, int col, int[][] grid, HashSet<String> visited) {
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		Queue<int[]> q = new LinkedList<int[]>();
		int count = 0;
		q.offer(new int[] { row, col });
		visited.add(row + "," + col);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				count++;
				int x = arr[0];
				int y = arr[1];

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX > grid.length - 1 || newY > grid[0].length - 1
							|| grid[newX][newY] == 0 || visited.contains(newX + "," + newY))
						continue;
					q.offer(new int[] { newX, newY });
					visited.add(newX + "," + newY);
				}
			}
		}
		return count;
	}
}
