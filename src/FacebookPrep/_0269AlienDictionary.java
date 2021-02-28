package FacebookPrep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _0269AlienDictionary {

	public static void main(String[] args) {
		System.out.println(alienOrder(new String[] { "wxqkj", "whqg", "cckgh", "cdxg", "cdxdt", "cdht", "ktgxt",
				"ktgch", "ktdw", "ktdc", "jqw", "jmc", "jmg" }));
		System.out.println(alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
		System.out.println(alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
		System.out.println(alienOrder(new String[] { "z", "x" }));
		System.out.println(alienOrder(new String[] { "z", "x", "z" }));
	}

	public static String alienOrder(String[] words) {
		if (words == null || words.length == 0)
			return null;

		HashMap<Character, HashSet<Character>> charMap = new HashMap<Character, HashSet<Character>>();
		HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();

		addAllCharacters(words, charMap, countMap);

		if (!populateMaps(words, charMap, countMap))
			return "";

		Queue<Character> q = new LinkedList<Character>();
		for (Map.Entry<Character, HashSet<Character>> entry : charMap.entrySet()) {
			char c = entry.getKey();
			if (countMap.get(c) == 0) {
				q.offer(c);
				countMap.put(c, -1);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Character c = q.poll();
				sb.append(c);

				Iterator<Character> iter = charMap.get(c).iterator();
				while (iter.hasNext()) {
					char c1 = iter.next();
					countMap.put(c1, countMap.get(c1) - 1);
					if (countMap.get(c1) == 0) {
						q.offer(c1);
						countMap.put(c, -1);
					}
				}
			}
		}

		if (sb.length() < charMap.size())
			return "";
		return sb.toString();
	}

	public static void addAllCharacters(String[] words, HashMap<Character, HashSet<Character>> charMap,
			HashMap<Character, Integer> countMap) {
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				charMap.put(word.charAt(j), new HashSet<Character>());
				countMap.put(word.charAt(j), 0);
			}
		}
	}

	public static boolean populateMaps(String[] words, HashMap<Character, HashSet<Character>> charMap,
			HashMap<Character, Integer> countMap) {
		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			if (word1.startsWith(word2) && word1.length() > word2.length())
				return false;
			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				char c1 = word1.charAt(j);
				char c2 = word2.charAt(j);
				if (c1 != c2) {
					if (!charMap.get(c1).contains(c2)) {
						charMap.get(c1).add(c2);
						countMap.put(c2, countMap.get(c2) + 1);
					}
					break;
				}
			}
		}
		return true;
	}
}
