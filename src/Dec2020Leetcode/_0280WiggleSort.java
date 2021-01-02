package Dec2020Leetcode;

public class _0280WiggleSort {

	public static void main(String[] args) {
		wiggleSort(new int[] { 3, 5, 2, 1, 6, 4 });
	}

	public static void wiggleSort(int[] nums) {
		boolean increasing = true;
		for (int i = 0; i < nums.length - 1; i++) {
			if (increasing) {
				if (nums[i] > nums[i + 1])
					swap(i, i + 1, nums);
			} else {
				if (nums[i] < nums[i + 1])
					swap(i, i + 1, nums);
			}
			increasing = !increasing;
		}
	}

	public static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
