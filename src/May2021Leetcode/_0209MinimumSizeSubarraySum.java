package May2021Leetcode;

public class _0209MinimumSizeSubarraySum {

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
	}

	public static int minSubArrayLen(int s, int[] nums) {
		int minLength = Integer.MAX_VALUE;
		int left = 0, right = 0;
		int sum = 0;
		while (right < nums.length) {
			sum += nums[right];
			while (left <= right && sum >= s) {
				minLength = Math.min(minLength, right - left + 1);
				sum -= nums[left];
				left++;
			}
			right++;
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
