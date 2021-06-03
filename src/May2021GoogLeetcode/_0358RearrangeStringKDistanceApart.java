package May2021GoogLeetcode;

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
		char c;
		int val;

		public Pair(char c, int val) {
			this.c = c;
			this.val = val;
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
				// TODO Auto-generated method stub
				return o2.val - o1.val;
			}
		});

		Queue<Pair> q = new LinkedList<Pair>();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			sb.append(p.c);
			p.val--;

			q.offer(p);

			if (q.size() >= k) {
				p = q.poll();
				if (p.val > 0)
					pq.offer(p);
			}
		}
		if (sb.length() != s.length())
			return "";
		return sb.toString();
	}

}
