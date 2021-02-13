package Jan2021Leetcode;

import java.util.PriorityQueue;

public class _1578MinimumDeletionCostToAvoidRepeatingLetters {
	public static void main(String[] args) {
		System.out.println(minCost("abaac", new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(minCost("abc", new int[] { 1, 2, 3 }));
		System.out.println(minCost("aabaa", new int[] { 1, 2, 3, 4, 1 }));
		System.out.println(minCost("bbbaaa", new int[] { 4, 9, 3, 8, 8, 9 }));
	}

	public static int minCost(String s, int[] cost) {
		int count = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < s.length(); i++) {
			pq = new PriorityQueue<Integer>();
			char c = s.charAt(i);
			pq.offer(cost[i]);
			while (i + 1 < s.length() && c == s.charAt(i + 1)) {
				pq.offer(cost[i + 1]);
				i++;
			}

			while (pq.size() > 1) {
				count += pq.poll();
			}
		}
		return count;
	}
}
