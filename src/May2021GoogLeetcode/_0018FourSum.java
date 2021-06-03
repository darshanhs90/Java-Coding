package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0018FourSum {

	public static void main(String[] args) {
		System.out.println(fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
		System.out.println(fourSum(new int[] {}, 0));
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				for (int j = i + 1; j < nums.length; j++) {
					if (j == i + 1 || nums[j] != nums[j - 1]) {
						int left = j + 1;
						int right = nums.length - 1;
						while (left < right) {
							int sum = nums[i] + nums[j] + nums[left] + nums[right];
							if (sum == target) {
								List<Integer> list = new ArrayList<Integer>();
								list.add(nums[i]);
								list.add(nums[j]);
								list.add(nums[left]);
								list.add(nums[right]);
								output.add(new ArrayList<Integer>(list));
								left++;
								right--;
								while (left < right && nums[left] == nums[left - 1])
									left++;
							} else if (sum > target) {
								right--;
							} else {
								left++;
							}
						}
					}
				}
			}
		}

		return output;
	}

}
