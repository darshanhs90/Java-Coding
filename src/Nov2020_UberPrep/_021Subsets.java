package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.List;

public class _021Subsets {

	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 2, 3 }));
		System.out.println(subsets(new int[] { 0 }));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		dfs(-1, nums, new ArrayList<Integer>(), output);
		return output;
	}

	public static void dfs(int index, int[] nums, List<Integer> list, List<List<Integer>> output) {
		output.add(new ArrayList<Integer>(list));
		for (int i = index; i < nums.length; i++) {
			if (i != index) {
				list.add(nums[i]);
				dfs(i, nums, list, output);
				list.remove(list.size() - 1);
			}
		}
	}

}
