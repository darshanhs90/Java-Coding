package Oct2023Leetcode;

import java.util.HashSet;

public class _1832CheckIfTheSentenceIsPangram {
	public static void main(String[] args) {
		System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
		System.out.println(checkIfPangram("leetcode"));
	}

	public static boolean checkIfPangram(String sentence) {
		if (sentence == null || sentence.length() < 26)
			return false;
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			set.add(c);
		}
		for (char c = 'a'; c <= 'z'; c++) {
			if (!set.contains(c))
				return false;
		}
		return true;
	}
}
