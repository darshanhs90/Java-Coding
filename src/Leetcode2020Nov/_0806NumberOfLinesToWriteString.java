package Leetcode2020Nov;

import java.util.Arrays;

public class _0806NumberOfLinesToWriteString {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(numberOfLines(new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
				10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, "abcdefghijklmnopqrstuvwxyz")));
		System.out.println(Arrays.toString(numberOfLines(new int[] { 4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
				10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, "bbbcccdddaaa")));
	}

	public static int[] numberOfLines(int[] widths, String S) {
		if (S == null || S.length() == 0)
			return new int[] { 0, 0 };
		int noOfLines = 1;
		int currLineWidth = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			int widthForChar = widths[(int) c - 97];
			if (currLineWidth + widthForChar > 100) {
				noOfLines++;
				currLineWidth = 0;
			}
			currLineWidth+= widthForChar;
		}
		return new int[] { noOfLines, currLineWidth };
	}
}
