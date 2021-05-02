package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0040CombinationSumII {

	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
		System.out.println(combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));
	}

	public static List<List<Integer>> combinationSum2(int[] nums, int target) {
		Arrays.sort(nums);
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		dfs(0, 0, nums, target, new ArrayList<Integer>(), set);
		return new ArrayList<List<Integer>>(set);
	}

	public static void dfs(int index, int sum, int[] nums, int target, List<Integer> list, HashSet<List<Integer>> set) {
		if (sum == target) {
			set.add(new ArrayList<Integer>(list));
			return;
		}
		if (index >= nums.length || sum > target)
			return;

		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(i + 1, sum + nums[i], nums, target, list, set);
			list.remove(list.size() - 1);
		}
	}
}
