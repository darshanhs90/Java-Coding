package Dec2020Leetcode;

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
		if (s == null || s.length() == 0)
			return 0;
		char prevChar = s.charAt(0);
		int count = 1;
		int maxCount = 1;
		for (int i = 1; i < s.length(); i++) {
			char currChar = s.charAt(i);
			if (currChar == prevChar) {
				count++;
			} else {
				prevChar = currChar;
				count = 1;
			}
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}
}
