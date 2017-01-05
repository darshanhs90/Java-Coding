package PracticeLeetCode;

import java.util.Arrays;
import java.util.Random;

public class _384ShuffleAnArray {

	public static void main(String[] args) {
		Solution a=new Solution(new int[]{1,2,3});
		System.out.println(Arrays.toString(a.shuffle()));
		System.out.println(Arrays.toString(a.reset()));
		System.out.println(Arrays.toString(a.shuffle()));
	}

	static public class Solution {
		int[] original,shuffled;
		Random r;
		public Solution(int[] nums) {
			original=nums;
			shuffled=Arrays.copyOf(nums, nums.length);
			r=new Random(nums.length);
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			shuffled=Arrays.copyOf(original, original.length);
			return shuffled;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			int length=original.length;
			for (int i = 0; i < original.length; i++) {
				int index=r.nextInt(length-i)%(length-1);
				int temp=shuffled[index];
				shuffled[index]=shuffled[i];
				shuffled[i]=temp;
			}
			return shuffled;
		}
	}
}
