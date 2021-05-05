package May2021PrepLeetcode;

public class _0154FindMinimumInRotatedSortedArrayII {

	public static void main(String[] args) {

		System.out.println(findMin(new int[] { 3, 3, 1, 3 }));
		System.out.println(findMin(new int[] { 1, 3, 3 }));
		System.out.println(findMin(new int[] { 1, 3, 5 }));
		System.out.println(findMin(new int[] { 2, 2, 2, 0, 1 }));
	}

	public static int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < nums[right]) {
				right = mid;
			} else if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right--;
			}
		}
		return nums[left];
	}

}
