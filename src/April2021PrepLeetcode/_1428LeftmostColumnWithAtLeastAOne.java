package April2021PrepLeetcode;

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
		int rows = dimensions.get(0);
		int cols = dimensions.get(1);

		int currRow = 0, currCol = cols - 1;
		while (currRow < rows && currCol >= 0) {
			if (binaryMatrix.get(currRow, currCol) == 0)
				currRow++;
			else
				currCol--;
		}
		return (currCol == cols - 1) ? -1 : currCol + 1;
	}
}
