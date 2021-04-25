package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0040CombinationSumII {

	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
		System.out.println(combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));
	}

	public static List<List<Integer>> combinationSum2(int[] nums, int target) {
		HashSet<List<Integer>> output = new HashSet<List<Integer>>();
		if (nums == null || nums.length == 0)
			return new ArrayList<List<Integer>>(output);
		Arrays.sort(nums);

		dfs(0, 0, nums, target, new ArrayList<Integer>(), output);
		return new ArrayList<List<Integer>>(output);
	}

	public static void dfs(int index, int currSum, int[] nums, int target, List<Integer> list,
			HashSet<List<Integer>> output) {

		if (currSum == target) {
			output.add(new ArrayList<Integer>(list));
			return;
		}
		if (currSum > target || index >= nums.length)
			return;
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(i + 1, currSum + nums[i], nums, target, list, output);
			list.remove(list.size() - 1);
		}
	}
}
