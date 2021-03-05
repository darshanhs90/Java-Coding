package FacebookPrep;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _0358RearrangeStringKDistanceApart {

	public static void main(String[] args) {
		System.out.println(rearrangeString("aabbcc", 3));
		System.out.println(rearrangeString("aaabc", 3));
		System.out.println(rearrangeString("aaadbbcc", 2));
	}

	static class Pair {
		char charVal;
		int count;

		public Pair(char charVal, int count) {
			this.charVal = charVal;
			this.count = count;
		}
	}

	public static String rearrangeString(String s, int k) {
		if (k == 0)
			return s;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.compute(s.charAt(i), (key, val) -> val == null ? 1 : val + 1);
		}

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o2.count - o1.count;
			}
		});

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
		}

		Queue<Pair> q = new LinkedList<Pair>();
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			sb.append(p.charVal);
			p.count--;

			q.offer(p);
			if (q.size() >= k) {
				Pair pollPair = q.poll();
				if (pollPair.count > 0)
					pq.offer(pollPair);
			}

		}
		return sb.toString().length() == s.length() ? sb.toString() : "";
	}

}
