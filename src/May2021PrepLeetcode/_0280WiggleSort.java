package May2021PrepLeetcode;

import java.util.Arrays;

public class _0280WiggleSort {

	public static void main(String[] args) {
		wiggleSort(new int[] { 3, 5, 2, 1, 6, 4 });
	}

	public static void wiggleSort(int[] nums) {
		boolean less = true;
		for (int i = 0; i < nums.length - 1; i++) {
			if (less) {
				if (nums[i] > nums[i + 1]) {
					swap(i, i + 1, nums);
				}
			} else {
				if (nums[i] < nums[i + 1]) {
					swap(i, i + 1, nums);
				}
			}
			less = !less;
		}
		System.out.println(Arrays.toString(nums));
	}

	public static void swap(int left, int right, int[] nums) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

}
