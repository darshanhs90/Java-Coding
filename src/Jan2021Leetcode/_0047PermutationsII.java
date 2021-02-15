package Jan2021Leetcode;

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
		if (nums == null || nums.length == 0)
			return output;
		permute(nums, new HashSet<Integer>(), new ArrayList<Integer>(), output, new HashSet<List<Integer>>());
		return output;
	}

	public static void permute(int[] nums, HashSet<Integer> visitedIndex, List<Integer> list,
			List<List<Integer>> output, HashSet<List<Integer>> visitedOut) {

		if (list.size() == nums.length) {
			if (!visitedOut.contains(list)) {
				visitedOut.add(list);
				output.add(new ArrayList<Integer>(list));
			}
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visitedIndex.contains(i)) {
				visitedIndex.add(i);
				list.add(nums[i]);
				permute(nums, visitedIndex, list, output, visitedOut);
				list.remove(list.size() - 1);
				visitedIndex.remove(Integer.valueOf(i));
			}
		}
	}
}
