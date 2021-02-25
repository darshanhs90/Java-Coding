package FacebookPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		dfs(candidates, target, 0, new ArrayList<Integer>(), output, new HashSet<List<Integer>>());
		return output;
	}

	public static void dfs(int[] candidates, int target, int currSum, List<Integer> list, List<List<Integer>> output,
			HashSet<List<Integer>> set) {
		if (currSum > target)
			return;
		if (currSum == target) {
			List<Integer> newList = new ArrayList<Integer>(list);
			Collections.sort(newList);
			if (!set.contains(newList)) {
				output.add(newList);
				set.add(newList);
			}
			return;
		}

		for (int i = 0; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(candidates, target, currSum + candidates[i], list, output, set);
			list.remove(list.size() - 1);
		}
	}

}
