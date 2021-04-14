package appleInterview;

public class _0674LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(findLengthOfLCIS(new int[] { 1, 3, 5, 4, 7 }));
		System.out.println(findLengthOfLCIS(new int[] { 2, 2, 2, 2, 2 }));
	}

	public static int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int prev = nums[0];
		int maxLength = 1;
		int currLength = 1;
		for (int i = 1; i < nums.length; i++) {

			if (nums[i] > prev) {
				currLength++;
			} else {
				currLength = 1;
			}
			prev = nums[i];
			maxLength = Math.max(maxLength, currLength);
		}

		return maxLength;
	}

}
