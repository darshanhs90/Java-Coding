package Leetcode2020Nov;

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
		boolean[] visited = new boolean[nums.length];
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		permute(nums, new ArrayList<Integer>(), output, visited, set);
		return output;
	}

	public static void permute(int[] nums, List<Integer> list, List<List<Integer>> out, boolean[] visited,
			HashSet<List<Integer>> set) {
		if (list.size() == nums.length) {
			if (!set.contains(list)) {
				out.add(new ArrayList<Integer>(list));
				set.add(list);
			}
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				list.add(nums[i]);
				visited[i] = true;
				permute(nums, list, out, visited, set);
				visited[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
}
