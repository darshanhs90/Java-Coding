package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _044PermutationsII {

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
		System.out.println(permuteUnique(new int[] { 1, 2, 3 }));
		System.out.println(permuteUnique(new int[] { 1 }));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		if (nums == null || nums.length == 0)
			return output;
		boolean[] visited = new boolean[nums.length];
		permuteUnique(nums, visited, new ArrayList<Integer>(), set, output);
		return output;
	}

	public static void permuteUnique(int[] nums, boolean[] visited, ArrayList<Integer> list, HashSet<List<Integer>> set,
			List<List<Integer>> output) {
		if (list.size() == nums.length) {
			if (!set.contains(list)) {
				set.add(list);
				output.add(new ArrayList<Integer>(list));
			}
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				list.add(nums[i]);
				visited[i] = true;
				permuteUnique(nums, visited, list, set, output);
				visited[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
}
