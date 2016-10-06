package LeetCodePerformancePractice;

import java.util.Arrays;
import java.util.Random;

public class _384ShuffleAnArray {
	int[] original;
	int shuffled[];
	Random r;
	public _384ShuffleAnArray(int[] nums) {
		original=nums;
		shuffled=Arrays.copyOf(nums, nums.length);
		r=new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		shuffled=Arrays.copyOf(original, original.length);
		return shuffled;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int length=shuffled.length;
		for (int i = 0; i < shuffled.length; i++) {
			int index=r.nextInt(length-i)%(length-1);
			int temp=shuffled[i];
			shuffled[i]=shuffled[index+1];
			shuffled[index+1]=temp;
		}
		return shuffled;
	}
	public static void main(String[] args) {
		_384ShuffleAnArray a=new _384ShuffleAnArray(new int[]{1,2,3});
		System.out.println(Arrays.toString(a.shuffle()));
		System.out.println(Arrays.toString(a.reset()));
		System.out.println(Arrays.toString(a.shuffle()));
	}
}
