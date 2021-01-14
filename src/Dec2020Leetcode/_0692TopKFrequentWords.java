package Dec2020Leetcode;

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

	static class WordPair {
		String word;
		int count;

		public WordPair(String word, int count) {
			this.word = word;
			this.count = count;
		}
	}

	public static List<String> topKFrequent(String[] words, int k) {
		HashMap<String, WordPair> map = new HashMap<String, WordPair>();
		for (int i = 0; i < words.length; i++) {
			String currWord = words[i];
			if (map.containsKey(currWord)) {
				map.put(currWord, new WordPair(currWord, map.get(currWord).count + 1));
			} else {
				map.put(currWord, new WordPair(currWord, 1));
			}
		}

		PriorityQueue<WordPair> pq = new PriorityQueue<WordPair>(k, new Comparator<WordPair>() {

			@Override
			public int compare(WordPair o1, WordPair o2) {
				if (o1.count == o2.count) {
					return o2.word.compareTo(o1.word);
				}
				return o1.count - o2.count;
			}
		});

		List<String> output = new ArrayList<String>();

		for (Map.Entry<String, WordPair> entry : map.entrySet()) {
			pq.offer(entry.getValue());
			if (pq.size() > k)
				pq.poll();
		}

		while (!pq.isEmpty()) {
			output.add(pq.poll().word);
		}
		Collections.reverse(output);
		return output;
	}

}
