package Mar2021Leetcode;

import java.util.List;

public class _1428LeftmostColumnWithAtLeastAOne {
	public static void main(String[] args) {

	}

	interface BinaryMatrix {
		public int get(int row, int col);

		public List<Integer> dimensions();
	};

	public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions = binaryMatrix.dimensions();
		int noOfRows = dimensions.get(0);
		int noOfCols = dimensions.get(1);

		int currRow = 0, currCol = noOfCols - 1;
		while (currRow < noOfRows && currCol >= 0) {
			if (binaryMatrix.get(currRow, currCol) == 0)
				currRow++;
			else
				currCol--;
		}

		return currCol == noOfCols - 1 ? -1 : currCol;
	}
}
