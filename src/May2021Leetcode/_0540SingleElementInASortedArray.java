package May2021Leetcode;

public class _0540SingleElementInASortedArray {

	public static void main(String[] args) {
		System.out.println(singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
		System.out.println(singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
	}

	public static int singleNonDuplicate(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (mid % 2 == 1)
				mid = mid - 1;

			if (nums[mid] != nums[mid + 1]) {
				right = mid;
			} else {
				left = mid + 2;
			}
		}
		return nums[left];
	}
}
