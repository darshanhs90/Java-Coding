package Jan2021Leetcode;

import java.util.Arrays;

public class _0016ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 4));
		System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
		System.out.println(threeSumClosest(new int[] { 0, 1, 2 }, 3));
		System.out.println(threeSumClosest(new int[] { 0, 2, 1, -3 }, 1));
	}

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE;
		int minDiffSum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
				int diff = target - sum;

				if (Math.abs(diff) < minDiff) {
					minDiffSum = sum;
					minDiff = Math.abs(diff);
				}

				if (diff == 0)
					return target;
				else if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return minDiffSum;
	}

}
