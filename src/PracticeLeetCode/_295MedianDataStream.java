package PracticeLeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class _295MedianDataStream {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public class MedianFinder {
		PriorityQueue<Integer> maxHeap=new PriorityQueue<>();
		PriorityQueue<Integer> minHeap=new PriorityQueue<>(Collections.reverseOrder());
		// Adds a number into the data structure.
		public void addNum(int num) {
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
			if(minHeap.size()>maxHeap.size())
			{
				maxHeap.offer(minHeap.poll());
			}
		}

		// Returns the median of current data stream
		public double findMedian() {
			if(minHeap.size()==maxHeap.size())
			{
				return (minHeap.peek()+maxHeap.peek())/((double)2);
			}
			else{
				return maxHeap.peek();
			}
		}
	};


}
