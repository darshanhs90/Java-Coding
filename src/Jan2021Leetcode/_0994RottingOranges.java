package Jan2021Leetcode;

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
		int noOfFreshOranges = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					noOfFreshOranges++;
				else if (grid[i][j] == 2) {
					q.offer(new Pair(i, j));
					visited.add(i + "," + j);
				}
			}
		}

		if (noOfFreshOranges == 0)
			return 0;

		int dirs[][] = new int[][] { new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, 1 }, new int[] { 0, -1 } };

		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair p = q.poll();
				int x = p.x;
				int y = p.y;
				for (int j = 0; j < dirs.length; j++) {
					int newX = dirs[j][0] + x;
					int newY = dirs[j][1] + y;
					if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length
							|| visited.contains(newX + "," + newY) || grid[newX][newY] != 1)
						continue;
					visited.add(newX + "," + newY);
					q.offer(new Pair(newX, newY));
					noOfFreshOranges--;
					if (noOfFreshOranges == 0)
						return count + 1;
				}
			}
			count++;
		}
		return -1;
	}
}
