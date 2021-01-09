package Dec2020Leetcode;

import java.util.HashSet;

public class _0804UniqueMorseCodeWords {
	public static void main(String[] args) {
		System.out.println(uniqueMorseRepresentations(new String[] { "gin", "zen", "gig", "msg" }));
	}

	public static int uniqueMorseRepresentations(String[] words) {
		String strArray[] = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
				".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
				"--.." };
		HashSet<String> set = new HashSet<String>();
		for (String str : words) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				sb.append(strArray[str.charAt(i) - 'a']);
			}
			set.add(sb.toString());
		}
		return set.size();
	}
}
