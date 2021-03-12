package Feb2021Leetcode;

import java.util.List;

public class _1428LeftmostColumnWithAtLeastAOne {
	public static void main(String[] args) {

	}

	interface BinaryMatrix {
		public int get(int row, int col);

		public List<Integer> dimensions();
	};

	public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> list = binaryMatrix.dimensions();
		int row = list.get(0);
		int col = list.get(1);

		int currRow = 0;
		int currCol = col - 1;
		while (currRow < row && currCol >= 0) {
			if (binaryMatrix.get(currRow, currCol) == 1) {
				currCol--;
			} else {
				currRow++;
			}
		}

		return currCol == col-1 ? -1: currCol+1;
	}
}
