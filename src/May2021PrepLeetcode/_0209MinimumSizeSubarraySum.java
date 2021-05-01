package May2021PrepLeetcode;

public class _0209MinimumSizeSubarraySum {

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(minSubArrayLen(4, new int[] { 1, 4, 4 }));
		System.out.println(minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));
	}

	public static int minSubArrayLen(int s, int[] nums) {
		int left = 0, right = 0;
		int minLength = Integer.MAX_VALUE;
		int currSum = 0;
		while (right < nums.length) {
			currSum += nums[right];
			while (currSum >= s) {
				minLength = Math.min(minLength, right - left + 1);
				currSum -= nums[left];
				left++;
			}
			right++;
		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
