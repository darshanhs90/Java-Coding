package Leetcode2020Nov;

import java.util.HashSet;

public class _0804UniqueMorseCodeWords {
	public static void main(String[] args) {
		System.out.println(uniqueMorseRepresentations(new String[] { "gin", "zen", "gig", "msg" }));
	}

	public static int uniqueMorseRepresentations(String[] words) {
		String[] morseCode = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
				"-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
				"-.--", "--.." };

		HashSet<String> set = new HashSet<String>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			sb = new StringBuilder();
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				sb = sb.append(morseCode[((int) word.charAt(j)) - 97]);
			}
			set.add(sb.toString());
		}
		return set.size();
	}
}
