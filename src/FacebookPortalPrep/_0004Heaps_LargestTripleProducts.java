package FacebookPortalPrep;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _0004Heaps_LargestTripleProducts {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findMaxProduct(new int[] { 1, 2, 3, 4, 5 })));
		System.out.println(Arrays.toString(findMaxProduct(new int[] { 2, 1, 2, 1, 2 })));
	}

	public static int[] findMaxProduct(int[] arr) {
		// Write your code here
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(3, Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);
			if (pq.size() < 3)
				arr[i] = -1;
			else {
				int num1 = pq.poll();
				int num2 = pq.poll();
				int num3 = pq.peek();
				arr[i] = num1 * num2 * num3;
				pq.offer(num2);
				pq.offer(num1);
			}
		}
		return arr;
	}
}
