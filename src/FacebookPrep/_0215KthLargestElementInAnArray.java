package FacebookPrep;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0215KthLargestElementInAnArray {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}

		});
		for (int i = 0; i < nums.length; i++) {
			pq.offer(nums[i]);
			if (pq.size() > k)
				pq.poll();
		}
		return pq.peek();
	}
}
