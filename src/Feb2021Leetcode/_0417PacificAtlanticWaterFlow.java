package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0417PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		System.out.println(pacificAtlantic(new int[][] { new int[] { 1, 2, 2, 3, 5 }, new int[] { 3, 2, 3, 4, 4 },
				new int[] { 2, 4, 5, 3, 1 }, new int[] { 6, 7, 1, 4, 5 }, new int[] { 5, 1, 1, 2, 4 } }));
	}

	static boolean canReachTop, canReachLeft, canReachRight, canReachBottom;

	public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				canReachTop = false;
				canReachLeft = false;
				canReachRight = false;
				canReachBottom = false;
				HashSet<String> set = new HashSet<String>();
				set.add(i + "/" + j);
				dfs(i, j, matrix[i][j], matrix, set);
				if ((canReachLeft && canReachBottom) || (canReachLeft && canReachRight)
						|| (canReachTop && canReachBottom) || (canReachTop && canReachRight)) {
					out.add(new ArrayList<Integer>(Arrays.asList(i, j)));
				}
			}
		}
		return out;
	}

	public static void dfs(int x, int y, int currVal, int[][] matrix, HashSet<String> visited) {
		if (x == 0) {
			canReachTop = true;
		}
		if (y == 0) {
			canReachLeft = true;
		}
		if (x == matrix.length - 1) {
			canReachBottom = true;
		}
		if (y == matrix[0].length - 1) {
			canReachRight = true;
		}

		if ((canReachLeft && canReachBottom) || (canReachLeft && canReachRight) || (canReachTop && canReachBottom)
				|| (canReachTop && canReachRight)) {
			return;
		}

		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];
			if (newX >= 0 && newY >= 0 && newX < matrix.length && newY < matrix[0].length
					&& !visited.contains(newX + "/" + newY) && matrix[newX][newY] <= currVal) {
				visited.add(newX + "/" + newY);
				dfs(newX, newY, matrix[newX][newY], matrix, visited);
				visited.remove(newX + "/" + newY);
			}
		}
	}

}
