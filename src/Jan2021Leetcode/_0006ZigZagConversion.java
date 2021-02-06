package Jan2021Leetcode;

public class _0006ZigZagConversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 2));
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPALISHIRING", 4));
		System.out.println(convert("A", 1));
	}

	static enum Direction {
		Up, Down
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1 || s.length() < 2)
			return s;

		StringBuffer[] sbArr = new StringBuffer[numRows];
		for (int i = 0; i < numRows; i++) {
			sbArr[i] = new StringBuffer();
		}
		int currRow = 0;
		Direction dir = Direction.Down;
		for (int i = 0; i < s.length(); i++) {
			sbArr[currRow].append(s.charAt(i));
			if (dir == Direction.Down) {
				currRow++;
			} else {
				currRow--;
			}

			if (currRow == numRows) {
				currRow = numRows - 2;
				dir = Direction.Up;
			} else if (currRow < 0) {
				currRow = 1;
				dir = Direction.Down;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sbArr.length; i++) {
			sb.append(sbArr[i]);
		}
		return sb.toString();
	}
}
