package Dec2020Leetcode;

public class _0153FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(findMin(new int[] { 11, 13, 15, 17 }));
		System.out.println(findMin(new int[] { 2, 1 }));
		System.out.println(findMin(new int[] { 2, 3, 4, 5, 1 }));
		System.out.println(findMin(new int[] { 5, 1, 2, 3, 4 }));
	}

	public static int findMin1(int[] nums) {
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
		}
		return min;
	}

	public static int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;
		if (nums[left] < nums[right])
			return nums[left];
		while (right - left > 1) {
			int mid = (left + right) / 2;
			if (nums[mid] > nums[left]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return nums[right];
	}

}
