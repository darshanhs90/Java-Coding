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

	    // Adds a number into the data structure.
		PriorityQueue<Integer> minHeap=new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> maxHeap=new PriorityQueue<>();
		
	    public void addNum(int num) {
	        minHeap.offer(num);
	        maxHeap.offer(minHeap.poll());
	        if(maxHeap.size()>minHeap.size())
	        	minHeap.offer(maxHeap.poll());
	    }

	    // Returns the median of current data stream
	    public double findMedian() {
	        if(minHeap.size()==maxHeap.size())
	        {
	        	return (minHeap.peek()+maxHeap.peek())/2;
	        }
	        else{
	        	return minHeap.peek();
	        }
	    }
	};


}
