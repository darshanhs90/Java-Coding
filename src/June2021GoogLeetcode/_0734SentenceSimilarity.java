package June2021GoogLeetcode;

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
		for (List<String> pairs : similarPairs) {
			String src = pairs.get(0);
			String dst = pairs.get(1);
			if (!map.containsKey(src))
				map.put(src, new HashSet<String>());

			if (!map.containsKey(dst))
				map.put(dst, new HashSet<String>());
			map.get(src).add(dst);
			map.get(dst).add(src);
		}

		for (int i = 0; i < sentence2.length; i++) {
			String src = sentence1[i];
			String dst = sentence2[i];

			if (src.equals(dst))
				continue;

			if (map.containsKey(src) && map.get(src).contains(dst))
				continue;
			return false;
		}
		return true;
	}
}
