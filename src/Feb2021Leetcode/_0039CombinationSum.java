package Feb2021Leetcode;

import java.util.ArrayList;
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
		dfs(0, 0, candidates, target, new ArrayList<Integer>(), output);
		return output;
	}

	public static void dfs(int index, int currSum, int[] candidates, int target, List<Integer> tempList,
			List<List<Integer>> output) {
		if (currSum == target) {
			output.add(new ArrayList<Integer>(tempList));
			return;
		}
		if (index >= candidates.length || currSum > target)
			return;

		for (int i = index; i < candidates.length; i++) {
			tempList.add(candidates[i]);
			dfs(i, currSum + candidates[i], candidates, target, tempList, output);
			tempList.remove(tempList.size() - 1);
		}
	}

}
