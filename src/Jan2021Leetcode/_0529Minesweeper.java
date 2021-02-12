package Jan2021Leetcode;

import java.util.Arrays;
import java.util.HashSet;
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
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		}

		Queue<int[]> q = new LinkedList<int[]>();
		HashSet<String> visited = new HashSet<String>();
		q.offer(new int[] { click[0], click[1] });
		visited.add(click[0] + "," + click[1]);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] pollVal = q.poll();
				int x = pollVal[0];
				int y = pollVal[1];
				int noOfMines = getNumberOfMines(x, y, board);
				if (noOfMines == 0) {
					// add neighbors
					board[x][y] = 'B';
					addNeighbors(x, y, board, q, visited);
				} else {
					board[x][y] = (char) ('0' + noOfMines);
				}
			}
		}
		return board;
	}

	public static void addNeighbors(int x, int y, char[][] board, Queue<int[]> q, HashSet<String> visited) {
		int dirs[][] = new int[][] { new int[] { -1, -1 }, new int[] { -1, 0 }, new int[] { -1, +1 },
				new int[] { 0, -1 }, new int[] { 0, +1 }, new int[] { +1, -1 }, new int[] { +1, 0 },
				new int[] { +1, +1 } };

		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];
			if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length
					&& !visited.contains(newX + "," + newY)) {
				q.offer(new int[] { newX, newY });
				visited.add(newX + "," + newY);
			}
		}
	}

	public static int getNumberOfMines(int x, int y, char[][] board) {
		int count = 0;
		if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == 'M')
			count++;

		if (x - 1 >= 0 && y >= 0 && board[x - 1][y] == 'M')
			count++;

		if (x - 1 >= 0 && y + 1 < board[0].length && board[x - 1][y + 1] == 'M')
			count++;

		if (x >= 0 && y - 1 >= 0 && board[x][y - 1] == 'M')
			count++;

		if (x >= 0 && y + 1 < board[0].length && board[x][y + 1] == 'M')
			count++;

		if (x + 1 < board.length && y - 1 >= 0 && board[x + 1][y - 1] == 'M')
			count++;

		if (x + 1 < board.length && y >= 0 && board[x + 1][y] == 'M')
			count++;

		if (x + 1 < board.length && y + 1 < board[0].length && board[x + 1][y + 1] == 'M')
			count++;
		return count;
	}


}
