package Mar2021Leetcode;

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
		char val;
		int count;

		public Pair(char val, int count) {
			this.val = val;
			this.count = count;
		}
	}

	public static String rearrangeString(String s, int k) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			map.compute(s.charAt(i), (key, val) -> val == null ? 1 : val + 1);
		}

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.count - o1.count;
			}
		});
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
		}

		StringBuilder sb = new StringBuilder();
		Queue<Pair> q = new LinkedList<Pair>();
		while (!pq.isEmpty()) {
			Pair p1 = pq.poll();

			sb.append(p1.val);

			p1.count--;
			q.offer(p1);

			if (q.size() >= k) {
				Pair p = q.poll();
				if (p.count > 0)
					pq.offer(p);
			}
		}

		return sb.length() != s.length() ? "" : sb.toString();
	}

}
