package Jan2021Leetcode;

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
		permute(nums, new HashSet<Integer>(), new ArrayList<Integer>(), output);
		return output;
	}

	public static void permute(int[] nums, HashSet<Integer> visited, List<Integer> list, List<List<Integer>> output) {
		if (list.size() == nums.length) {
			output.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited.contains(nums[i])) {
				visited.add(nums[i]);
				list.add(nums[i]);
				permute(nums, visited, list, output);
				list.remove(list.size() - 1);
				visited.remove(nums[i]);
			}
		}
	}

}
