package May2021PrepLeetcode;

public class _0081SearchInRotatedSortedArrayII {

	public static void main(String[] args) {
		System.out.println(search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 0));
		System.out.println(search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 3));
		System.out.println(search(new int[] { 1, 3 }, 3));
		System.out.println(search(new int[] { 1, 3 }, 1));
		System.out.println(search(new int[] { 3, 1 }, 1));
		System.out.println(search(new int[] { 1, 3, 1, 1, 1, 1, 1 }, 3));
	}

	public static boolean search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			while (left < right && nums[left] == nums[left + 1])
				++left;
			while (left < right && nums[right] == nums[right - 1])
				--right;
			int mid = (left + right) / 2;

			if (nums[mid] == target) {
				return true;
			} else if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] <= target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return false;
	}

}
