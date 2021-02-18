package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0244ShortestWordDistanceII {

	public static void main(String[] args) {
		WordDistance obj = new WordDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" });
		System.out.println(obj.shortest("coding", "practice"));
		System.out.println(obj.shortest("makes", "coding"));
	}

	static class WordDistance {
		HashMap<String, List<Integer>> map;

		public WordDistance(String[] words) {
			map = new HashMap<String, List<Integer>>();
			for (int i = 0; i < words.length; i++) {
				if (!map.containsKey(words[i])) {
					map.put(words[i], new ArrayList<Integer>());
				}
				map.get(words[i]).add(i);
			}
		}

		public int shortest(String word1, String word2) {
			List<Integer> word1List = map.get(word1);
			List<Integer> word2List = map.get(word2);

			int minDiff = Integer.MAX_VALUE;

			for (int i = 0; i < word1List.size(); i++) {
				for (int j = 0; j < word2List.size(); j++) {
					minDiff = Math.min(minDiff, Math.abs(word1List.get(i) - word2List.get(j)));
				}
			}
			return minDiff;
		}
	}

}
