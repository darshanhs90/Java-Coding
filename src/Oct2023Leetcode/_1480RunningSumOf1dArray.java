package Oct2023Leetcode;

import java.util.Arrays;

public class _1480RunningSumOf1dArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(runningSum(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(runningSum(new int[] { 1, 1, 1, 1, 1 })));
		System.out.println(Arrays.toString(runningSum(new int[] { 3, 1, 2, 10, 1 })));
	}

	public static int[] runningSum(int[] nums) {
		int currSum = 0;
		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			nums[i] = currSum;
		}
		return nums;
	}
}
