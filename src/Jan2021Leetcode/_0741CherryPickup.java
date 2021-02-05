package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0741CherryPickup {
	public static void main(String[] args) {
		System.out.println(
				cherryPickup(new int[][] { new int[] { 0, 1, -1 }, new int[] { 1, 0, -1 }, new int[] { 1, 1, 1 } }));

		System.out.println(
				cherryPickup(new int[][] { new int[] { 1, 1, -1 }, new int[] { 1, -1, 1 }, new int[] { -1, 1, 1 } }));
	}

	static class Pair {
		int count = -1;
		int x, y;
		List<int[]> path;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
			path = new ArrayList<int[]>();
			path.add(new int[] { x, y });
		}

	}

	public static int cherryPickup(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		if (grid[0][0] == -1 || grid[grid.length - 1][grid[0].length - 1] == -1)
			return 0;

		int count1 = populateArr(grid);
		if (count1 == -1)
			return 0;

		int count2 = populateArr(grid);

		return count1 + count2;
	}

	public static int populateArr(int[][] grid) {
		Pair[][] pairArr = new Pair[grid.length][grid[0].length];
		int rows = grid.length;
		int cols = grid[0].length;
		// fill first row

		pairArr[0][0] = new Pair(0, 0);
		pairArr[0][0].count = grid[0][0];

		for (int i = 1; i < cols; i++) {
			if (grid[0][i] == -1 || pairArr[0][i - 1].count == -1) {
				pairArr[0][i] = new Pair(0, i);
			} else {
				pairArr[0][i] = new Pair(0, i);
				pairArr[0][i].count = pairArr[0][i - 1].count + grid[0][i];
				pairArr[0][i].path.addAll(pairArr[0][i - 1].path);
			}
		}

		// fill first col
		for (int i = 1; i < rows; i++) {
			if (grid[i][0] == -1 || pairArr[i - 1][0].count == -1) {
				pairArr[i][0] = new Pair(i, 0);
			} else {
				pairArr[i][0] = new Pair(i, 0);
				pairArr[i][0].count = pairArr[i - 1][0].count + grid[i][0];
				pairArr[i][0].path.addAll(pairArr[i - 1][0].path);
			}
		}

		// forward path
		for (int i = 1; i < pairArr.length; i++) {
			for (int j = 1; j < pairArr[0].length; j++) {
				pairArr[i][j] = new Pair(i, j);
				if (grid[i][j] != -1 && (pairArr[i - 1][j].count != -1 || pairArr[i][j - 1].count != -1)) {
					if (pairArr[i - 1][j].count > pairArr[i][j - 1].count) {
						pairArr[i][j].count = pairArr[i - 1][j].count + grid[i][j];
						pairArr[i][j].path.addAll(pairArr[i - 1][j].path);
					} else {
						pairArr[i][j].count = pairArr[i][j - 1].count + grid[i][j];
						pairArr[i][j].path.addAll(pairArr[i][j - 1].path);
					}
				}
			}
		}

		if (pairArr[rows - 1][cols - 1].count == -1)
			return -1;

		List<int[]> path = pairArr[rows - 1][cols - 1].path;
		for (int i = 0; i < path.size(); i++) {
			grid[path.get(i)[0]][path.get(i)[1]] = 0;
		}

		int forwardCount = pairArr[rows - 1][cols - 1].count;
		return forwardCount;
	}

}