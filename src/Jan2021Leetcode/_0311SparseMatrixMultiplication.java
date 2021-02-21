package Jan2021Leetcode;

public class _0311SparseMatrixMultiplication {

	public static void main(String[] args) {
		System.out.println(multiply(new int[][] { new int[] { 1, 0, 0 }, new int[] { -1, 0, 3 } },
				new int[][] { new int[] { 7, 0, 0 }, new int[] { 0, 0, 0 }, new int[] { 0, 0, 1 } }));
	}

	public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                for (int j = 0; j < nB; j++) {
                         C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;  
	}
}
