package Nov2020Leetcode;

import java.util.Comparator;
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
		PriorityQueue<Integer> maxHeap;
		PriorityQueue<Integer> minHeap;

		/** initialize your data structure here. */
		public MedianFinder() {
			maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}

			});
			minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o1 - o2;
				}
			});
		}

		public void addNum(int num) {
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
			if (minHeap.size() > maxHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}
		}

		public double findMedian() {
			if (maxHeap.size() > minHeap.size())
				return maxHeap.peek();
			else
				return (maxHeap.peek() + minHeap.peek()) /(double) 2;
		}
	}

}
