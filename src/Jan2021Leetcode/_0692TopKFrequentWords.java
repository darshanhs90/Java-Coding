package Jan2021Leetcode;

import java.util.ArrayList;
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
		String word;
		int count;

		public Pair(String word, int count) {
			this.word = word;
			this.count = count;
		}
	}

	public static List<String> topKFrequent(String[] words, int k) {
		List<String> output = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			map.compute(words[i], (key, value) -> value == null ? 1 : value + 1);
		}

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				int val = o1.count - o2.count;
				if (val == 0) {
					return o2.word.compareTo(o1.word);
				}
				return val;
			}
		});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
			if (pq.size() > k)
				pq.poll();
		}

		while (!pq.isEmpty()) {
			output.add(0, pq.poll().word);
		}
		return output;
	}

}
