package PracticeLeetCode;

import java.util.HashMap;

public class _290WordPattern {
	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}

	public static boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<Character, String>();
		HashMap<String, Character> reverseMap = new HashMap<String, Character>();

		String[] wordSplit = str.split(" ");
		if(pattern.length() != wordSplit.length)
			return false;
		for (int i = 0; i < pattern.length(); i++) {
			Character c = pattern.charAt(i);
			String word = wordSplit[i];
			if(map.containsKey(c))
			{
				if(!map.get(c).contentEquals(word))
					return false;
			}
			else {
				map.put(c, word);
			}

			if(reverseMap.containsKey(word))
			{
				if(reverseMap.get(word) != (c))
					return false;
			}
			else {
				reverseMap.put(word, c);
			}
		}
		return true;
	}

}
