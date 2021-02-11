package Jan2021Leetcode;

import java.util.Arrays;

public class _02593SumSmaller {

	public static void main(String[] args) {
		System.out.println(threeSumSmaller(new int[] { -2, 0, 1, 3 }, 2));
		System.out.println(threeSumSmaller(new int[] {}, 0));
		System.out.println(threeSumSmaller(new int[] { 0 }, 0));
	}

	public static int threeSumSmaller(int[] nums, int target) {
		if (nums.length < 3)
			return 0;
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				if (nums[left] + nums[right] + nums[i] < target) {
					count += right - left;
					left++;
				} else {
					right--;
				}
			}
		}
		return count;
	}

}
