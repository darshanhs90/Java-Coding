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

		HashSet<String> visited = new HashSet<String>();
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0 });
		visited.add("0,0");
		int count = 0;
		int[][] dirs = new int[][] { new int[] { -2, -1 }, new int[] { -1, -2 }, new int[] { -1, 2 },
				new int[] { -2, 1 }, new int[] { 1, -2 }, new int[] { 1, 2 }, new int[] { 2, -1 }, new int[] { 2, 1 } };

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int xVal = arr[0];
				int yVal = arr[1];
				if (xVal == x && yVal == y)
					return count;

				for (int j = 0; j < dirs.length; j++) {
					int newX = xVal + dirs[j][0];
					int newY = yVal + dirs[j][1];

					if (newX < -1 || newY < -1 || visited.contains(newX + "," + newY))
						continue;

					q.offer(new int[] { newX, newY });
					visited.add(newX + "," + newY);
				}
			}
			count++;
		}
		return count;
	}

}
