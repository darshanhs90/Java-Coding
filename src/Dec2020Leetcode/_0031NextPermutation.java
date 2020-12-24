package Dec2020Leetcode;

public class _0031NextPermutation {
	public static void main(String[] args) {
		nextPermutation(new int[] { 1, 2, 3 });
		nextPermutation(new int[] { 1, 3, 2 });
		nextPermutation(new int[] { 3, 2, 1 });
		nextPermutation(new int[] { 1, 1, 5 });
		nextPermutation(new int[] { 1, 5, 1 });
		nextPermutation(new int[] { 1 });
	}

	// 12354

	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 1)
			return;
		int index = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			reverse(0, nums.length - 1, nums);
		} else {
			int swapIndex = nums.length - 1;
			for (int i = index + 1; i < nums.length; i++) {
				if (nums[i] <= nums[index]) {
					swapIndex = i - 1;
					break;
				}
			}

			swap(index, swapIndex, nums);
			reverse(index + 1, nums.length - 1, nums);
		}
	}

	public static void reverse(int left, int right, int[] nums) {
		while (left < right) {
			swap(left, right, nums);
			left++;
			right--;
		}
	}

	public static void swap(int left, int right, int[] nums) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

}
