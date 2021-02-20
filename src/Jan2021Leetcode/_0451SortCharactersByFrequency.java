package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0451SortCharactersByFrequency {

	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
		System.out.println(frequencySort("cccaaa"));
		System.out.println(frequencySort("Aabb"));
	}

	static class Pair {
		char c;
		int count;

		public Pair(char c, int count) {
			this.c = c;
			this.count = count;
		}
	}

	public static String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		List<Pair> list = new ArrayList<Pair>();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			list.add(new Pair(entry.getKey(), entry.getValue()));
		}

		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o2.count - o1.count;
			}
		});
		StringBuilder sb = new StringBuilder();

		for (Pair p : list) {
			sb.append(getString(p.c, p.count));
		}
		return sb.toString();
	}

	public static String getString(char c, int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(c);
		}
		return sb.toString();
	}

}
