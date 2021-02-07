package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0417PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		System.out.println(pacificAtlantic(new int[][] { new int[] { 1, 2, 2, 3, 5 }, new int[] { 3, 2, 3, 4, 4 },
				new int[] { 2, 4, 5, 3, 1 }, new int[] { 6, 7, 1, 4, 5 }, new int[] { 5, 1, 1, 2, 4 } }));
	}

	static boolean reachesPacific, reachesAtlantic;

	public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if(matrix == null || matrix.length == 0)
			return output;
		int[][] canReach = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				reachesPacific = false;
				reachesAtlantic = false;
				pacificAtlantic(i, j, matrix, new HashSet<String>(), canReach);
				if (reachesPacific && reachesAtlantic) {
					output.add(new ArrayList<Integer>(Arrays.asList(i, j)));
					canReach[i][j] = 1;
				}
			}
		}
		return output;
	}

	public static void pacificAtlantic(int i, int j, int[][] matrix, HashSet<String> visited, int[][] canReach) {
		if (canReach[i][j] == 1) {
			reachesPacific = true;
			reachesAtlantic = true;
			return;
		}

		if (i < 0 || j < 0 || i == matrix.length || j == matrix[0].length || (reachesPacific && reachesAtlantic)
				|| visited.contains(i + "/" + j))
			return;
		if (i == 0 || j == 0) {
			reachesPacific = true;
		}

		if (i == matrix.length - 1 || j == matrix[0].length - 1) {
			reachesAtlantic = true;
		}

		int currVal = matrix[i][j];
		visited.add(i + "/" + j);

		if (i - 1 >= 0 && matrix[i - 1][j] <= currVal)
			pacificAtlantic(i - 1, j, matrix, visited, canReach);

		if (j - 1 >= 0 && matrix[i][j - 1] <= currVal)
			pacificAtlantic(i, j - 1, matrix, visited, canReach);

		if (i + 1 < matrix.length && matrix[i + 1][j] <= currVal)
			pacificAtlantic(i + 1, j, matrix, visited, canReach);

		if (j + 1 < matrix[0].length && matrix[i][j + 1] <= currVal)
			pacificAtlantic(i, j + 1, matrix, visited, canReach);
	}

}
