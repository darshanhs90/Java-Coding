package Dec2020Leetcode;

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
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		dfs(-1, 0, new ArrayList<Integer>(), output, candidates, target, set);
		return output;
	}

	public static void dfs(int index, int currSum, List<Integer> list, List<List<Integer>> output, int[] candidates,
			int target, HashSet<List<Integer>> set) {
		if (currSum > target || index > candidates.length - 1)
			return;
		if (currSum == target) {
			if (!set.contains(list)) {
				output.add(new ArrayList<Integer>(list));
				set.add(list);
			}
			return;
		}

		for (int i = index + 1; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(i, currSum + candidates[i], list, output, candidates, target, set);
			list.remove(list.size() - 1);
		}
	}
}
