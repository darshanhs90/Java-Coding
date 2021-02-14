package Jan2021Leetcode;

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
		if (nums.length < 3)
			return 0;
		Arrays.sort(nums);

		int length = nums.length;
		int val1 = nums[0] * nums[1] * nums[length - 1];
		int val2 = nums[length - 1] * nums[length - 2] * nums[length - 3];

		return Math.max(val1, val2);
	}
}
