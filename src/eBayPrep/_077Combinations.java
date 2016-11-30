package eBayPrep;

import java.util.Arrays;

public class _077Combinations {


	public static void main(String[] args) {
		sortColors(new int[]{1,2,0,2,1,0,2,2,0,1,2,0,1,2,0,1,0,2,0,1,2});
	}									


	public static void sortColors(int[] nums) {
		int zeroCount=0,onesCount=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0)
				zeroCount++;
			else if(nums[i]==1)
				onesCount++;
		}
		for (int i = 0; i < nums.length; i++) {
			if(zeroCount>0){
				nums[i]=0;
				zeroCount--;
			}else if(onesCount>0){
				nums[i]=1;
				onesCount--;
			}else
				nums[i]=2;
		}

		System.out.println(Arrays.toString(nums));
	}
}

