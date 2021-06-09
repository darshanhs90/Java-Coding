package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _0737SentenceSimilarityII {
	public static void main(String[] args) {
		System.out.println(areSentencesSimilarTwo(new String[] { "great", "acting", "skills" },
				new String[] { "fine", "drama", "talent" },
				new ArrayList<List<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList("great", "good")),
						new ArrayList<String>(Arrays.asList("fine", "good")),
						new ArrayList<String>(Arrays.asList("acting", "drama")),
						new ArrayList<String>(Arrays.asList("skills", "talent"))))));
	}

	public static boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
		if (words1.length != words2.length)
			return false;
		HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		for (List<String> pair : pairs) {
			String str1 = pair.get(0);
			String str2 = pair.get(1);

			if (!map.containsKey(str1)) {
				map.put(str1, new HashSet<String>());
			}

			if (!map.containsKey(str2)) {
				map.put(str2, new HashSet<String>());
			}

			map.get(str1).add(str2);
			map.get(str2).add(str1);
		}

		for (int i = 0; i < words2.length; i++) {
			if (!isSimilar(words1[i], words2[i], map, new HashSet<String>()))
				return false;
		}
		return true;
	}

	public static boolean isSimilar(String word1, String word2, HashMap<String, HashSet<String>> map,
			HashSet<String> visited) {
		if (word1.equals(word2))
			return true;

		if (!map.containsKey(word1) || visited.contains(word1))
			return false;

		if (map.get(word1).contains(word2))
			return true;
		visited.add(word1);
		Iterator<String> iter = map.get(word1).iterator();
		while (iter.hasNext()) {
			String str = iter.next();
			if (!visited.contains(str) && isSimilar(str, word2, map, visited))
				return true;
		}
		visited.remove(word1);
		return false;
	}
}
