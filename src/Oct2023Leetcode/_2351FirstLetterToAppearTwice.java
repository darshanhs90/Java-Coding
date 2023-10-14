package Oct2023Leetcode;

import java.util.HashSet;

public class _2351FirstLetterToAppearTwice {
	public static void main(String[] args) {
		System.out.println(repeatedCharacter("abccbaacz"));
		System.out.println(repeatedCharacter("abcdd"));
	}

	public static char repeatedCharacter(String s) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				return c;
			}
			set.add(c);
		}
		return ' ';
	}
}
