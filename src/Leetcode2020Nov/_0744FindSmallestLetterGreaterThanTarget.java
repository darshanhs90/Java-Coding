package Leetcode2020Nov;

public class _0744FindSmallestLetterGreaterThanTarget {
	public static void main(String[] args) {
		System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'a'));
		System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'c'));
		System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'd'));
		System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'g'));
		System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'j'));
		System.out.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'k'));
	}

	public static char nextGreatestLetter(char[] letters, char target) {
		Integer minLength = Integer.MAX_VALUE;
		Character minChar = null;
		for (int i = 0; i < letters.length; i++) {
			int diff = letters[i] - target;
			if (diff > 0) {
				if (diff < minLength) {
					minLength = diff;
					minChar = letters[i];
				}
			} else if (diff < 0) {
				diff = diff + 26;
				if (diff < minLength) {
					minLength = diff;
					minChar = letters[i];
				}
			}
		}
		return minChar;
	}
}
