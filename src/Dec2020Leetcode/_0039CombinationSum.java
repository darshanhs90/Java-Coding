package Dec2020Leetcode;

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
		dfs(0, 0, new ArrayList<Integer>(), output, candidates, target);
		return output;
	}

	public static void dfs(int index, int currSum, List<Integer> list, List<List<Integer>> output, int[] candidates,
			int target) {
		if (currSum > target || index > candidates.length - 1)
			return;
		if (currSum == target) {
			output.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(i, currSum + candidates[i], list, output, candidates, target);
			list.remove(list.size() - 1);
		}
	}

}
