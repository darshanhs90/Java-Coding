package Oct2023Leetcode;

public class _0643MaximumAverageSubarrayI {

	public static void main(String[] args) {
		System.out.println(findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));
		System.out.println(findMaxAverage(new int[] { 5 }, 1));
		System.out.println(findMaxAverage(new int[] { -1 }, 1));
		System.out.println(findMaxAverage(new int[] { 0, 1, 1, 3, 3 }, 4));

	}

	public static double findMaxAverage(int[] nums, int k) {
		int left = 0, right = 0;
		int sum = 0;
		double maxAverage = -1 * Integer.MIN_VALUE;
		for (right = 0; right < k; right++) {
			sum += nums[right];
		}
		while (right < nums.length) {
			maxAverage = Math.max(maxAverage, (double) sum / (double) k);
			sum = sum - nums[left] + nums[right];
			left++;
			right++;
		}
		return Math.max(maxAverage, (double) sum / (double) k);
	}
}
