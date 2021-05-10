package May2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0039CombinationSum {

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
		System.out.println(combinationSum(new int[] { 2 }, 1));
		System.out.println(combinationSum(new int[] { 1 }, 1));
		System.out.println(combinationSum(new int[] { 1 }, 2));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0)
			return new ArrayList<List<Integer>>();
		;
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
		if (index == candidates.length || currSum > target)
			return;

		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(i, currSum + candidates[i], candidates, target, list, output);
			list.remove(list.size() - 1);
		}
	}

}
