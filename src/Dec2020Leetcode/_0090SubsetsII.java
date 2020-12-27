package Dec2020Leetcode;

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
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		dfs(0, nums, new ArrayList<Integer>(), output, new HashSet<List<Integer>>());
		return output;
	}

	public static void dfs(int index, int[] nums, List<Integer> list, List<List<Integer>> output,
			HashSet<List<Integer>> set) {
		if (!set.contains(list)) {
			output.add(new ArrayList<Integer>(list));
			set.add(list);
		}
		if (index >= nums.length)
			return;

		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(i + 1, nums, list, output, set);
			list.remove(list.size() - 1);
		}
	}
}
