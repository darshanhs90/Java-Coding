package Leetcode2020Nov;

import java.util.Arrays;

public class _0628MaximumProductOfThreeNumbers {

	public static void main(String[] args) {
		System.out.println(maximumProduct(new int[] { 1, 2, 3 }));
		System.out.println(maximumProduct(new int[] { 1, 2, 3, 4 }));
		System.out.println(maximumProduct(new int[] { -1, -2, -3 }));
		System.out.println(maximumProduct(new int[] { -3, -2, 1, 2, 3, 4 }));
		System.out.println(maximumProduct(new int[] { -3, -2, -1, 0 }));
		System.out.println(maximumProduct(new int[] { -3, -2, -1, 0, 1, 2, 3, 4, 5, 6 }));
	}

	public static int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int noOfNegativeNumbers = 0;
		int noOfPositiveNumbers = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				noOfNegativeNumbers += 1;
			} else {
				noOfPositiveNumbers += 1;
			}
		}
		if (noOfPositiveNumbers == 0 || noOfNegativeNumbers == 0) {
			return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
		} else {
			if (noOfNegativeNumbers > 1) {
				if (noOfPositiveNumbers == 1) {
					return nums[nums.length - 1] * nums[0] * nums[1];
				} else if (noOfPositiveNumbers > 1) {
					return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],
							nums[nums.length - 1] * nums[1] * nums[0]);
				}
			} else {
				return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
			}
		}
		return 0;
	}
}
