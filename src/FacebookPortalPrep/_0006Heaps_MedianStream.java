package FacebookPortalPrep;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _0006Heaps_MedianStream {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findMedian(new int[] { 5, 15, 1, 3 })));
		System.out.println(Arrays.toString(findMedian(new int[] { 1, 2 })));
	}

	public static int[] findMedian(int[] arr) {
		// Write your code here
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int i = 0; i < arr.length; i++) {

			maxHeap.offer(arr[i]);
			minHeap.offer(maxHeap.poll());
			if (minHeap.size() > maxHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}

			if (minHeap.size() == maxHeap.size()) {
				arr[i] = (maxHeap.peek() + minHeap.peek()) / 2;
			} else {
				arr[i] = maxHeap.peek();
			}
		}
		return arr;
	}
}
