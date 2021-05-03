package May2021PrepLeetcode;

public class _1060MissingElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(missingElement(new int[] { 4, 7, 9, 10 }, 1));
		System.out.println(missingElement(new int[] { 4, 7, 9, 10 }, 3));
		System.out.println(missingElement(new int[] { 1, 2, 4 }, 3));
	}

	public static int noOfMissingElements(int index, int[] nums) {
		return nums[index] - nums[0] - index;
	}

	public static int missingElement(int[] nums, int k) {
		int totalMissingElements = noOfMissingElements(nums.length - 1, nums);

		if (totalMissingElements < k) {
			return nums[nums.length - 1] - totalMissingElements + k;
		}

		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;

			int currMissingElements = noOfMissingElements(mid, nums);

			if (currMissingElements >= k) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return nums[left - 1] - noOfMissingElements(left - 1, nums) + +k;
	}
}
