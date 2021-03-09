package Feb2021Leetcode;

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
		HashMap<Character, HashSet<Character>> adjList = new HashMap<Character, HashSet<Character>>();
		HashMap<Character, Integer> inDegreeCount = new HashMap<Character, Integer>();

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				inDegreeCount.put(word.charAt(j), 0);
				adjList.put(word.charAt(j), new HashSet<Character>());
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];

			if (word1.length() > word2.length() && word1.startsWith(word2))
				return "";

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				char c1 = word1.charAt(j);
				char c2 = word2.charAt(j);

				if (c1 != c2) {
					if (!adjList.get(c1).contains(c2)) {
						adjList.get(c1).add(c2);
						inDegreeCount.put(c2, inDegreeCount.get(c2) + 1);
					}
					break;
				}
			}
		}

		Queue<Character> q = new LinkedList<Character>();
		for (Map.Entry<Character, Integer> entry : inDegreeCount.entrySet()) {
			if (entry.getValue() == 0) {
				q.offer(entry.getKey());
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				char c = q.poll();
				inDegreeCount.put(c, -1);
				sb.append(c);

				Iterator<Character> iter = adjList.get(c).iterator();
				while (iter.hasNext()) {
					char c1 = iter.next();
					inDegreeCount.put(c1, inDegreeCount.get(c1) - 1);
				}
			}

			for (Map.Entry<Character, Integer> entry : inDegreeCount.entrySet()) {
				if (entry.getValue() == 0) {
					q.offer(entry.getKey());
				}
			}
		}

		if (sb.length() != inDegreeCount.size())
			return "";
		return sb.toString();
	}
}
