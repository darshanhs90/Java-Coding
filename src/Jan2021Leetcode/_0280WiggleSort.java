package Jan2021Leetcode;

import java.util.Arrays;

public class _0280WiggleSort {

	public static void main(String[] args) {
		wiggleSort(new int[] { 3, 5, 2, 1, 6, 4 });
	}

	public static void wiggleSort(int[] nums) {
		int[] sorted = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sorted);
		int index = 0;
		int left = 0, right = sorted.length - 1;
		while (index < nums.length) {
			nums[index++] = sorted[left];
			left++;
			if (index < nums.length) {
				nums[index++] = sorted[right];
				right--;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

}
