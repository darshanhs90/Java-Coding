package Dec2020Leetcode;

import java.util.Arrays;

public class _0034FindFirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
		System.out.println(Arrays.toString(searchRange(new int[] {}, 0)));
		System.out.println(Arrays.toString(searchRange(new int[] { 1 }, 1)));
	}

	public static int[] searchRange(int[] nums, int target) {
		int left = findLeftIndex(nums, target);
		int right = findRightIndex(nums, target);
		return new int[] { left, right };
	}

	public static int findLeftIndex(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				if (mid == 0 || nums[mid - 1] != target)
					return mid;
				else {
					right = mid - 1;
				}
			} else if (target > nums[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public static int findRightIndex(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				if (mid == nums.length - 1 || nums[mid + 1] != target)
					return mid;
				else {
					left = mid + 1;
				}
			} else if (target >= nums[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
