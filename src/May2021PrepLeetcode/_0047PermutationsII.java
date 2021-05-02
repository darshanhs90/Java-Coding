package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0047PermutationsII {

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[] { 1, 2, 3 }));
		System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		HashSet<List<Integer>> out = new HashSet<List<Integer>>();
		dfs(nums, new ArrayList<Integer>(), out, new HashSet<Integer>());
		return new ArrayList<List<Integer>>(out);
	}

	public static void dfs(int[] nums, List<Integer> list, HashSet<List<Integer>> out, HashSet<Integer> visitedIndex) {
		if (list.size() == nums.length) {
			out.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visitedIndex.contains(i)) {
				visitedIndex.add(i);
				list.add(nums[i]);
				dfs(nums, list, out, visitedIndex);
				list.remove(list.size() - 1);
				visitedIndex.remove(i);
			}
		}
	}

}
