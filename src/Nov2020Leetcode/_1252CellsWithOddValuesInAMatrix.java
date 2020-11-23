package Nov2020Leetcode;

public class _1252CellsWithOddValuesInAMatrix {
	public static void main(String[] args) {
		System.out.println(oddCells(2, 3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 1 } }));
		System.out.println(oddCells(2, 2, new int[][] { new int[] { 1, 1 }, new int[] { 0, 0 } }));
	}

	public static int oddCells(int n, int m, int[][] indices) {
		int[] rowArr = new int[n];
		int[] colArr = new int[m];

		for (int i = 0; i < indices.length; i++) {
			int row = indices[i][0];
			int col = indices[i][1];
			rowArr[row]++;
			colArr[col]++;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((rowArr[i] + colArr[j]) % 2 != 0) {
					count++;
				}
			}
		}
		return count;
	}
}
