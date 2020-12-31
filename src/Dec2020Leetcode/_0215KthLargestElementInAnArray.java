package Dec2020Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0215KthLargestElementInAnArray {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});

		for (int i = 0; i < nums.length; i++) {
			if (pq.size() == k) {
				pq.add(nums[i]);
				pq.poll();
			} else {
				pq.add(nums[i]);
			}
		}
		int min = pq.peek();
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			min = Math.min(min, pq.poll());
		}
		return min;
	}
}
