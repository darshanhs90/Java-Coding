package Nov2020Leetcode;

import java.util.Arrays;

public class _0189RotateArray {

	public static void main(String[] args) {
		rotate1(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
		rotate1(new int[] { -1, -100, 3, 99 }, 2);
		rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
		rotate(new int[] { -1, -100, 3, 99 }, 2);
	}

	public static void rotate1(int[] nums, int k) {
		if (k > nums.length) {
			k = k % nums.length;
		}

		int[] output = nums.clone();
		for (int i = 0; i < nums.length; i++) {
			int newIndex = (i + k) % nums.length;
			nums[newIndex] = output[i];
		}

		System.out.println(Arrays.toString(nums));
	}

	public static void rotate(int[] nums, int k) {
		if (k > nums.length) {
			k = k % nums.length;
		}

		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	public static void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

}
