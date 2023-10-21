package Oct2023Leetcode;

public class _0006ZigZagConversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 2));
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPALISHIRING", 4));
		System.out.println(convert("A", 1));
	}

	public static String convert(String s, int numRows) {
		if (numRows <= 1)
			return s;
		Direction currDir = Direction.DOWN;
		StringBuilder[] sbArr = new StringBuilder[numRows];
		for (int i = 0; i < sbArr.length; i++) {
			sbArr[i] = new StringBuilder();
		}
		int currRow = 0;
		for (int i = 0; i < s.length(); i++) {
			if (currRow < 0) {
				currRow = 1;
				currDir = Direction.DOWN;
			} else if (currRow == numRows) {
				currRow = numRows - 2;
				currDir = Direction.UP;
			}

			sbArr[currRow].append(s.charAt(i));
			if (currDir == Direction.DOWN) {
				currRow++;
			} else {
				currRow--;
			}
		}

		StringBuilder output = new StringBuilder();
		for (int i = 0; i < sbArr.length; i++) {
			output.append(sbArr[i]);
		}
		return output.toString();
	}

	enum Direction {
		DOWN, UP
	}
}
