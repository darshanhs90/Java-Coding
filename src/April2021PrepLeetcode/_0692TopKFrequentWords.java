package April2021PrepLeetcode;

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

		PriorityQueue<String> pq = new PriorityQueue<String>(k, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int count1 = map.get(o1);
				int count2 = map.get(o2);
				if (count1 == count2)
					return o1.compareTo(o2);
				return count2 - count1;
			}
		});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.offer(entry.getKey());
		}

		List<String> output = new ArrayList<String>();
		while (!pq.isEmpty() && k > 0) {
			output.add(pq.poll());
			k--;
		}
		return output;
	}

}
