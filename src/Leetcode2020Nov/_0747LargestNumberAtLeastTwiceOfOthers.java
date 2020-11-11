package Leetcode2020Nov;

public class _0747LargestNumberAtLeastTwiceOfOthers {
	public static void main(String[] args) {
		System.out.println(dominantIndex(new int[] { 3, 6, 1, 0 }));
		System.out.println(dominantIndex(new int[] { 1, 2, 3, 4 }));
	}

	public static int dominantIndex(int[] nums) {
		int maxIndex = -1;
		int maxElement = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > maxElement) {
				maxElement = nums[i];
				maxIndex = i;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (i != maxIndex && nums[i] != maxElement && 2 * nums[i] > maxElement) {
				return -1;
			}
		}
		return maxIndex;
	}
}
