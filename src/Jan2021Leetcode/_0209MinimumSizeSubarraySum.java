package Jan2021Leetcode;

public class _0209MinimumSizeSubarraySum {

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
	}

	public static int minSubArrayLen(int target, int[] nums) {
		int left = 0, right = 0;
		int minLength = Integer.MAX_VALUE;
		int sum = 0;
		while (right < nums.length) {
			sum += nums[right];
			if (sum >= target) {
				while (sum >= target) {
					minLength = Math.min(minLength, right - left + 1);
					sum -= nums[left];
					left++;
				}
			}
			right++;
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
