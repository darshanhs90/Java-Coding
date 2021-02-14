package Jan2021Leetcode;

import java.util.Arrays;

public class _0167TwoSumIIInputArrayIsSorted {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 3, 4 }, 6)));
		System.out.println(Arrays.toString(twoSum(new int[] { -1, 0 }, -1)));
		System.out.println(Arrays.toString(twoSum(new int[] { 0, 0, 3, 4 }, 0)));
	}

	public static int[] twoSum(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target)
				return new int[] { left + 1, right + 1 };
			if (sum > target)
				right--;
			else
				left++;
		}
		return new int[] {};
	}

}
