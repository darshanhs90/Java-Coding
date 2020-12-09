package Nov2020_FBPrep;

import java.util.HashMap;

public class _072VerifyingAnAlienDictionary {

	public static void main(String[] args) {
		System.out.println(isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
		System.out.println(isAlienSorted(new String[] { "word", "world", "row" }, "worldabcefghijkmnpqstuvxyz"));
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
			boolean breakCheck = false;

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				char c1 = word1.charAt(j);
				char c2 = word2.charAt(j);
				if (c1 != c2) {
					if (map.get(c1) < map.get(c2)) {
						breakCheck = true;
						break;
					} else {
						return false;
					}
				}
			}
			if (!breakCheck && word2.length() < word1.length())
				return false;
		}
		return true;
	}
}
