package May2021Leetcode;

import java.util.HashMap;

public class _0953VerifyingAnAlienDictionary {

	public static void main(String[] args) {
		System.out.println(isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
		System.out.println(isAlienSorted(new String[] { "word", "world", "row" }, "hlabcdefgijkmnopqrstuvwxyz"));
		System.out.println(isAlienSorted(new String[] { "apple", "app" }, "abcdefghijklmnopqrstuvwxyz"));
	}

	public static boolean isAlienSorted(String[] words, String order) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];

			if (word1.length() > word2.length() && word1.startsWith(word2))
				return false;

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				char c1 = word1.charAt(j);
				char c2 = word2.charAt(j);

				if (c1 != c2) {
					if (map.get(c1) > map.get(c2))
						return false;
					break;
				}
			}
		}
		return true;
	}
}
