package Mar2021Leetcode;

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
		
	}

}
