package Leetcode2020Nov;

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
		if (candidates == null || candidates.length == 0)
			return output;
		Arrays.parallelSort(candidates);
		combinationSum(candidates, target, 0, 0, new ArrayList<Integer>(), output);
		return output;
	}

	public static void combinationSum(int[] candidates, int target, int index, int currSum, List<Integer> list,
			List<List<Integer>> output) {
		if (currSum == target) {
			output.add(new ArrayList<Integer>(list));
			return;
		}
		if (currSum > target)
			return;
		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			combinationSum(candidates, target, i, currSum + candidates[i], list, output);
			list.remove(list.size() - 1);
		}
	}
}
