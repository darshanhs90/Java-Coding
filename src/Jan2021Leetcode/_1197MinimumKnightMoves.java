package Jan2021Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _1197MinimumKnightMoves {
	public static void main(String[] args) {
		System.out.println(minKnightMoves(2, 1));
		System.out.println(minKnightMoves(5, 5));
	}

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int minKnightMoves(int x, int y) {
		x = Math.abs(x);
		y = Math.abs(y);
		HashSet<String> visited = new HashSet<String>();
		Queue<Pair> q = new LinkedList<Pair>();
		int[][] dirs = new int[][] { new int[] { -1, -2 }, new int[] { -1, 2 }, new int[] { -2, -1 },
				new int[] { -2, 1 }, new int[] { 1, -2 }, new int[] { 1, 2 }, new int[] { 2, -1 }, new int[] { 2, 1 } };
		q.offer(new Pair(0, 0));
		visited.add("0,0");
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair p = q.poll();
				if (p.x == x && p.y == y)
					return count;
				for (int j = 0; j < dirs.length; j++) {
					int newX = dirs[j][0] + p.x;
					int newY = dirs[j][1] + p.y;

					if (newX >= -1 && newY >= -1 && !visited.contains(newX + "," + newY)) {
						visited.add(newX + "," + newY);
						q.offer(new Pair(newX, newY));
					}
				}
			}
			count++;
		}
		return count;
	}

}
