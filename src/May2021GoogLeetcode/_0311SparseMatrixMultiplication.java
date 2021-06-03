package May2021GoogLeetcode;

public class _0311SparseMatrixMultiplication {

	public static void main(String[] args) {
		System.out.println(multiply(new int[][] { new int[] { 1, 0, 0 }, new int[] { -1, 0, 3 } },
				new int[][] { new int[] { 7, 0, 0 }, new int[] { 0, 0, 0 }, new int[] { 0, 0, 1 } }));
	}

	public static int[][] multiply(int[][] A, int[][] B) {
		int outRow = A.length;
		int outCol = B[0].length;
		int commonRow = A[0].length;
		int[][] out = new int[outRow][outCol];
		for (int i = 0; i < outRow; i++) {
			for (int j = 0; j < outCol; j++) {
				for (int k = 0; k < commonRow; k++) {
					out[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return out;
	}
}
