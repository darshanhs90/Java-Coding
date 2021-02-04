package Jan2021Leetcode;

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
		char charVal;
		int count;

		public Pair(char charVal, int count) {
			this.charVal = charVal;
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

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
		}

		StringBuilder sb = new StringBuilder();

		while (!pq.isEmpty() && pq.size() > 1) {
			Pair p1 = pq.poll();
			Pair p2 = pq.poll();
			sb.append(p1.charVal);
			sb.append(p2.charVal);
			
			p1.count--;
			p2.count--;
			if(p1.count>0)
				pq.offer(p1);
			

			if(p2.count>0)
				pq.offer(p2);
		}
		
		if(pq.isEmpty())
			return sb.toString();
		else if(pq.peek().count>1)
			return "";
		
		if(sb.length() > 0 && sb.charAt(sb.length()-1) != pq.peek().charVal)
		{
			sb.append(pq.peek().charVal);
			return sb.toString();
		}
		return "";
	}
}
