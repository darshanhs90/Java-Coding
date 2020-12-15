package Nov2020_GoogPrep;

public class _076RangeSumQuery2DMutable {

	public static void main(String[] args) {
		NumMatrix numMatrix = new NumMatrix(new int[][] { new int[] { 3, 0, 1, 4, 2 }, new int[] { 5, 6, 3, 2, 1 },
				new int[] { 1, 2, 0, 1, 5 }, new int[] { 4, 1, 0, 1, 7 }, new int[] { 1, 0, 3, 0, 5 }, });
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // 8
		numMatrix.update(3, 2, 2);
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // 10
	}

	static class NumMatrix {
		int[][] fwMatrix;
		int rows, cols;

	    private int lsb(int n) {
	        // the line below allows us to directly capture the right most non-zero bit of a number
	        return n & (-n);
	    }
		
		public void updateBIT(int row, int col, int val) {
			for (int i = row; i <= rows; i += lsb(i)) {
				for (int j = col; j <= cols; j += lsb(j)) {
					fwMatrix[i][j] += val;
				}
			}
		}

		public int queryBIT(int row, int col) {
			int val = 0;
			for (int i = row; i > 0; i -= lsb(i)) {
				for (int j = col; j > 0; j -= lsb(j)) {
					val += fwMatrix[i][j];
				}
			}
			return val;
		}

		public void buildBIT(int[][] matrix) {
			for (int i = 1; i <= rows; i++) {
				for (int j = 1; j <= cols; j++) {
					updateBIT(i, j, matrix[i - 1][j - 1]);
				}
			}
		}
		
		public NumMatrix(int[][] matrix) {
	        rows = matrix.length;
	        if (rows == 0) return;
	        cols = matrix[0].length;
			fwMatrix = new int[rows + 1][];
			for (int i = 1; i <= rows; i++) {
				fwMatrix[i] = new int[cols + 1];
			}
			buildBIT(matrix);
		}
		
		public void update(int row, int col, int val) {
			int currVal = sumRegion(row, col, row, col);
			int updateVal = val - currVal;
			updateBIT(row + 1, col + 1, updateVal);
		}
		
		public int sumRegion(int row1, int col1, int row2, int col2) {
			row1++;
			col1++;
			row2++;
			col2++;
			int a = queryBIT(row2, col2);
			int b = queryBIT(row1 - 1, col1 - 1);
			int c = queryBIT(row2, col1 - 1);
			int d = queryBIT(row1 - 1, col2);
			return (a + b) - (c + d);
		}
	}

}
