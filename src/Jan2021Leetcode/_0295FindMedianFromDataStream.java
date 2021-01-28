package Jan2021Leetcode;

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

		/** initialize your data structure here. */
		public MedianFinder() {
		}

		public void addNum(int num) {
		}

		public double findMedian() {
		}
	}

}
