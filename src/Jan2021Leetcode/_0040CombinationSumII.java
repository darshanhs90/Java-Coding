package Jan2021Leetcode;

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
		combinationSum(0, candidates, target, 0, new ArrayList<Integer>(), output, new HashSet<List<Integer>>());
		return output;
	}

	public static void combinationSum(int index, int[] candidates, int target, int currSum, List<Integer> list,
			List<List<Integer>> output, HashSet<List<Integer>> set) {
		if (currSum == target) {
			if (!set.contains(list)) {
				set.add(list);
				output.add(new ArrayList<Integer>(list));
			}
			return;
		}
		if (currSum > target || index >= candidates.length) {
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			combinationSum(i + 1, candidates, target, currSum + candidates[i], list, output, set);
			list.remove(list.size() - 1);
		}
	}
}
