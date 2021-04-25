package April2021PrepLeetcode;

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
		HashSet<List<Integer>> output = new HashSet<List<Integer>>();
		if (nums == null || nums.length == 0)
			return new ArrayList<List<Integer>>(output);
		Arrays.sort(nums);
		dfs(0, nums, new ArrayList<Integer>(), output);
		return new ArrayList<List<Integer>>(output);
	}

	public static void dfs(int index, int[] nums, List<Integer> list, HashSet<List<Integer>> output) {
		output.add(new ArrayList<Integer>(list));
		if (index >= nums.length)
			return;
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(i + 1, nums, list, output);
			list.remove(list.size() - 1);
		}
	}
}
