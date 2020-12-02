package Dec2020Leetcode;

import java.util.ArrayList;

public class _0006ZigZagConversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 1));
		System.out.println(convert("PAYPALISHIRING", 2));
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPALISHIRING", 4));
		System.out.println(convert("A", 1));
	}

	public static String convert(String s, int numRows) {
		if (s == null || s.length() < 2 || numRows <= 1 || numRows >= s.length())
			return s;
		ArrayList<StringBuffer> list = new ArrayList<StringBuffer>();
		for (int i = 0; i < numRows; i++) {
			list.add(new StringBuffer());
		}
		boolean increasing = true;
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			list.get(index).append(c);
			if (increasing == true) {
				index++;
			} else {
				index--;
			}
			if (index == numRows) {
				index = numRows - 2;
				increasing = false;
			} else if (index == -1) {
				index = 1;
				increasing = true;
			}
		}
		StringBuilder op = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			op = op.append(list.get(i));
		}
		return op.toString();
	}
}
