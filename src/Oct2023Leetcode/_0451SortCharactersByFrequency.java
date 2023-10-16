package Oct2023Leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _0451SortCharactersByFrequency {

	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
		System.out.println(frequencySort("cccaaa"));
		System.out.println(frequencySort("Aabb"));
		System.out.println(frequencySort("loveleetcode"));
	}

	public static String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		StringBuilder output = new StringBuilder();
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>(
				new Comparator<Map.Entry<Character, Integer>>() {

					@Override
					public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
						// TODO Auto-generated method stub
						return o2.getValue() - o1.getValue();
					}
				});

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			pq.add(entry);
		}
		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> entry = pq.poll();
			Character ch = entry.getKey();
			Integer val = entry.getValue();
			for (int i = 0; i < val; i++) {
				output.append(ch + "");
			}
		}
		return output.toString();
	}
}
