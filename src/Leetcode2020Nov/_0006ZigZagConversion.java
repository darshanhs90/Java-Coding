package Leetcode2020Nov;

public class _0006ZigZagConversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 2));
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPALISHIRING", 4));
		System.out.println(convert("A", 1));
	}

	enum Direction {
		UP, DOWN
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1 || s.length() <= 2)
			return s;
		StringBuilder[] sb = new StringBuilder[numRows];

		int index = 0;
		Direction direction = Direction.DOWN;
		for (int i = 0; i < s.length(); i++) {

			if (index == numRows) {
				index = index - 2;
				direction = Direction.UP;
			} else if (direction == Direction.UP && index < 0) {
				index = 1;
				direction = Direction.DOWN;
			}

			if (sb[index] == null) {
				sb[index] = new StringBuilder();
			}
			sb[index] = sb[index].append(s.charAt(i));
			if (direction == Direction.DOWN) {
				index++;
			} else {
				index--;
			}
		}

		StringBuilder out = new StringBuilder();
		for (int i = 0; i < sb.length; i++) {
			out = out.append(sb[i] != null ? sb[i] : "");
		}

		return out.toString();
	}
}
