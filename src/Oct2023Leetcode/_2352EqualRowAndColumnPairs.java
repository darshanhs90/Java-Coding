package Oct2023Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _2352EqualRowAndColumnPairs {
	public static void main(String[] args) {
		System.out.println(
				equalPairs(new int[][] { new int[] { 3, 2, 1 }, new int[] { 1, 7, 6 }, new int[] { 2, 7, 7 }, }));
		System.out.println(equalPairs(new int[][] { new int[] { 3, 1, 2, 2 }, new int[] { 1, 4, 4, 5 },
				new int[] { 2, 4, 2, 2 }, new int[] { 2, 4, 2, 2 }, }));
	}

	public static int equalPairs(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		HashMap<String, Integer> rowMap = new HashMap<String, Integer>();
		HashMap<String, Integer> colMap = new HashMap<String, Integer>();
		for (int i = 0; i < grid.length; i++) {
			StringBuilder rowString = new StringBuilder();
			StringBuilder colString = new StringBuilder();
			for (int j = 0; j < grid[i].length; j++) {
				rowString.append(grid[i][j] + ",");
				colString.append(grid[j][i] + ",");
			}
			rowMap.compute(rowString.toString(), (k, v) -> v == null ? 1 : v + 1);
			colMap.compute(colString.toString(), (k, v) -> v == null ? 1 : v + 1);
		}
		int count = 0;
		for (Map.Entry<String, Integer> entry : rowMap.entrySet()) {
			int entryValue = entry.getValue();
			String entryKey = entry.getKey();
			if (colMap.containsKey(entryKey)) {
				count += entryValue * colMap.get(entryKey);
			}
		}
		return count;
	}
}
