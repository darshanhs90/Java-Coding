package June2021GoogLeetcode;

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
		int count;

		public Pair(char c, int count) {
			this.c = c;
			this.count = count;
		}
	}

	public static String reorganizeString(String S) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < S.length(); i++) {
			map.compute(S.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o2.count - o1.count;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
		}

		while (pq.size() > 1) {
			Pair p1 = pq.poll();
			Pair p2 = pq.poll();
			sb.append(p1.c);
			sb.append(p2.c);
			p1.count--;
			p2.count--;

			if (p1.count > 0)
				pq.offer(p1);

			if (p2.count > 0)
				pq.offer(p2);
		}

		if (pq.isEmpty()) {
			return sb.toString();
		}

		if (pq.peek().count > 1)
			return "";
		sb.append(pq.peek().c);
		return sb.toString();
	}
}
