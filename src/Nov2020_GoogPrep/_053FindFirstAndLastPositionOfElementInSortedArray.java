package Nov2020_GoogPrep;

import java.util.Arrays;

public class _053FindFirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
		System.out.println(Arrays.toString(searchRange(new int[] {}, 0)));
		System.out.println(Arrays.toString(searchRange(new int[] { 1 }, 1)));
	}

	public static int[] searchRange(int[] nums, int target) {
		int leftIndex = findLeftIndex(nums, target);
		int rightIndex = findRightIndex(nums, target);
		return new int[] { leftIndex, rightIndex };
	}

	public static int findLeftIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				if (left == mid || (mid - 1) >= 0 && nums[mid - 1] != target)
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

	public static int findRightIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				if (right == mid || (mid + 1) < nums.length && nums[mid + 1] != target)
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
