package Leetcode2020Nov;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _0645SetMismatch {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findErrorNums(new int[] { 1, 2, 2, 4 })));
	}

	public static int[] findErrorNums(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;
		int repeatedNumber = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (set.contains(nums[i])) {
				repeatedNumber = nums[i];
			}
			set.add(nums[i]);
		}
		sum -= repeatedNumber;
		int totalSum = nums.length * (nums.length + 1) / 2;
		int missingNumber = totalSum - sum;
		return new int[] { repeatedNumber, missingNumber };
	}
}
