package Dec2020Leetcode;

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

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int orangesRotting(int[][] grid) {
		Queue<Pair> q = new LinkedList<Pair>();
		int[][] dirs = new int[][] { new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, 1 }, new int[] { 0, -1 } };
		int noOfFreshOranges = 0;
		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					q.offer(new Pair(i, j));
				} else if (grid[i][j] == 1) {
					noOfFreshOranges++;
				}
			}
		}
		if (noOfFreshOranges == 0)
			return 0;
		int mins = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair p = q.poll();
				visited.add(p.x + "," + p.y);

				int currX = p.x;
				int currY = p.y;

				for (int j = 0; j < dirs.length; j++) {
					int newX = currX + dirs[j][0];
					int newY = currY + dirs[j][1];
					if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 1
							&& !visited.contains(newX + "," + newY)) {
						noOfFreshOranges--;
						q.offer(new Pair(newX, newY));
						visited.add(newX + "," + newY);
					}
				}
			}
			mins++;
		}

		return noOfFreshOranges == 0 ? mins : -1;
	}
}
