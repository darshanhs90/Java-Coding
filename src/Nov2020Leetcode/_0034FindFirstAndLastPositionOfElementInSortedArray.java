package Nov2020Leetcode;

import java.util.Arrays;

public class _0034FindFirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
		System.out.println(Arrays.toString(searchRange(new int[] {}, 0)));
		System.out.println(Arrays.toString(searchRange(new int[] { 1 }, 1)));
	}

	public static int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[] { -1, -1 };
		}
		int leftIndex = getStartIndex(nums, target);
		int rightIndex = getEndIndex(nums, target);
		return new int[] { leftIndex, rightIndex };
	}

	public static int getStartIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				if ((mid - 1 >= 0 && nums[mid - 1] != target) || mid == 0) {
					return mid;
				}
				right = mid - 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static int getEndIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				if ((mid + 1 < nums.length && nums[mid + 1] != target) || mid == nums.length - 1) {
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
