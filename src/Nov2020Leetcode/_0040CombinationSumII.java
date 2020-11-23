package Nov2020Leetcode;

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
		if (candidates == null || candidates.length == 0)
			return output;
		Arrays.parallelSort(candidates);
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		combinationSum(candidates, target, 0, 0, new ArrayList<Integer>(), output, set);
		return output;
	}

	public static void combinationSum(int[] candidates, int target, int index, int currSum, List<Integer> list,
			List<List<Integer>> output, HashSet<List<Integer>> set) {
		if (currSum == target) {
			if (!set.contains(list)) {
				output.add(new ArrayList<Integer>(list));
				set.add(list);
			}
			return;
		}
		if (currSum > target)
			return;
		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			combinationSum(candidates, target, i + 1, currSum + candidates[i], list, output, set);
			list.remove(list.size() - 1);
		}
	}
}
