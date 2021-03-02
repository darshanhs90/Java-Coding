package DoordashPrep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _1197MinimumKnightMoves {
	public static void main(String[] args) {
		System.out.println(minKnightMoves(2, 1));
		System.out.println(minKnightMoves(5, 5));
	}

	public static int minKnightMoves(int x, int y) {
		x = Math.abs(x);
		y = Math.abs(y);
		int count = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		HashSet<String> visited = new HashSet<String>();
		q.offer(new int[] { 0, 0 });
		visited.add(0 + "/" + 0);
		int[][] dirs = new int[][] { new int[] { -2, -1 }, new int[] { -1, -2 }, new int[] { -1, 2 },
				new int[] { -2, 1 }, new int[] { 2, -1 }, new int[] { 1, -2 }, new int[] { 1, 2 },
				new int[] { 2, 1 }, };

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int currX = arr[0];
				int currY = arr[1];
				if (currX == x && currY == y)
					return count;

				for (int j = 0; j < dirs.length; j++) {
					int newX = currX + dirs[j][0];
					int newY = currY + dirs[j][1];

					if (newX < -1 || newY < -1 || visited.contains(newX + "/" + newY))
						continue;
					q.offer(new int[] { newX, newY });
					visited.add(newX + "/" + newY);

				}
			}
			count++;
		}
		return 0;
	}

}
