package Dec2020Leetcode;

import java.util.PriorityQueue;

public class _1578MinimumDeletionCostToAvoidRepeatingLetters {
	public static void main(String[] args) {
		System.out.println(minCost("abaac", new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(minCost("abc", new int[] { 1, 2, 3 }));
		System.out.println(minCost("aabaa", new int[] { 1, 2, 3, 4, 1 }));
		System.out.println(minCost("bbbaaa", new int[] { 4, 9, 3, 8, 8, 9 }));
	}

	public static int minCost(String s, int[] cost) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1);
		int sum = 0;
		for (int i = 0; i < cost.length - 1;) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				pq = new PriorityQueue<Integer>(1);
				char prev = s.charAt(i);
				while (i < cost.length && s.charAt(i) == prev) {
					pq.offer(cost[i]);
					i++;
				}

				while (pq.size() > 1) {
					sum += pq.poll();
				}
			} else {
				i++;
			}
		}
		return sum;
	}
}
