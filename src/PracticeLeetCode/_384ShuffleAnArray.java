package LeetCodePerformancePractice;

import java.util.Arrays;
import java.util.Random;

public class _384ShuffleAnArray {
	
	public static void main(String[] args) {
		_384ShuffleAnArray a=new _384ShuffleAnArray(new int[]{1,2,3});
		System.out.println(Arrays.toString(a.shuffle()));
		System.out.println(Arrays.toString(a.reset()));
		System.out.println(Arrays.toString(a.shuffle()));
	}
}
