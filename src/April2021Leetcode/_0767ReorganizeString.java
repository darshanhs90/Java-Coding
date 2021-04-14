package April2021Leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _0767ReorganizeString {

	public static void main(String[] args) {
		System.out.println(reorganizeString("aab"));
		System.out.println(reorganizeString("aaab"));
	}

	static class Pair {
		char c;
		int val;

		public Pair(char c, int val) {
			this.c = c;
			this.val = val;
		}
	}

	public static String reorganizeString(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
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
		while (!pq.isEmpty() && pq.size() > 1) {
			Pair p1 = pq.poll();
			Pair p2 = pq.poll();
			sb.append(p1.c);
			sb.append(p2.c);

			p1.val--;
			p2.val--;
			if (p1.val > 0)
				pq.offer(p1);

			if (p2.val > 0)
				pq.offer(p2);
		}

		if (!pq.isEmpty()) {
			if (pq.peek().val > 1)
				return "";
			else if (pq.peek().c == sb.charAt(sb.length() - 1))
				return "";
			sb.append(pq.peek().c);
		}
		return sb.toString();
	}
}
