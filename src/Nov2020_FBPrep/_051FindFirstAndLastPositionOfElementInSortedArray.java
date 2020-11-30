package Nov2020_FBPrep;

import java.util.Arrays;

public class _051FindFirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
		System.out.println(Arrays.toString(searchRange(new int[] {}, 0)));
		System.out.println(Arrays.toString(searchRange(new int[] { 2, 2 }, 2)));
	}

	public static int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		int startIndex = findStartPosition(nums, target);
		int endIndex = findEndPosition(nums, target);
		return new int[] { startIndex, endIndex };
	}

	public static int findStartPosition(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				if ((mid != left && nums[mid - 1] != target) || mid == left)
					return mid;
				else {
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

	public static int findEndPosition(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				if ((mid != right && nums[mid + 1] != target) || mid == right)
					return mid;
				else {
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
