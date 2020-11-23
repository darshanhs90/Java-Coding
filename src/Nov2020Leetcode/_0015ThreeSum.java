package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0015ThreeSum {

	public static void main(String[] args) {
		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(threeSum(new int[] {}));
		System.out.println(threeSum(new int[] { 0 }));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.parallelSort(nums);
		Set<List<Integer>> set = new HashSet<List<Integer>>();

		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
				} else if (sum > 0) {
					k--;
				} else {
					j++;
				}
			}
		}
		return new ArrayList<List<Integer>>(set);
	}
}
