package Dec2020Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class _1046LastStoneWeight {

	public static void main(String[] args) {
		System.out.println(lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
	}

	public static int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < stones.length; i++) {
			pq.offer(stones[i]);
		}

		while (pq.size() > 1) {

			int val1 = pq.poll();
			int val2 = pq.poll();
			int newVal = Math.abs(val1 - val2);
			if (newVal > 0) {
				pq.offer(newVal);
			}
		}
		return pq.size() == 1 ? pq.peek() : 0;
	}

}
