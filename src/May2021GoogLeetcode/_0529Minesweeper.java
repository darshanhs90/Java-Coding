package May2021GoogLeetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _0529Minesweeper {
	public static void main(String[] args) {
		char[][] out = updateBoard(
				new char[][] { new char[] { 'E', 'E', 'E', 'E', 'E' }, new char[] { 'E', 'E', 'M', 'E', 'E' },
						new char[] { 'E', 'E', 'E', 'E', 'E' }, new char[] { 'E', 'E', 'E', 'E', 'E' } },
				new int[] { 3, 0 });
		printOut(out);
		out = updateBoard(
				new char[][] { new char[] { 'B', '1', 'E', '1', 'B' }, new char[] { 'B', '1', 'M', '1', 'B' },
						new char[] { 'B', '1', '1', '1', 'B' }, new char[] { 'B', 'B', 'B', 'B', 'B' } },
				new int[] { 1, 2 });
		printOut(out);

	}

	public static void printOut(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println("***************");
	}

	public static char[][] updateBoard(char[][] board, int[] click) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(click);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];

				if (board[x][y] == 'M') {
					board[x][y] = 'X';
					continue;
				} else if (board[x][y] == 'E') {
					int noOfNeighbors = getMines(x, y, board);
					if (noOfNeighbors == 0) {
						board[x][y] = 'B';
						addNeighbors(x, y, board, q);
					} else {
						board[x][y] = (char) ((char) '0' + noOfNeighbors);
					}
				}
			}
		}
		return board;
	}

	public static void addNeighbors(int x, int y, char[][] board, Queue<int[]> q) {
		int[][] dirs = new int[][] { new int[] { -1, -1 }, new int[] { -1, 0 }, new int[] { -1, 1 },
				new int[] { 0, -1 }, new int[] { 0, 1 }, new int[] { 1, -1 }, new int[] { 1, 0 }, new int[] { 1, 1 } };
		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];

			if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length)
				continue;
			q.offer(new int[] { newX, newY });
		}
	}

	public static int getMines(int x, int y, char[][] board) {
		int[][] dirs = new int[][] { new int[] { -1, -1 }, new int[] { -1, 0 }, new int[] { -1, 1 },
				new int[] { 0, -1 }, new int[] { 0, 1 }, new int[] { 1, -1 }, new int[] { 1, 0 }, new int[] { 1, 1 } };
		int count = 0;
		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];

			if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length)
				continue;
			if (board[newX][newY] == 'M')
				count++;
		}
		return count;
	}

}
