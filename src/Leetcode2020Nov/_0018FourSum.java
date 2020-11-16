package Leetcode2020Nov;

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
		Arrays.parallelSort(nums);
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				int k = j + 1;
				int l = nums.length - 1;
				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if (sum == target) {
						set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
						k++;
						l--;
					} else if (sum > target) {
						l--;
					} else {
						k++;
					}
				}
			}
		}
		return new ArrayList<List<Integer>>(set);
	}
}
