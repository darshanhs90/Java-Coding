package Dec2020Leetcode;

import java.util.Arrays;

public class _1470ShuffleTheArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3)));
		System.out.println(Arrays.toString(shuffle(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }, 4)));
		System.out.println(Arrays.toString(shuffle(new int[] { 1, 1, 2, 2 }, 2)));
	}

	public static int[] shuffle(int[] nums, int n) {
		int[] output = new int[nums.length];
		int left = 0, right = n;
		int index = 0;
		while (right < nums.length) {
			output[index++] = nums[left];
			output[index++] = nums[right];
			left++;
			right++;
		}
		return output;
	}
}
