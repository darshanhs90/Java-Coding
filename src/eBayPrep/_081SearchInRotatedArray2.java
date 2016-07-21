package LeetCodePractice;

import java.util.Arrays;

public class _081SearchInRotatedArray2 {


	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,1,2,3,3}));
	}									


	public static int removeDuplicates(int[] nums) {
		int outputCount=0;
		int prevElement=Integer.MIN_VALUE;
		int prevElementCounter=0;
		for (int i = 0; i < nums.length; i++) {
			if(i==0)
			{
				prevElement=nums[i];
				prevElementCounter=1;
				outputCount+=1;
			}
			else{
				if(nums[i]==prevElement && prevElementCounter<2)
				{
					nums[outputCount]=nums[i];
					outputCount+=1;
					prevElementCounter=2;
				}
				else if(nums[i]!=prevElement ){
					nums[outputCount]=nums[i];
					outputCount+=1;
					prevElementCounter=1;
					prevElement=nums[i];
				}
			}
		}
		System.out.println(Arrays.toString(nums));
		return outputCount;
	}

}

