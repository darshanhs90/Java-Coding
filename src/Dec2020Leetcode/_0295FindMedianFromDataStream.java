package Dec2020Leetcode;

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

	
}
