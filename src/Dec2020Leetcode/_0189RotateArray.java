package Dec2020Leetcode;

public class _0189RotateArray {

	public static void main(String[] args) {
		rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
		rotate(new int[] { -1, -100, 3, 99 }, 2);
		rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
		rotate(new int[] { -1, -100, 3, 99 }, 2);
	}

	public static void rotate(int[] nums, int k) {
		if (k > nums.length)
			k = k % nums.length;
		k = nums.length - k;
		reverse(0, k - 1, nums);
		reverse(k, nums.length - 1, nums);
		reverse(0, nums.length - 1, nums);
	}

	public static void reverse(int left, int right, int[] nums) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

}
