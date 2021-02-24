package Jan2021Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class _0645SetMismatch {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findErrorNums(new int[] { 1, 2, 2, 4 })));
		System.out.println(Arrays.toString(findErrorNums(new int[] { 1, 1 })));
		System.out.println(Arrays.toString(findErrorNums(new int[] { 2, 2 })));
	}

	public static int[] findErrorNums(int[] nums) {
		int sum = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		int dupNumber = 0;
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				dupNumber = nums[i];
			} else {
				set.add(nums[i]);
				sum += nums[i];
			}
		}

		int actualSum = (nums.length * (nums.length + 1)) / 2;
		int missingNum = actualSum - sum;
		return new int[] { dupNumber, missingNum };
	}
}
