package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Link : https://leetcode.com/problems/single-number-iii/
 */

public class _260SingleNumber3 {
	public static int[] singleNumber(int[] nums) {
		int output[]=new int[2];
		ArrayList<Integer> list=new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			System.out.println(Arrays.toString(list.toArray()));
		  	if(!list.contains(nums[i]))
		  		list.add(nums[i]);
		  	else
		  		list.remove((Integer)nums[i]);	
		}
		System.out.println(Arrays.toString(list.toArray()));
		for (int i = 0; i < list.size(); i++) {
			output[i]=(int)list.get(i);
		}
		return output;
	}
	public static void main(String[] args) {
	System.out.println(Arrays.toString(singleNumber(new int[]{1,2,3,4,3,2,6,1})));	
	}
}