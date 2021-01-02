package Dec2020Leetcode;

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
			return "";
		if (words.length == 1)
			return words[0];

		HashMap<Character, HashSet<Character>> adjList = new HashMap<Character, HashSet<Character>>();
		HashMap<Character, Integer> adjListCount = new HashMap<Character, Integer>();

		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				adjList.put(word.charAt(i), new HashSet<Character>());
				adjListCount.put(word.charAt(i), 0);
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			if (word1.length() > word2.length() && word1.startsWith(word2))
				return "";

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					if (!adjList.get(word1.charAt(j)).contains(word2.charAt(j))) {
						adjList.get(word1.charAt(j)).add(word2.charAt(j));
						adjListCount.put(word2.charAt(j), adjListCount.get(word2.charAt(j)) + 1);
					}
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		Queue<Character> q = new LinkedList<Character>();
		for (Map.Entry<Character, Integer> entry : adjListCount.entrySet()) {
			if (entry.getValue() == 0) {
				q.offer(entry.getKey());
				entry.setValue(-1);
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Character c = q.poll();
				sb.append(c);

				HashSet<Character> neighbors = adjList.get(c);
				Iterator<Character> iter = neighbors.iterator();
				while (iter.hasNext()) {
					char neighbor = iter.next();
					adjListCount.put(neighbor, adjListCount.get(neighbor) - 1);
				}
				adjList.get(c).clear();
			}

			for (Map.Entry<Character, Integer> entry : adjListCount.entrySet()) {
				if (entry.getValue() == 0) {
					q.offer(entry.getKey());
					entry.setValue(-1);
				}
			}
		}

		if (sb.length() < adjListCount.size()) {
			return "";
		}
		return sb.toString();
	}
}
