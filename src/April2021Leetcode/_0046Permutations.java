package April2021Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0046Permutations {

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 2, 3 }));
		System.out.println(permute(new int[] { 0, 1 }));
		System.out.println(permute(new int[] { 1 }));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		dfs(nums, new ArrayList<Integer>(), output, new HashSet<Integer>());
		return output;
	}

	public static void dfs(int[] nums, List<Integer> list, List<List<Integer>> output, HashSet<Integer> visited) {
		if (list.size() == nums.length) {
			output.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited.contains(i)) {
				list.add(nums[i]);
				visited.add(i);
				dfs(nums, list, output, visited);
				list.remove(list.size() - 1);
				visited.remove(Integer.valueOf(i));
			}
		}
	}

}
