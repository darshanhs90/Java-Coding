package April2021Leetcode;

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

	public static List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			map.compute(words[i], (key, val) -> val == null ? 1 : val + 1);
		}

		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(k,
				new Comparator<Map.Entry<String, Integer>>() {

					@Override
					public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
						if (o1.getValue() == o2.getValue())
							return o1.getKey().compareTo(o2.getKey());
						return o2.getValue() - o1.getValue();
					}
				});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.offer(entry);

		}

		List<String> list = new ArrayList<String>();
		while (!pq.isEmpty() && list.size() < k) {
			list.add(pq.poll().getKey());
		}
		return list;
	}

}
