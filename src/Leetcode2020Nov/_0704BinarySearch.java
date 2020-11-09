package Leetcode2020Nov;

public class _0704BinarySearch {

	public static void main(String[] args) {
		System.out.println(search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
		System.out.println(search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
		System.out.println(search(new int[] { 5 }, 5));

	}

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int leftIndex = 0;
		int rightIndex = nums.length - 1;
		while (leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target) {
				rightIndex = mid - 1;
			} else {
				leftIndex = mid + 1;
			}
		}
		return nums[leftIndex] == target ? leftIndex : -1;
	}
}
