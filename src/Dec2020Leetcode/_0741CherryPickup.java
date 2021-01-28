package Dec2020Leetcode;

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

		int x, y;
		List<int[]> path;
		int count = Integer.MAX_VALUE;

		public Pair(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.path = new ArrayList<int[]>();
			this.path.add(new int[] { x, y });
		}
	}

	public static int cherryPickup(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0][0] == -1 || grid[grid.length - 1][grid[0].length - 1] == -1)
			return -1;
		int rows = grid.length, cols = grid[0].length;
		Pair[][] pairArr = new Pair[grid.length][grid[0].length];
		Pair startPoint = new Pair(0, 0, grid[0][0]);
		pairArr[0][0] = startPoint;
		// populate first col
		for (int i = 1; i < pairArr.length; i++) {
			if (grid[i][0] == -1 || pairArr[i - 1][0].count == -1) {
				pairArr[i][0] = new Pair(i, 0, -1);
			} else {
				pairArr[i][0] = new Pair(i, 0, pairArr[i - 1][0].count + grid[i][0]);
				pairArr[i][0].path.addAll(pairArr[i - 1][0].path);
			}
		}

		// populate first row
		for (int i = 1; i < pairArr[0].length; i++) {
			if (grid[0][i] == -1 || pairArr[0][i - 1].count == -1) {
				pairArr[0][i] = new Pair(0, i, -1);
			} else {
				pairArr[0][i] = new Pair(0, i, pairArr[0][i - 1].count + grid[0][i]);
				pairArr[0][i].path.addAll(pairArr[0][i - 1].path);
			}
		}

		for (int i = 1; i < pairArr.length; i++) {
			for (int j = 1; j < pairArr[0].length; j++) {
				Pair p = new Pair(i, j, -1);
				if (grid[i][j] == -1) {
					pairArr[i][j] = p;
					continue;
				}

				Pair upPair = pairArr[i - 1][j];
				Pair leftPair = pairArr[i][j - 1];

				if (upPair.count == -1 && leftPair.count == -1) {
					pairArr[i][j] = p;
				} else if (upPair.count == -1) {
					p.count = leftPair.count + grid[i][j];
					p.path.addAll(leftPair.path);
					pairArr[i][j] = p;
				} else if (leftPair.count == -1) {
					p.count = upPair.count + grid[i][j];
					p.path.addAll(upPair.path);
					pairArr[i][j] = p;
				} else {
					if (leftPair.count > upPair.count) {
						p.count = leftPair.count + grid[i][j];
						p.path.addAll(leftPair.path);
						pairArr[i][j] = p;
					} else {
						p.count = upPair.count + grid[i][j];
						p.path.addAll(upPair.path);
						pairArr[i][j] = p;
					}
				}
			}
		}

		if (pairArr[rows - 1][cols - 1].count == -1)
			return -1;
		System.out.println(pairArr[rows - 1][cols - 1].count);
		List<int[]> lst = pairArr[rows - 1][cols - 1].path;
		for (int[] pt : lst) {
			grid[pt[0]][pt[1]] = 0;
		}
		int forwardCount = pairArr[rows - 1][cols - 1].count;

		pairArr = new Pair[grid.length][grid[0].length];
		startPoint = new Pair(rows - 1, cols - 1, 0);
		pairArr[rows - 1][cols - 1] = startPoint;
		// populate last col
		for (int i = rows - 2; i >= 0; i--) {
			if (grid[i][cols - 1] == -1 || pairArr[i + 1][cols - 1].count == -1) {
				pairArr[i][cols - 1] = new Pair(i, cols - 1, -1);
			} else {
				pairArr[i][cols - 1] = new Pair(i, cols - 1, pairArr[i + 1][cols - 1].count + grid[i][cols - 1]);
				pairArr[i][cols - 1].path.addAll(pairArr[i + 1][cols - 1].path);
			}
		}

		// populate last row
		for (int i = cols - 2; i >= 0; i--) {
			if (grid[rows - 1][i] == -1 || pairArr[rows - 1][i + 1].count == -1) {
				pairArr[rows - 1][i] = new Pair(rows - 1, i, -1);
			} else {
				pairArr[rows - 1][i] = new Pair(rows - 1, i, pairArr[rows - 1][i + 1].count + grid[rows - 1][i]);
				pairArr[rows - 1][i].path.addAll(pairArr[rows - 1][i + 1].path);
			}
		}

		for (int i = pairArr.length - 2; i >= 0; i--) {
			for (int j = pairArr[0].length - 2; j >= 0; j--) {
				Pair p = new Pair(i, j, -1);
				if (grid[i][j] == -1) {
					pairArr[i][j] = p;
					continue;
				}

				Pair upPair = pairArr[i + 1][j];
				Pair leftPair = pairArr[i][j + 1];

				if (upPair.count == -1 && leftPair.count == -1) {
					pairArr[i][j] = p;
				} else if (upPair.count == -1) {
					p.count = leftPair.count + grid[i][j];
					p.path.addAll(leftPair.path);
					pairArr[i][j] = p;
				} else if (leftPair.count == -1) {
					p.count = upPair.count + grid[i][j];
					p.path.addAll(upPair.path);
					pairArr[i][j] = p;
				} else {
					if (leftPair.count > upPair.count) {
						p.count = leftPair.count + grid[i][j];
						p.path.addAll(leftPair.path);
						pairArr[i][j] = p;
					} else {
						p.count = upPair.count + grid[i][j];
						p.path.addAll(upPair.path);
						pairArr[i][j] = p;
					}
				}
			}
		}
		int backwardCount = pairArr[0][0].count;
		return forwardCount + backwardCount;
	}
}
