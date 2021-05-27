package May2021GoogLeetcode;

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
		Direction dir = Direction.Down;
		for (int i = 0; i < numRows; i++) {
			sb[i] = new StringBuilder();
		}

		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			sb[index].append(c);

			if (dir == Direction.Down) {
				index++;
				if (index >= numRows) {
					index = numRows - 2;
					dir = Direction.Up;
				}
			} else if (dir == Direction.Up) {
				index--;
				if (index < 0) {
					index = 1;
					dir = Direction.Down;
				}
			}
		}

		StringBuilder out = new StringBuilder();
		for (int i = 0; i < sb.length; i++) {
			out.append(sb[i]);
		}
		return out.toString();
	}
}
