package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0416PartitionEqualSubsetSum {

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 5, 11, 5 }));
		System.out.println(canPartition(new int[] { 1, 2, 3, 5 }));
		System.out.println(canPartition(new int[] { -2, -1, 1, 2 }));
	}

	static boolean found;

	public static boolean canPartition(int[] nums) {
		int partitions = 2;
		int sum = 0;
		found = false;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		if (sum % partitions != 0)
			return false;
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		dfs(0, sum / partitions, nums, new HashSet<Integer>(), list, output);
		System.out.println(output);
		return found;
	}

	public static void dfs(int currSum, int requiredSum, int[] nums, HashSet<Integer> visited, List<Integer> list,
			List<List<Integer>> output) {
		if (currSum == requiredSum && output.size() != 2) {
			output.add(new ArrayList<Integer>(list));
			if (output.size() == 2) {
				found = true;
				return;
			}
			currSum = 0;
			list.clear();
		}
		if (currSum > requiredSum || output.size() == 2 || found == true)
			return;

		for (int i = 0; i < nums.length; i++) {
			if (!visited.contains(i)) {
				list.add(nums[i]);
				visited.add(i);
				dfs(currSum + nums[i], requiredSum, nums, visited, list, output);
				if (list.size() > 0)
					list.remove(list.size() - 1);
				visited.remove(i);
			}
		}
	}

}
