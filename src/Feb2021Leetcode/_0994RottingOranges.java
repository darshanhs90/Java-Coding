package Feb2021Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0994RottingOranges {
	public static void main(String[] args) {
		System.out.println(
				orangesRotting(new int[][] { new int[] { 2, 1, 1 }, new int[] { 1, 1, 0 }, new int[] { 0, 1, 1 } }));
		System.out.println(
				orangesRotting(new int[][] { new int[] { 2, 1, 1 }, new int[] { 0, 1, 1 }, new int[] { 1, 0, 1 } }));

		System.out.println(orangesRotting(new int[][] { new int[] { 0, 2 } }));
	}

	public static int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		Queue<int[]> rottenOranges = new LinkedList<int[]>();
		HashSet<String> visited = new HashSet<String>();
		int freshOranges = 0;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					rottenOranges.add(new int[] { i, j });
					visited.add(i + "/" + j);
				} else if (grid[i][j] == 1) {
					freshOranges++;
				}
			}
		}

		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		while (!rottenOranges.isEmpty() && freshOranges > 0) {
			int size = rottenOranges.size();
			for (int i = 0; i < size; i++) {
				int[] pt = rottenOranges.poll();
				int x = pt[0];
				int y = pt[1];
				if (grid[x][y] == 1) {
					freshOranges--;
				}

				if (freshOranges == 0)
					return count;

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 1
							&& !visited.contains(newX + "/" + newY)) {
						rottenOranges.offer(new int[] { newX, newY });
						visited.add(newX + "/" + newY);
					}
				}
			}
			count++;
		}

		return freshOranges == 0 ? count : -1;
	}
}
