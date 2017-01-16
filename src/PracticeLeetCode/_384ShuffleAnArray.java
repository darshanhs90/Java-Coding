package PracticeLeetCode;

import java.util.Arrays;
import java.util.Random;

public class _384ShuffleAnArray {

	public static void main(String[] args) {
		Solution a=new Solution(new int[]{1,2,3,4,5});
		System.out.println(Arrays.toString(a.shuffle()));
		System.out.println(Arrays.toString(a.reset()));
		System.out.println(Arrays.toString(a.shuffle()));
	}

	static  class Solution {
		int[] original,shuffled;
		Random rand;
		public Solution(int[] nums) {
			original=nums;
			shuffled=Arrays.copyOf(nums, nums.length);
			rand=new Random();
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
				int temp=rand.nextInt(length-i)%(length-1);
				int val=shuffled[temp];
				shuffled[temp]=shuffled[i];
				shuffled[i]=val;
			}
			return shuffled;
		}
	}
}
