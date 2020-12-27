package Dec2020Leetcode;

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
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return true;
			else if (nums[left] < nums[mid]) {
				if (nums[mid] < target || target < nums[left]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else if (nums[left] > nums[mid]) {
				if (nums[mid] > target || target > nums[right]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				left++;
			}
		}

		return false;
	}

}
