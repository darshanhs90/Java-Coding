package May2021PrepLeetcode;

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
		HashSet<List<Integer>> output = new HashSet<List<Integer>>();
		dfs(0, nums, new ArrayList<Integer>(), output);
		return new ArrayList<List<Integer>>(output);
	}

	public static void dfs(int index, int[] nums, List<Integer> temp, HashSet<List<Integer>> output) {
		output.add(new ArrayList<Integer>(temp));
		if (index >= nums.length)
			return;
		for (int i = index; i < nums.length; i++) {
			temp.add(nums[i]);
			dfs(i + 1, nums, temp, output);
			temp.remove(temp.size() - 1);
		}
	}
}
