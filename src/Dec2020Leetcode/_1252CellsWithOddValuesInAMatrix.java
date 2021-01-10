package Dec2020Leetcode;

public class _1252CellsWithOddValuesInAMatrix {
	public static void main(String[] args) {
		System.out.println(oddCells(2, 3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 1 } }));
		System.out.println(oddCells(2, 2, new int[][] { new int[] { 1, 1 }, new int[] { 0, 0 } }));
	}

	public static int oddCells(int n, int m, int[][] indices) {
		int[] rows = new int[n];
		int[] cols = new int[m];
		for (int[] index : indices) {
			rows[index[0]]++;
			cols[index[1]]++;
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((rows[i] + cols[j]) % 2 != 0)
					count++;
			}
		}
		return count;
	}
}
