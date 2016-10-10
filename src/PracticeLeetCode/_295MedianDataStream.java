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
	PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> minHeap=new PriorityQueue<>();

	public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if(minHeap.size()>maxHeap.size())
			maxHeap.offer(minHeap.poll());
	}

	// Returns the median of current data stream
	public double findMedian() {
		if(maxHeap.size()==minHeap.size())
		{
			return (maxHeap.peek()+minHeap.peek())/((double)2);
		}
		return maxHeap.peek();
	}


}
