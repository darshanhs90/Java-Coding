package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Link : https://leetcode.com/problems/rotate-array/
 */

public class _189RotateArray {

	public static void main(String[] args) {
		int nums[]=new int[]{1,2/*,3,4,5,6,7*/};
		rotate(nums,1);
		System.out.println(Arrays.toString(nums));
	}

	public static void rotate(int[] nums, int k) {
		if(nums.length==0||k==0||k%nums.length==0)
			return;
		if(k>nums.length)
			k=k%nums.length;
		System.out.println(k);
		int []first=Arrays.copyOfRange(nums, nums.length-k,nums.length);
		ArrayList<Integer> list=new ArrayList<>();
		for (int i = 0; i < first.length; i++) {
			list.add(first[i]);
		}
		int last[]=new int[nums.length-first.length];
		for (int i = 0; i < nums.length-k; i++) {
			list.add(nums[i]);
		}
		for (int i = 0; i < list.size(); i++) {
			nums[i]=list.get(i);
		}
		System.out.println(Arrays.toString(nums));
		
		
	}
}