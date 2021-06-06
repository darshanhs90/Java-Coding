package June2021GoogLeetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class _0295FindMedianFromDataStream {

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(2);
		System.out.println(mf.findMedian());// -> 1.5
		mf.addNum(3);
		System.out.println(mf.findMedian());// -> 2
	}

	static class MedianFinder {
		PriorityQueue<Integer> maxHeap, minHeap;

		/** initialize your data structure here. */
		public MedianFinder() {
			maxHeap = new PriorityQueue<Integer>();
			minHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		}

		public void addNum(int num) {
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
			if (maxHeap.size() < minHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}
		}

		public double findMedian() {
			if (minHeap.size() == maxHeap.size()) {
				return (maxHeap.peek() + minHeap.peek()) / (double) 2;
			}
			return maxHeap.peek();
		}
	}
}
