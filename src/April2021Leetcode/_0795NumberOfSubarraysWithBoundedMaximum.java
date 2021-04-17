package April2021Leetcode;

public class _0795NumberOfSubarraysWithBoundedMaximum {
	public static void main(String[] args) {
		System.out.println(numSubarrayBoundedMax(new int[] { 2, 1, 4, 3 }, 2, 3));
	}

	public static int numSubarrayBoundedMax(int[] nums, int minVal, int maxVal) {
		return count(nums, maxVal) - count(nums, minVal - 1);
	}

	public static int count(int[] nums, int limit) {
		int out = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= limit) {
				count++;
			} else {
				count = 0;
			}
			out += count;
		}
		return out;
	}

}
