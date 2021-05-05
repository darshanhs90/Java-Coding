package May2021PrepLeetcode;

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
		char key;
		int val;

		public Pair(char key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	public static String rearrangeString(String s, int k) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.compute(c, (key, val) -> val == null ? 1 : val + 1);
		}
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o2.val - o1.val;
			}
		});

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
		}

		StringBuilder sb = new StringBuilder();
		Queue<Pair> q = new LinkedList<Pair>();
		while (!pq.isEmpty()) {
			Pair p1 = pq.poll();
			sb.append(p1.key);
			p1.val--;

			q.offer(p1);

			if (q.size() >= k) {
				p1 = q.poll();
				if (p1.val > 0)
					pq.offer(p1);
			}
		}

		if (sb.length() != s.length())
			return "";
		return sb.toString();
	}

}
