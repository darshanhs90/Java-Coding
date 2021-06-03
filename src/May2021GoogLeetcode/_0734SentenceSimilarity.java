package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _0734SentenceSimilarity {
	public static void main(String[] args) {
		System.out.println(areSentencesSimilar(new String[] { "great", "acting", "skills" },
				new String[] { "fine", "drama", "talent" },
				new ArrayList<List<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList("great", "fine")),
						new ArrayList<String>(Arrays.asList("drama", "acting")),
						new ArrayList<String>(Arrays.asList("skills", "talent"))))));
	}

	public static boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
		if (sentence1.length != sentence2.length)
			return false;

		HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		for (List<String> list : similarPairs) {
			String str1 = list.get(0);
			String str2 = list.get(1);
			if (!map.containsKey(str1)) {
				map.put(str1, new HashSet<String>());
			}

			if (!map.containsKey(str2)) {
				map.put(str2, new HashSet<String>());
			}

			map.get(str1).add(str2);
			map.get(str2).add(str1);
		}

		for (int i = 0; i < sentence2.length; i++) {
			String word1 = sentence1[i];
			String word2 = sentence2[i];
			if (word1.equals(word2))
				continue;
			if (!map.containsKey(word1)) {
				return false;
			}

			if (!map.get(word1).contains(word2))
				return false;
		}
		return true;
	}
}
