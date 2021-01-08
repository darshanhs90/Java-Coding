package Dec2020Leetcode;

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
		return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
				nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
	}
}
