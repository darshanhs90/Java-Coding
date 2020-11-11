package Leetcode2020Nov;

import java.util.Arrays;
import java.util.Stack;

public class _0703KthLargestElementInAStream {

	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
		System.out.println(kthLargest.add(3)); // return 4
		System.out.println(kthLargest.add(5)); // return 5
		System.out.println(kthLargest.add(10)); // return 5
		System.out.println(kthLargest.add(9)); // return 8
		System.out.println(kthLargest.add(4)); // return 8
	}

	static class KthLargest {
		Stack<Integer> stack;
		int kVal;

		public KthLargest(int k, int[] nums) {
			stack = new Stack<Integer>();
			kVal = k;
			Arrays.parallelSort(nums);
			int index = nums.length - 1;
			while (stack.size() < k && index > -1) {
				stack.add(nums[index]);
				index--;
			}
		}

		public int add(int val) {
			if (stack.isEmpty()) {
				stack.add(val);
				return val;
			} else if (val < stack.peek() && stack.size() >= kVal) {
				return stack.peek();
			} else {
				Stack<Integer> tempStack = new Stack<Integer>();
				while (!stack.isEmpty() && val >= stack.peek()) {
					tempStack.add(stack.pop());
				}
				stack.add(val);
				while (stack.size() < kVal) {
					stack.add(tempStack.pop());
				}

				return stack.peek();
			}
		}
	}
}
