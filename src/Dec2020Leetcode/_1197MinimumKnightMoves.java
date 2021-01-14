package Dec2020Leetcode;

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
		x= Math.abs(x);
		y = Math.abs(y);
		HashSet<String> visited = new HashSet<String>();
		int[][] DIRECTIONS = new int[][] { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 },
				{ 2, -1 } };
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0));
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair p = q.poll();
				int curX = p.x;
				int curY = p.y;
				if (!visited.contains(curX + "," + curY)) {
					if (curX == x && curY == y)
						return level;

					visited.add(curX + "," + curY);
					for (int[] d : DIRECTIONS) {
						int newX = curX + d[0];
						int newY = curY + d[1];
						if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
							q.add(new Pair(newX, newY));
						}
					}
				}
			}
			level++;

		}
		return -1;
	}

}
