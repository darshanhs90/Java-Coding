package May2021Leetcode;

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
		Arrays.sort(candidates);
		HashSet<List<Integer>> output = new HashSet<List<Integer>>();

		dfs(0, 0, candidates, target, new ArrayList<Integer>(), output);
		return new ArrayList<List<Integer>>(output);
	}

	public static void dfs(int index, int currSum, int[] candidates, int target, List<Integer> list,
			HashSet<List<Integer>> output) {
		if (currSum == target) {
			output.add(new ArrayList<Integer>(list));
			return;
		}

		if (index >= candidates.length || currSum > target)
			return;

		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(i + 1, currSum + candidates[i], candidates, target, list, output);
			list.remove(list.size() - 1);
		}
	}
}
