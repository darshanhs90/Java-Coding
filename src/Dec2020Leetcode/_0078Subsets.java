package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0078Subsets {

	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 2, 3 }));
		System.out.println(subsets(new int[] { 0 }));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		dfs(0, nums, new ArrayList<Integer>(), output, new HashSet<List<Integer>>());
		return output;
	}

	public static void dfs(int index, int[] nums, List<Integer> list, List<List<Integer>> output,
			HashSet<List<Integer>> set) {

		if (!set.contains(list)) {
			output.add(new ArrayList<Integer>(list));
			set.add(list);
		}
		if (index > nums.length - 1)
			return;

		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(i + 1, nums, list, output, set);
			list.remove(list.size() - 1);
		}
	}

}
