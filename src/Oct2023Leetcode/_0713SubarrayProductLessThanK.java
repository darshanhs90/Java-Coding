package Oct2023Leetcode;

public class _0713SubarrayProductLessThanK {
	public static void main(String[] args) {
		System.out.println(numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
		System.out.println(numSubarrayProductLessThanK(new int[] { 1, 2, 3 }, 0));
		System.out.println(numSubarrayProductLessThanK(new int[] { 1, 1, 1 }, 2));
	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 1)
			return 0;
		int count = 0;
		int currProduct = 1, left = 0, right = 0;
		for (right = 0; right < nums.length; right++) {
			currProduct = currProduct * nums[right];
			while (currProduct >= k) {
				currProduct = currProduct / nums[left];
				left++;
			}
			count += right - left + 1;
		}
		return count;
	}
}
