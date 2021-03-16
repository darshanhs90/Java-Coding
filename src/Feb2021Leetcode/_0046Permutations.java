package Feb2021Leetcode;

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
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		permute(nums, new ArrayList<Integer>(), out, new HashSet<Integer>());
		return out;
	}

	public static void permute(int[] nums, List<Integer> list, List<List<Integer>> out, HashSet<Integer> visited) {
		if (list.size() == nums.length) {
			out.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited.contains(i)) {
				visited.add(i);
				list.add(nums[i]);
				permute(nums, list, out, visited);
				list.remove(list.size() - 1);
				visited.remove(i);
			}
		}
	}

}
