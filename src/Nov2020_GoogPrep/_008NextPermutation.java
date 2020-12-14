package Nov2020_GoogPrep;

public class _008NextPermutation {

	public static void main(String[] args) {
		nextPermutation(new int[] { 3, 2, 1 });
		nextPermutation(new int[] { 1, 2, 3 });
		nextPermutation(new int[] { 1, 1, 5 });
		nextPermutation(new int[] { 5, 1, 1 });
		nextPermutation(new int[] { 1 });
	}

	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		int changeIndex = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				changeIndex = i;
				break;
			}
		}

		if (changeIndex == -1) {
			reverse(nums, 0, nums.length - 1);
		} else {
			int i = changeIndex + 1;
			for (i = changeIndex + 1; i < nums.length; i++) {
				if (nums[i] <= nums[changeIndex]) {
					break;
				}
			}
			swap(nums, changeIndex, i - 1);
			reverse(nums, changeIndex + 1, nums.length - 1);
		}
	}

	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	public static void swap(int[] nums, int start, int end) {
		if (start < nums.length && end < nums.length) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
		}
	}
}
