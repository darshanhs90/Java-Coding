package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.List;

public class _043Permutations {

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 2, 3 }));
		System.out.println(permute(new int[] { 0, 1 }));
		System.out.println(permute(new int[] { 1 }));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return output;
		boolean[] visited = new boolean[nums.length];
		permute(nums, new ArrayList<Integer>(), output, visited);
		return output;
	}

	public static void permute(int[] nums, List<Integer> list, List<List<Integer>> output, boolean[] visited) {
		if (list.size() == nums.length) {
			output.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				list.add(nums[i]);
				visited[i] = true;
				permute(nums, list, output, visited);
				visited[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
}
