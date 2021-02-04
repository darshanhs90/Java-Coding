package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0018FourSum {

	public static void main(String[] args) {
		System.out.println(fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
		System.out.println(fourSum(new int[] {}, 0));
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (nums.length < 4)
			return output;
		Arrays.sort(nums);
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		for (int i = 0; i <= nums.length - 3; i++) {
			for (int j = i + 1; j <= nums.length - 2; j++) {
				int sum = nums[i] + nums[j];
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					int currSum = sum + nums[left] + nums[right];
					if (currSum == target) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);

						if (!set.contains(list)) {
							set.add(list);
							output.add(list);
						}
						left++;
						right--;
					} else if (currSum > target) {
						right--;
					} else {
						left++;
					}
				}
			}
		}
		return output;
	}

}
