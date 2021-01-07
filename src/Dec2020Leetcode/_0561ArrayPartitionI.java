package Dec2020Leetcode;

import java.util.Arrays;

public class _0561ArrayPartitionI {
	public static void main(String[] args) {
		System.out.println(arrayPairSum(new int[] { 1, 4, 3, 2 }));
		System.out.println(arrayPairSum(new int[] { 6, 2, 6, 5, 1, 2 }));
	}

	public static int arrayPairSum(int[] nums) {
		int sum = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i += 2) {
			sum += nums[i];
		}
		return sum;
	}
}
