package May2021PrepLeetcode;

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
		if (numRows == 1)
			return s;
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			sb[i] = new StringBuilder();
		}

		Direction dir = Direction.Down;
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			sb[index].append(c);

			if (dir == Direction.Down) {
				index += 1;
			} else {
				index -= 1;
			}

			if (index == numRows) {
				dir = Direction.Up;
				index = numRows - 2;
			} else if (index < 0) {
				dir = Direction.Down;
				index = 1;
			}
		}

		StringBuilder out = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			out.append(sb[i]);
		}
		return out.toString();
	}
}
