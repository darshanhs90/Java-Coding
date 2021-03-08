package Feb2021Leetcode;

public class _0311SparseMatrixMultiplication {

	public static void main(String[] args) {
		System.out.println(multiply(new int[][] { new int[] { 1, 0, 0 }, new int[] { -1, 0, 3 } },
				new int[][] { new int[] { 7, 0, 0 }, new int[] { 0, 0, 0 }, new int[] { 0, 0, 1 } }));
	}

	public static int[][] multiply(int[][] A, int[][] B) {
		int newRows = A.length;
		int newCols = B[0].length;
		int commonCount = A[0].length;

		int[][] out = new int[newRows][newCols];
		for (int i = 0; i < newRows; i++) {
			for (int j = 0; j < newCols; j++) {
				for (int k = 0; k < commonCount; k++) {
					out[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return out;
	}
}
