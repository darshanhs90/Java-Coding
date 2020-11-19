package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0090SubsetsII {

	public static void main(String[] args) {
		System.out.println(subsetsWithDup(new int[] { 1, 2, 2 }));
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		Arrays.parallelSort(nums);
		subsetsWithDup(0, nums, new ArrayList<Integer>(), output, set);
		return output;
	}

	public static void subsetsWithDup(int index, int[] nums, List<Integer> list, List<List<Integer>> output,
			HashSet<List<Integer>> set) {
		if (index > nums.length)
			return;
		if (!set.contains(list)) {
			set.add(new ArrayList<Integer>(list));
			output.add(new ArrayList<Integer>(list));
		}

		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			subsetsWithDup(i + 1, nums, list, output, set);
			list.remove(list.size() - 1);
		}
	}
}
