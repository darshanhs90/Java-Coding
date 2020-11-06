package Leetcode2020Nov;

public class _1446ConsecutiveCharacters {
	public static void main(String[] args) {
		System.out.println(maxPower("leetcode"));
		System.out.println(maxPower("abbcccddddeeeeedcba"));
		System.out.println(maxPower("abbcccddddeeeeedcba"));
		System.out.println(maxPower("hooraaaaaaaaaaay"));
		System.out.println(maxPower("tourist"));
		System.out.println(maxPower("cc"));
	}

	public static int maxPower(String s) {
		int maxPower = 1;
		int currCount = 1;
		char prevChar = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == prevChar) {
				currCount++;
			} else {
				maxPower = Math.max(maxPower, currCount);
				currCount = 1;
			}
			prevChar = c;
		}
		return Math.max(maxPower, currCount);
	}
}
