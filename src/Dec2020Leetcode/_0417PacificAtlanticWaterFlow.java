package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0417PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		System.out.println(pacificAtlantic(new int[][] { new int[] { 1, 2, 2, 3, 5 }, new int[] { 3, 2, 3, 4, 4 },
				new int[] { 2, 4, 5, 3, 1 }, new int[] { 6, 7, 1, 4, 5 }, new int[] { 5, 1, 1, 2, 4 } }));
	}

	static boolean canReachTop, canReachBottom, canReachLeft, canReachRight;

	public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (matrix == null || matrix.length == 0)
			return output;
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] canReach = new int[rows][cols];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				boolean[][] visited = new boolean[rows][cols];
				canReachTop = false;
				canReachBottom = false;
				canReachLeft = false;
				canReachRight = false;
				if (canReachDestination(i, j, matrix, canReach, visited)) {
					output.add(new ArrayList<Integer>(Arrays.asList(i, j)));
				}

			}
		}
		return output;
	}

	public static boolean canReachDestination(int x, int y, int[][] matrix, int[][] canReach, boolean[][] visited) {
		if (x == 0) {
			canReachTop = true;
		}
		if (x == matrix.length - 1) {
			canReachBottom = true;
		}
		if (y == 0) {
			canReachLeft = true;
		}
		if (y == matrix[0].length - 1) {
			canReachRight = true;
		}

		int dirs[][] = new int[][] { new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, 1 }, new int[] { 0, -1 } };

		boolean canReachBoth = false;
		int currVal = matrix[x][y];
		visited[x][y] = true;

		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];
			if (newX >= 0 && newY >= 0 && newX <= matrix.length - 1 && newY <= matrix[0].length - 1
					&& !visited[newX][newY] && matrix[newX][newY] <= currVal) {
				canReachDestination(newX, newY, matrix, canReach, visited);
			}
		}

		canReachBoth = canReachTop && canReachBottom || canReachTop && canReachRight || canReachLeft && canReachRight
				|| canReachLeft && canReachBottom;
		visited[x][y] = false;
		return canReachBoth;
	}

}
