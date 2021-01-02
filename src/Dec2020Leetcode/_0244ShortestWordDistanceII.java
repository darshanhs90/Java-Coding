package Dec2020Leetcode;

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
				if (map.containsKey(words[i])) {
					map.get(words[i]).add(i);
				} else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(i);
					map.put(words[i], list);
				}
			}
		}

		public int shortest(String word1, String word2) {
			if (word1.equals(word2))
				return 0;
			List<Integer> list1 = map.get(word1);
			List<Integer> list2 = map.get(word2);
			int maxDiff = Integer.MAX_VALUE;
			int l1 = 0;
			int l2 = 0;
			while (l1 < list1.size() && l2 < list2.size()) {
				maxDiff = Math.min(maxDiff, Math.abs(list1.get(l1) - list2.get(l2)));
				if (list1.get(l1) < list2.get(l2)) {
					l1++;
				} else {
					l2++;
				}
			}
			return maxDiff;
		}
	}

}
