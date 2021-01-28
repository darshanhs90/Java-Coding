package Dec2020Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class _0503NextGreaterElementII {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreaterElements(new int[] { 1, 2, 1 })));
	}

	public static int[] nextGreaterElements(int[] nums) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] nextGreat = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {

			while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nextGreat[i] = -1;
			} else {
				nextGreat[i] = nums[stack.peek()];
			}
			stack.push(i);
		}
		for (int i = nums.length - 1; i >= 0; i--) {

			while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nextGreat[i] = -1;
			} else {
				nextGreat[i] = nums[stack.peek()];
			}
			stack.push(i);
		}
		return nextGreat;
	}
}
