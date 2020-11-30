package Nov2020_GoogPrep;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _024KthLargestElementInAnArray {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}

	public static int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return -1;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		for (int i = 0; i < nums.length; i++) {
			if (q.size() == k) {
				if (q.peek() < nums[i]) {
					q.poll();
					q.offer(nums[i]);
				}
			} else {
				q.offer(nums[i]);
			}
		}
		return q.peek();
	}
}
