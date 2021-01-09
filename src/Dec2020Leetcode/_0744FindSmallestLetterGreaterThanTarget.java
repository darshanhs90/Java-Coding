package Dec2020Leetcode;

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
		int diff = Integer.MAX_VALUE;
		char out = ' ';
		for (char c : letters) {
			if (c != target) {
				int currDiff = 0;
				if (c < target) {
					currDiff = (c + 26 - target) % 26;
				} else {
					currDiff = (c - target) % 26;
				}
				
				if (currDiff < diff) {
					diff = currDiff;
					out = c;
				}
			}
		}
		return out;
	}

}
