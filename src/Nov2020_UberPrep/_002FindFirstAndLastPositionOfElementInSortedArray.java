package Nov2020_UberPrep;

import java.util.Arrays;

public class _002FindFirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
		System.out.println(Arrays.toString(searchRange(new int[] {}, 0)));
		System.out.println(Arrays.toString(searchRange(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(searchRange(new int[] { 2, 2 }, 2)));
	}

	public static int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[] { -1, -1 };
		}
		int startIndex = findStartIndex(nums, target);
		int endIndex = findEndIndex(nums, target);
		return new int[] { startIndex, endIndex };
	}

	public static int findStartIndex(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				if ((mid - 1 >= 0 && nums[mid - 1] != target) || mid == 0) {
					return mid;
				} else {
					right = mid - 1;
				}
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static int findEndIndex(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				if ((mid + 1 <= nums.length - 1 && nums[mid + 1] != target) || mid == nums.length - 1) {
					return mid;
				} else {
					left = mid + 1;
				}
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
