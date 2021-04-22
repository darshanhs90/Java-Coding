package April2021PrepLeetcode;

import java.util.Arrays;

public class _0031NextPermutation {
	public static void main(String[] args) {
		nextPermutation(new int[] { 1, 2, 3 });
		nextPermutation(new int[] { 1, 3, 2 });
		nextPermutation(new int[] { 3, 2, 1 });
		nextPermutation(new int[] { 1, 1, 5 });
		nextPermutation(new int[] { 1, 5, 1 });
		nextPermutation(new int[] { 1 });
	}

	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2)
			return;

		int changeIndex = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				changeIndex = i;
				break;
			}
		}

		if (changeIndex == -1) {
			reverse(0, nums.length - 1, nums);
		} else {

			int i = changeIndex + 1;
			for (i = changeIndex + 1; i < nums.length; i++) {
				if (nums[i] <= nums[changeIndex]) {
					break;
				}
			}
			swap(changeIndex, i - 1, nums);
			reverse(changeIndex + 1, nums.length - 1, nums);
		}

		System.out.println(Arrays.toString(nums));
	}

	public static void reverse(int left, int right, int[] nums) {
		while (left < right) {
			swap(left, right, nums);
			left++;
			right--;
		}
	}

	public static void swap(int left, int right, int[] nums) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

}
