package Mar2021Leetcode;

import java.util.Arrays;

public class _0034FindFirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
		System.out.println(Arrays.toString(searchRange(new int[] {}, 0)));
		System.out.println(Arrays.toString(searchRange(new int[] { 1 }, 1)));
	}

	public static int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };

		int start = findStartPosition(nums, target);
		if (start == -1)
			return new int[] { -1, -1 };
		int end = findEndPosition(nums, target);

		return new int[] { start, end };
	}

	public static int findStartPosition(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;

			if (nums[mid] == target) {
				if (mid == 0 || nums[mid - 1] != nums[mid]) {
					return mid;
				}
				right = mid - 1;
				;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static int findEndPosition(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;

			if (nums[mid] == target) {
				if (mid == nums.length - 1 || nums[mid + 1] != nums[mid]) {
					return mid;
				}
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
