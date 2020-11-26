package Nov2020Leetcode;

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
		int[] originalArr;
		Random random;

		public Solution(int[] nums) {
			this.originalArr = nums;
			random = new Random();
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			return originalArr;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			if (originalArr == null)
				return null;
			int randomArr[] = originalArr.clone();
			for (int i = 1; i < originalArr.length; i++) {
				int newIndex = random.nextInt(i + 1);
				swap(i, newIndex, randomArr);
			}
			return randomArr;
		}

		public void swap(int x, int y, int[] arr) {
			int temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
		}

	}

}
