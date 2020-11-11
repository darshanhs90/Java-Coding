package Leetcode2020Nov;

public class _0566ReshapeTheMatrix {
	public static void main(String[] args) {
		System.out.println(matrixReshape(new int[][] { new int[] { 1, 2 }, new int[] { 13, 4 } }, 1, 4));
	}

	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		if (r * c != nums.length * nums[0].length)
			return nums;

		int[][] newOut = new int[r][c];
		int rowIndex = 0;
		int colIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				if (colIndex >= c) {
					colIndex = 0;
					rowIndex++;
				}
				newOut[rowIndex][colIndex] = nums[i][j];
				colIndex++;
			}
		}
		return newOut;
	}
}
