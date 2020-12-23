package Dec2020Leetcode;

import java.util.Arrays;

public class _0016ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 4));
		System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
		System.out.println(threeSumClosest(new int[] { 0, 1, 2 }, 3));
		System.out.println(threeSumClosest(new int[] { 0, 2, 1, -3 }, 1));
	}

	public static int threeSumClosest(int[] nums, int target) {
		int diff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		int output = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			int val = nums[i];
			while (left < right) {
				int sum = val + nums[left] + nums[right];
				int currDifference = target - (val + nums[left] + nums[right]);
				if (Math.abs(currDifference) < Math.abs(diff)) {
					diff = currDifference;
					output = val + nums[left] + nums[right];
				}
				if (sum == target) {
					return target;
				} else if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return output;
	}

}
