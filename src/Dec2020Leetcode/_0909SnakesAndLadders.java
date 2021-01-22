package Dec2020Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0909SnakesAndLadders {
	public static void main(String[] args) {
		System.out.println(snakesAndLadders(
				new int[][] { new int[] { -1, -1, -1, -1, -1, -1 }, new int[] { -1, -1, -1, -1, -1, -1 },
						new int[] { -1, -1, -1, -1, -1, -1 }, new int[] { -1, 35, -1, -1, 13, -1 },
						new int[] { -1, -1, -1, -1, -1, -1 }, new int[] { -1, 15, -1, -1, -1, -1 } }));
	}

	public static int snakesAndLadders(int[][] board) {
		int count = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		HashSet<Integer> visited = new HashSet<Integer>();
		int n = board.length;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int num = q.poll();
				if (visited.contains(num))
					continue;
				visited.add(num);
				if (num == n * n)
					return count;
				for (int j = 1; j <= 6 && num+ j <= n * n; j++) {
					int next = num + j;
					int value = getBoardValue(board, next);
					if (value > 0)
						next = value;
					if (!visited.contains(next))
						q.offer(next);
				}
			}
			count++;
		}
		return -1;
	}

	private static int getBoardValue(int[][] board, int num) {
		int n = board.length;
		int r = (num - 1) / n;
		int x = n - 1 - r;
		int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
		return board[x][y];
	}
}
