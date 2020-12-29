package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _0052NQueensII {

	public static void main(String[] args) {
		System.out.println(totalNQueens(1));
		System.out.println(totalNQueens(4));
	}

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int totalNQueens(int n) {
		HashSet<Integer> rowSet = new HashSet<Integer>();
		HashSet<Integer> colSet = new HashSet<Integer>();
		HashSet<Pair> diagonalSet = new HashSet<Pair>();
		List<List<String>> output = new ArrayList<List<String>>();
		char[][] grid = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(grid[i], '.');
		}
		solved = false;
		backtrack(0, 0, grid, rowSet, colSet, diagonalSet, output);
		return output.size();
	}

	public static boolean solved = false;

	public static void backtrack(int x, int y, char[][] grid, HashSet<Integer> rowSet, HashSet<Integer> colSet,
			HashSet<Pair> diagonalSet, List<List<String>> output) {
		for (int i = 0; i < grid.length; i++) {
			solved = false;
			if (canPlace(x, i, grid, rowSet, colSet, diagonalSet)) {
				placeQueen(x, i, grid, rowSet, colSet, diagonalSet);
				placeNextQueen(x, i, grid, rowSet, colSet, diagonalSet, output);
				if (!solved) {
					removeQueen(x, i, grid, rowSet, colSet, diagonalSet);
				}
			}
		}
	}

	public static void removeQueen(int x, int y, char[][] grid, HashSet<Integer> rowSet, HashSet<Integer> colSet,
			HashSet<Pair> diagonalSet) {
		rowSet.remove(x);
		colSet.remove(y);
		grid[x][y] = '.';
		int n = grid.length;
		int tempX = x;
		int tempY = y;
		while (tempX < n && tempY < n) {
			remove(diagonalSet, tempX, tempY);
			tempX += 1;
			tempY += 1;
		}
		tempX = x - 1;
		tempY = y - 1;
		while (tempX >= 0 && tempY >= 0) {
			remove(diagonalSet, tempX, tempY);
			tempX -= 1;
			tempY -= 1;
		}

		tempX = x - 1;
		tempY = y + 1;
		while (tempX >= 0 && tempY < n) {
			remove(diagonalSet, tempX, tempY);
			tempX -= 1;
			tempY += 1;
		}

		tempX = x + 1;
		tempY = y - 1;
		while (tempX < n && tempY >= 0) {
			remove(diagonalSet, tempX, tempY);
			tempX += 1;
			tempY -= 1;
		}
	}

	public static void placeNextQueen(int x, int y, char[][] grid, HashSet<Integer> rowSet, HashSet<Integer> colSet,
			HashSet<Pair> diagonalSet, List<List<String>> output) {
		if (x == grid.length - 1) {
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < grid.length; i++) {
				StringBuilder sb = new StringBuilder("");
				for (int j = 0; j < grid[0].length; j++) {
					sb.append(grid[i][j]);
				}
				list.add(sb.toString());
			}
			output.add(list);
			solved = false;
		} else {
			backtrack(x + 1, y, grid, rowSet, colSet, diagonalSet, output);
		}
	}

	public static void placeQueen(int x, int y, char[][] grid, HashSet<Integer> rowSet, HashSet<Integer> colSet,
			HashSet<Pair> diagonalSet) {
		rowSet.add(x);
		colSet.add(y);
		grid[x][y] = 'Q';
		int n = grid.length;
		int tempX = x;
		int tempY = y;
		while (tempX < n && tempY < n) {
			diagonalSet.add(new Pair(tempX, tempY));
			tempX += 1;
			tempY += 1;
		}
		tempX = x - 1;
		tempY = y - 1;
		while (tempX >= 0 && tempY >= 0) {
			diagonalSet.add(new Pair(tempX, tempY));
			tempX -= 1;
			tempY -= 1;
		}

		tempX = x - 1;
		tempY = y + 1;
		while (tempX >= 0 && tempY < n) {
			diagonalSet.add(new Pair(tempX, tempY));
			tempX -= 1;
			tempY += 1;
		}

		tempX = x + 1;
		tempY = y - 1;
		while (tempX < n && tempY >= 0) {
			diagonalSet.add(new Pair(tempX, tempY));
			tempX += 1;
			tempY -= 1;
		}
	}

	public static boolean canPlace(int x, int y, char[][] grid, HashSet<Integer> rowSet, HashSet<Integer> colSet,
			HashSet<Pair> diagonalSet) {
		if (rowSet.contains(x) || colSet.contains(y))
			return false;
		int tempX = x;
		int tempY = y;
		if (contains(diagonalSet, tempX, tempY))
			return false;

		return true;
	}

	public static void remove(HashSet<Pair> diagonalSet, int x, int y) {
		Iterator<Pair> iter = diagonalSet.iterator();
		while (iter.hasNext()) {
			Pair p = iter.next();
			if (p.x == x && p.y == y) {
				diagonalSet.remove(p);
				return;
			}
		}
	}

	public static boolean contains(HashSet<Pair> diagonalSet, int x, int y) {
		Iterator<Pair> iter = diagonalSet.iterator();
		while (iter.hasNext()) {
			Pair p = iter.next();
			if (p.x == x && p.y == y)
				return true;
		}
		return false;
	}

}
