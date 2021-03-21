package Feb2021Leetcode;

import java.util.HashSet;

public class _0698PartitionToKEqualSumSubsets {

	public static void main(String[] args) {
		System.out.println(canPartitionKSubsets(new int[] { 4, 3, 2, 3, 5, 2, 1 }, 4));
		System.out.println(canPartitionKSubsets(new int[] { 10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6 }, 3));
	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % k != 0)
			return false;
		return dfs(sum / k, nums, 0, k, visited);
	}

	public static boolean dfs(int requiredSum, int[] nums, int currSum, int k, HashSet<Integer> visited) {
		if (currSum > requiredSum)
			return false;
		if (currSum == requiredSum) {
			k--;
			currSum = 0;
		}
		if (k == 0)
			return true;

		boolean out = false;
		for (int i = 0; i < nums.length; i++) {
			if (!visited.contains(i)) {
				visited.add(i);
				out = out || dfs(requiredSum, nums, currSum + nums[i], k, visited);
				visited.remove(i);
			}
		}
		return out;
	}

}
