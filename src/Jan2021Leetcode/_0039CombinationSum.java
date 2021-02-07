package Jan2021Leetcode;

import java.util.ArrayList;
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
		dfs(0, candidates, target, new ArrayList<Integer>(), output, new HashSet<List<Integer>>());
		return output;
	}

	public static void dfs(int currSum, int[] candidates, int target, List<Integer> list, List<List<Integer>> output,
			HashSet<List<Integer>> visited) {
		if (currSum > target)
			return;
		if (currSum == target) {
			Collections.sort(list);
			if (!visited.contains(list)) {
				output.add(new ArrayList<Integer>(list));
				visited.add(list);
			}
			return;
		}

		for (int i = 0; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(currSum + candidates[i], candidates, target, list, output, visited);
			list.remove(Integer.valueOf(candidates[i]));
		}
	}

}
