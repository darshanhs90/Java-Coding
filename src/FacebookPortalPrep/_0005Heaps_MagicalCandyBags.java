package FacebookPortalPrep;

import java.util.Collections;
import java.util.PriorityQueue;

public class _0005Heaps_MagicalCandyBags {

	public static void main(String[] args) {
		System.out.println(maxCandies(new int[] { 2, 1, 7, 4, 2 }, 3));
	}

	public static int maxCandies(int[] arr, int k) {
		// Write your code here
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);
		}
		int count = 0;
		while (!pq.isEmpty() && k > 0) {
			int val = pq.poll();
			count += val;

			val = val / 2;
			if (val > 0)
				pq.offer(val);

			k--;
		}
		return count;
	}
}
