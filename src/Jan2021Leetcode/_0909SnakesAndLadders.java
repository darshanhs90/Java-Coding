package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0909SnakesAndLadders {
	public static void main(String[] args) {
		System.out.println(snakesAndLadders(
				new int[][] { new int[] { -1, -1, -1, -1, -1, -1 }, new int[] { -1, -1, -1, -1, -1, -1 },
						new int[] { -1, -1, -1, -1, -1, -1 }, new int[] { -1, 35, -1, -1, 13, -1 },
						new int[] { -1, -1, -1, -1, -1, -1 }, new int[] { -1, 15, -1, -1, -1, -1 } }));
	}

	public static int snakesAndLadders(int[][] board) {
		List<Integer> list = convertBoard(board);
		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		visited.add(1);
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int currVal = q.poll();
				if (currVal == list.size() - 1)
					return count;

				for (int j = 1; j <= 6; j++) {
					int nextVal = currVal + j;
					if (nextVal >= list.size())
						continue;

					if (list.get(nextVal) != -1) {
						nextVal = list.get(nextVal);
					}

					if (!visited.contains(nextVal)) {
						q.offer(nextVal);
						visited.add(nextVal);
					}
				}
			}
			count++;
		}
		return -1;
	}

	private static List<Integer> convertBoard(int[][] board) {
		List<Integer> list = new ArrayList<Integer>();
		boolean flipCols = false;
		list.add(0);
		for (int i = board.length - 1; i >= 0; i--) {
			if (!flipCols) {
				for (int j = 0; j < board[0].length; j++) {
					list.add(board[i][j]);
				}
			} else {
				for (int j = board[0].length - 1; j >= 0; j--) {
					list.add(board[i][j]);
				}
			}
			flipCols = !flipCols;
		}
		return list;
	}

}
