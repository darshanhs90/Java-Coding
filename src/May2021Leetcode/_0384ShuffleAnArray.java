package May2021Leetcode;

import java.util.Arrays;

public class _0384ShuffleAnArray {

	public static void main(String[] args) {
		Solution solution = new Solution(new int[] { 1, 2, 3 });
		System.out.println(Arrays.toString(solution.shuffle())); // Shuffle the array [1,2,3] and return its result. Any
																	// permutation of [1,2,3]
		// must be equally likely to be returned. Example: return [3, 1, 2]
		System.out.println(Arrays.toString(solution.reset())); // Resets the array back to its original configuration
																// [1,2,3]. Return [1, 2, 3]
		System.out.println(Arrays.toString(solution.shuffle())); // Returns the random shuffling of array [1,2,3].

	}

	static class Solution {

		public Solution(int[] nums) {
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
		}

		public void swap(int left, int right, int[] nums) {
		}

	}

}
