package Nov2020Leetcode;

import java.util.Arrays;

public class _0080RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
		System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));
	}

	public static int removeDuplicates(int[] nums) {
		Integer currVal = null;
		int leftIndex = 0;
		int currCount = 1;
		for (int i = 0; i < nums.length; i++) {
			if (currVal == null) {
				currVal = nums[i];
				leftIndex++;
			} else {
				if (nums[i] == currVal) {
					if (currCount < 2) {
						nums[leftIndex] = nums[i];
						leftIndex++;
					}
					currCount++;
				} else {
					currVal = nums[i];
					currCount = 1;
					nums[leftIndex] = nums[i];
					leftIndex++;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
		return leftIndex;
	}
}
