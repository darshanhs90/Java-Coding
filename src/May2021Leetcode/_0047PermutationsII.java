package May2021Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0047PermutationsII {

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
		System.out.println(permuteUnique(new int[] { 1, 2, 3 }));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		HashSet<List<Integer>> output = new HashSet<List<Integer>>();
		dfs(nums, new ArrayList<Integer>(), output, new HashSet<Integer>());
		return new ArrayList<List<Integer>>(output);
	}

	public static void dfs(int[] nums, List<Integer> list, HashSet<List<Integer>> output, HashSet<Integer> visited) {
		if (list.size() == nums.length) {
			output.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited.contains(i)) {
				visited.add(i);
				list.add(nums[i]);
				dfs(nums, list, output, visited);
				list.remove(list.size() - 1);
				visited.remove(i);
			}
		}
	}

}
