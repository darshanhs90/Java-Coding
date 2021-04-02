package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0040CombinationSumII {

	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
		System.out.println(combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		HashSet<List<Integer>> visited = new HashSet<List<Integer>>();
		Arrays.sort(candidates);
		dfs(0, 0, candidates, new ArrayList<Integer>(), visited, target);
		return new ArrayList<List<Integer>>(visited);
	}

	public static void dfs(int index, int currSum, int[] nums, List<Integer> list, HashSet<List<Integer>> visited,
			int target) {

		if (currSum == target) {
			visited.add(new ArrayList<Integer>(list));
			return;
		}

		if (index >= nums.length || currSum > target)
			return;

		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(i + 1, currSum + nums[i], nums, list, visited, target);
			list.remove(list.size() - 1);
		}
	}
}
