package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0006ZigZagConversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 2));
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPALISHIRING", 4));
		System.out.println(convert("A", 1));
	}

	enum Direction {
		Up, Down
	}

	public static String convert(String s, int numRows) {
		if (numRows <= 1)
			return s;
		List<StringBuilder> list = new ArrayList<StringBuilder>();
		for (int i = 0; i < numRows; i++) {
			list.add(new StringBuilder());
		}
		Direction dir = Direction.Down;
		int rowIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			list.get(rowIndex).append(c);

			if (dir == Direction.Down) {
				rowIndex++;
			} else {
				rowIndex--;
			}

			if (rowIndex >= numRows) {
				rowIndex = numRows - 2;
				dir = Direction.Up;
			} else if (rowIndex < 0) {
				rowIndex = 1;
				dir = Direction.Down;
			}
		}
		StringBuilder op = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			op.append(list.get(i));
		}
		return op.toString();
	}
}
