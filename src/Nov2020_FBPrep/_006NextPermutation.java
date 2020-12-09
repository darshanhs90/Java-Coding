package Nov2020_FBPrep;

import java.util.Arrays;

public class _006NextPermutation {

	public static void main(String[] args) {
		nextPermutation(new int[] { 3, 2, 1 });
		nextPermutation(new int[] { 1, 2, 3 });
		nextPermutation(new int[] { 1, 1, 5 });
		nextPermutation(new int[] { 5, 1, 1 });
		nextPermutation(new int[] { 1 });
	}

	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2)
			return;

		int index = nums.length - 2;
		while (index >= 0 && nums[index] >= nums[index + 1]) {
			index--;
		}
		int decreasingIndex = index;
		if (decreasingIndex == -1) {
			reverse(nums, 0, nums.length - 1);
		} else {
			index++;
			while (index < nums.length && nums[index] > nums[decreasingIndex]) {
				index++;
			}
			int swapIndex = index - 1;
			swap(nums, decreasingIndex, swapIndex);
			reverse(nums, decreasingIndex + 1, nums.length - 1);
		}
		System.out.println(Arrays.toString(nums));
	}

	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	public static void swap(int[] nums, int start, int end) {
		if (start >= 0 && end < nums.length) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
		}
	}
}
