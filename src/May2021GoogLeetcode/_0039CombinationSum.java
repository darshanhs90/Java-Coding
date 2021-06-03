package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		dfs(0, candidates, target, new ArrayList<Integer>(), output);
		return output;
	}

	public static void dfs(int index, int[] candidates, int target, List<Integer> list, List<List<Integer>> output) {
		if (target == 0) {
			output.add(new ArrayList<Integer>(list));
			return;
		}

		if (index >= candidates.length || target < 0)
			return;

		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(i, candidates, target - candidates[i], list, output);
			list.remove(list.size() - 1);
		}
	}

}
