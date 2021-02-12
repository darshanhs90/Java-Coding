package Jan2021Leetcode;

import java.util.Arrays;
import java.util.Random;

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
		int[] originalArray;
		Random rand;

		public Solution(int[] nums) {
			this.originalArray = nums;
			rand = new Random();
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			return this.originalArray;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			int[] copy = Arrays.copyOf(originalArray, originalArray.length);

			for (int i = 0; i < copy.length; i++) {
				int newIndex = rand.nextInt(copy.length);
				swap(newIndex, i, copy);
			}
			return copy;
		}

		public void swap(int left, int right, int[] nums) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
		}
	}
}
