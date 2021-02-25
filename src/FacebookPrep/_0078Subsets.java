package FacebookPrep;

import java.util.ArrayList;
import java.util.List;

public class _0078Subsets {

	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 2, 3 }));
		System.out.println(subsets(new int[] { 0 }));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return output;

		dfs(0, nums, new ArrayList<Integer>(), output);
		return output;
	}

	public static void dfs(int index, int[] nums, List<Integer> list, List<List<Integer>> output) {
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
