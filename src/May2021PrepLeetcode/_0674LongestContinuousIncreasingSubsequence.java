package May2021PrepLeetcode;

public class _0674LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(findLengthOfLCIS(new int[] { 1, 3, 5, 4, 7 }));
		System.out.println(findLengthOfLCIS(new int[] { 2, 2, 2, 2, 2 }));
	}

	public static int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int maxLength = 0;
		int length = 1;
		int prevVal = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > prevVal) {
				length++;
				prevVal = nums[i];
			} else {
				maxLength = Math.max(maxLength, length);
				length = 1;
				prevVal = nums[i];
			}
		}
		maxLength = Math.max(maxLength, length);
		return maxLength;
	}

}
