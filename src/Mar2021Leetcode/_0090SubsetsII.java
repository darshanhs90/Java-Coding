package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0090SubsetsII {

	public static void main(String[] args) {
		System.out.println(subsetsWithDup(new int[] { 1, 2, 2 }));
		System.out.println(subsetsWithDup(new int[] { 4, 4, 4, 1, 4 }));
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		HashSet<List<Integer>> out = new HashSet<List<Integer>>();
		dfs(0, nums, new ArrayList<Integer>(), out);
		return new ArrayList<List<Integer>>(out);
	}

	public static void dfs(int index, int[] nums, List<Integer> list, HashSet<List<Integer>> out) {
		out.add(new ArrayList<Integer>(list));
		if (index >= nums.length)
			return;
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(i + 1, nums, list, out);
			list.remove(list.size() - 1);
		}
	}
}
