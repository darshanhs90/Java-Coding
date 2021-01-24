package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0698PartitionToKEqualSumSubsets {

	public static void main(String[] args) {
		//System.out.println(canPartitionKSubsets(new int[] { 4, 3, 2, 3, 5, 2, 1 }, 4));
		System.out.println(canPartitionKSubsets(new int[] { 10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6 }, 3));
	}

	static boolean sumFound = false;

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % k != 0)
			return false;
		System.out.println(sum);
		System.out.println(sum/k);
		
		HashSet<Integer> visitedIndex = new HashSet<Integer>();
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for (int i = 0; i < k; i++) {
			sumFound = false;
			dfs(nums, 0, sum / k, visitedIndex, new ArrayList<Integer>(), output);
			if (!sumFound)
				break;
			visitedIndex.addAll(output.get(output.size() - 1));

		}
		System.out.println(output);
		return output.size() == k;
	}

	public static void dfs(int[] nums, int currSum, int sum, HashSet<Integer> visitedIndex, List<Integer> list,
			List<List<Integer>> output) {
		if (currSum > sum || sumFound) {
			return;
		}
		if (currSum == sum) {
			output.add(new ArrayList<Integer>(list));
			sumFound = true;
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visitedIndex.contains(i)) {
				visitedIndex.add(i);
				list.add(i);
				dfs(nums, currSum + nums[i], sum, visitedIndex, list, output);
				list.remove(Integer.valueOf(i));
				visitedIndex.remove(i);
			}
		}
	}

}
