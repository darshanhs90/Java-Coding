package FacebookPortalPrep;

import java.util.Collections;
import java.util.PriorityQueue;

public class _0010Greedy_SlowSum {

	public static void main(String[] args) {
		System.out.println(getTotalTime(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(getTotalTime(new int[] { 4, 2, 1, 3 }));
	}

	public static int getTotalTime(int[] arr) {
		// Write your code here
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);
		}

		int penalty = 0;
		while (!pq.isEmpty() && pq.size() > 1) {
			int val = pq.poll() + pq.poll();
			penalty += val;
			pq.offer(val);
		}
		return penalty;
	}
}
