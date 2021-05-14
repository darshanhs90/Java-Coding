package May2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _0692TopKFrequentWords {

	public static void main(String[] args) {
		System.out.println(topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
		System.out.println(topKFrequent(
				new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));
	}

	static class Pair {
		String str;
		int count;

		public Pair(String str, int count) {
			this.str = str;
			this.count = count;
		}
	}

	public static List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			map.compute(words[i], (key, val) -> val == null ? 1 : val + 1);
		}

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.count == o2.count)
					return o2.str.compareTo(o1.str);
				return o1.count - o2.count;
			}
		});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
			if (pq.size() > k)
				pq.poll();
		}

		List<String> out = new ArrayList<String>();
		while (!pq.isEmpty()) {
			out.add(pq.poll().str);
		}
		Collections.reverse(out);
		return out;
	}

}
