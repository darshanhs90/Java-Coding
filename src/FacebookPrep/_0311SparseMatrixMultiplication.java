package FacebookPrep;

public class _0311SparseMatrixMultiplication {

	public static void main(String[] args) {
		System.out.println(multiply(new int[][] { new int[] { 1, 0, 0 }, new int[] { -1, 0, 3 } },
				new int[][] { new int[] { 7, 0, 0 }, new int[] { 0, 0, 0 }, new int[] { 0, 0, 1 } }));
	}

	public static int[][] multiply(int[][] A, int[][] B) {
		int outRows = A.length;
		int commonCount = A[0].length;
		int outCols = B[0].length;

		int[][] out = new int[outRows][outCols];
		for (int i = 0; i < outRows; i++) {
			for (int j = 0; j < outCols; j++) {
				for (int k = 0; k < commonCount; k++) {
					out[i][j] += A[i][k] * B[k][j];
				}
			}
		}

		return out;
	}
}
