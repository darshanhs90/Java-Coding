package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _047Subsets {

	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 2, 3 }));
		System.out.println(subsets(new int[] { 0 }));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return output;
		subsets(0, nums, new ArrayList<Integer>(), output, new HashSet<List<Integer>>());
		return output;
	}

	public static void subsets(int index, int[] nums, List<Integer> list, List<List<Integer>> output,
			HashSet<List<Integer>> set) {
		if (index > nums.length)
			return;
		if (!set.contains(list)) {
			output.add(new ArrayList<Integer>(list));
			set.add(list);
		}
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			subsets(i + 1, nums, list, output, set);
			list.remove(list.size() - 1);
		}
	}
}
