package Nov2020_FBPrep;

public class _006NextPermutation {

	public static void main(String[] args) {
		nextPermutation(new int[] { 3, 2, 1 });
		nextPermutation(new int[] { 1, 2, 3 });
		nextPermutation(new int[] { 1, 1, 5 });
		nextPermutation(new int[] { 1 });
	}

	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int firstDecreasingElementIndex = -1;
		int index = nums.length - 2;
		while (index >= 0) {
			if (nums[index] < nums[index + 1]) {
				firstDecreasingElementIndex = index;
				break;
			}
			index--;
		}
		if (index == -1) {
			reverseElements(nums, 0, nums.length - 1);
		} else {
			int currElement = nums[firstDecreasingElementIndex];
			index = firstDecreasingElementIndex + 1;
			while (index < nums.length && nums[index] > currElement) {
				index++;
			}
			swapElements(nums, firstDecreasingElementIndex, index - 1);
			reverseElements(nums, firstDecreasingElementIndex + 1, nums.length - 1);
		}
	}

	public static void swapElements(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

	public static void reverseElements(int[] nums, int start, int end) {
		while (start < end) {
			swapElements(nums, start, end);
			start++;
			end--;
		}
	}
}
