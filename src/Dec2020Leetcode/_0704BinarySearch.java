package Dec2020Leetcode;

public class _0704BinarySearch {

	public static void main(String[] args) {
		System.out.println(search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
		System.out.println(search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
		System.out.println(search(new int[] { 5 }, 5));
	}

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}
}
