package Dec2020Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0773SlidingPuzzle {
	public static void main(String[] args) {
		System.out.println(slidingPuzzle(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 0, 5 } }));
		System.out.println(slidingPuzzle(new int[][] { new int[] { 1, 2, 3 }, new int[] { 5, 4, 0 } }));
		System.out.println(slidingPuzzle(new int[][] { new int[] { 4, 1, 2 }, new int[] { 5, 0, 3 } }));
		System.out.println(slidingPuzzle(new int[][] { new int[] { 3, 2, 4 }, new int[] { 1, 5, 0 } }));
	}

	static class Pair {
		int[][] arr;

		public Pair(int[][] arr) {
			this.arr = arr;
		}
	}

	public static int slidingPuzzle(int[][] board) {
		HashSet<String> visited = new HashSet<String>();
		int count = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(board));
		visited.add(Arrays.deepToString(board));
		int[][] dirs = new int[][] { new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, 1 }, new int[] { 0, -1 } };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair pollVal = q.poll();
				if (isEqual(pollVal.arr))
					return count;

				int[] zeroIndex = getIndex(pollVal.arr);
				int x = zeroIndex[0];
				int y = zeroIndex[1];
				board = pollVal.arr;

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];
					if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length) {
						int originalValue = board[newX][newY];
						board[x][y] = originalValue;
						board[newX][newY] = 0;

						int[][] newArr = new int[2][3];
						newArr[0] = Arrays.copyOf(board[0], board[0].length);
						newArr[1] = Arrays.copyOf(board[1], board[0].length);

						String str = Arrays.deepToString(newArr);
						if (!visited.contains(str)) {
							q.offer(new Pair(newArr));
							visited.add(str);
						}
						board[x][y] = 0;
						board[newX][newY] = originalValue;
					}
				}
			}
			count++;
		}
		return -1;
	}

	public static int[] getIndex(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0)
					return new int[] { i, j };
			}
		}
		return null;
	}

	public static boolean isEqual(int[][] board) {
		return board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3 && board[1][0] == 4 && board[1][1] == 5
				&& board[1][2] == 0;
	}
}
