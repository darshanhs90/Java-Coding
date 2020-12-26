package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0047PermutationsII {

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
		System.out.println(permuteUnique(new int[] { 1, 2, 3 }));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		dfs(nums, new ArrayList<Integer>(), output, new HashSet<Integer>(), new HashSet<List<Integer>>());
		return output;
	}

	public static void dfs(int[] nums, List<Integer> list, List<List<Integer>> output, HashSet<Integer> visited,
			HashSet<List<Integer>> set) {
		if (list.size() == nums.length) {
			if (!set.contains(list)) {
				output.add(new ArrayList<Integer>(list));
				set.add(list);
			}
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited.contains(i)) {
				visited.add(i);
				list.add(nums[i]);
				dfs(nums, list, output, visited, set);
				visited.remove(Integer.valueOf(i));
				list.remove(list.size() - 1);
			}

		}
	}

}
