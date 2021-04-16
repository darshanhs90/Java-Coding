package April2021Leetcode;

public class _1060MissingElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(missingElement(new int[] { 4, 7, 9, 10 }, 1));
		System.out.println(missingElement(new int[] { 4, 7, 9, 10 }, 3));
		System.out.println(missingElement(new int[] { 1, 2, 4 }, 3));
	}

	public static int numOfMissing(int[] nums, int i) {
		return nums[i] - nums[0] - i;
	}

	public static int missingElement(int[] nums, int k) {
		int left = 0, right = nums.length - 1;

		int missing_num = numOfMissing(nums, nums.length - 1);
		if (missing_num < k) {
			return nums[nums.length - 1] + k - missing_num;
		}

		while (left < right) {
			int mid = (left + right) / 2;
			if (numOfMissing(nums, mid) < k) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return nums[left - 1] + k - numOfMissing(nums, left - 1);
	}
}
