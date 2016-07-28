package eBayPrep;

import java.util.PriorityQueue;

public class _215KthLargestElementInArray{
	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
	}
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
			System.out.println(pq);
			if(pq.size()>k)
				pq.poll();
		}
		return pq.peek();
	}

}

