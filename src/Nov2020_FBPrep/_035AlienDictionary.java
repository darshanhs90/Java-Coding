package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _035AlienDictionary {

	public static void main(String[] args) {
		System.out.println(alienOrder(new String[] { "wxqkj", "whqg", "cckgh", "cdxg", "cdxdt", "cdht", "ktgxt",
				"ktgch", "ktdw", "ktdc", "jqw", "jmc", "jmg" }));
		System.out.println(alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
		System.out.println(alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
		System.out.println(alienOrder(new String[] { "z", "x" }));
		System.out.println(alienOrder(new String[] { "z", "x", "z" }));
	}

	public static String alienOrder(String[] words) {
		HashMap<Character, List<Character>> adjList = new HashMap<Character, List<Character>>();
		HashMap<Character, List<Character>> reverseAdjList = new HashMap<Character, List<Character>>();
		HashMap<Character, Integer> reverseAdjListCount = new HashMap<Character, Integer>();

		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				adjList.put(c, new ArrayList<Character>());
				reverseAdjList.put(c, new ArrayList<Character>());
				reverseAdjListCount.put(c, 0);
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String currWord = words[i];
			String nextWord = words[i + 1];

			if (currWord.length() > nextWord.length() && currWord.startsWith(nextWord)) {
				return "";
			}

			for (int j = 0; j < Math.min(currWord.length(), nextWord.length()); j++) {
				if (currWord.charAt(j) != nextWord.charAt(j)) {
					if (!adjList.get(currWord.charAt(j)).contains(nextWord.charAt(j))) {
						adjList.get(currWord.charAt(j)).add(nextWord.charAt(j));
					}
					if (!reverseAdjList.get(nextWord.charAt(j)).contains(currWord.charAt(j))) {
						reverseAdjList.get(nextWord.charAt(j)).add(currWord.charAt(j));
						reverseAdjListCount.put(nextWord.charAt(j), reverseAdjListCount.get(nextWord.charAt(j)) + 1);
					}
					break;
				}
			}
		}

		Queue<Character> q = new LinkedList<Character>();
		for (Character val : reverseAdjListCount.keySet()) {
			if (reverseAdjListCount.get(val) == 0) {
				q.offer(val);
				reverseAdjListCount.put(val, -1);
			}
		}
		StringBuilder sb = new StringBuilder("");
		while (!q.isEmpty()) {
			Character c = q.poll();
			sb.append(c);
			List<Character> list = adjList.get(c);
			for (int i = 0; i < list.size(); i++) {
				Character newChar = list.get(i);
				reverseAdjListCount.put(newChar, reverseAdjListCount.get(newChar) - 1);
				if (reverseAdjListCount.get(newChar) == 0) {
					q.add(newChar);
				}
			}
		}
		if (sb.length() < reverseAdjListCount.size()) {
			return "";
		}
		return sb.toString();
	}
}
