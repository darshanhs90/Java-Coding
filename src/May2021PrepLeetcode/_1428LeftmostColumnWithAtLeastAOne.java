package May2021PrepLeetcode;

import java.util.List;

public class _1428LeftmostColumnWithAtLeastAOne {
	public static void main(String[] args) {

	}

	interface BinaryMatrix {
		public int get(int row, int col);

		public List<Integer> dimensions();
	};

	public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dims = binaryMatrix.dimensions();
		int rows = dims.get(0);
		int cols = dims.get(1);

		int currRow = 0, currCol = cols - 1;
		while (currRow < rows && currCol >= 0) {
			if (binaryMatrix.get(currRow, currCol) == 1)
				currCol--;
			else
				currRow++;
		}

		return currCol == cols - 1 ? -1 : currCol + 1;
	}
}
