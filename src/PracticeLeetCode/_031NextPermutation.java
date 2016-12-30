package PracticeLeetCode;

import java.util.Arrays;

public class _031NextPermutation {
	public static void main(String[] args) {
		nextPermutation(new int[]{1,2,3,5,4});
		nextPermutation(new int[]{3,1,2});
		nextPermutation(new int[]{3,2,1});
		nextPermutation(new int[]{1,1,5});
		nextPermutation(new int[]{1,2});
	}
	public static void nextPermutation(int[] nums) {
		if(nums==null||nums.length<=1)
			return;
		int p=0,q=0;
		for (int i = nums.length-2; i >=0; i--) {
			if(nums[i]<nums[i+1])
			{
				p=i;
				break;
			}
		}
		for (int i = nums.length-1; i >=0; i--) {
			if(nums[i]>nums[p])
			{
				q=i;
				break;
			}
		}
		if(p==0 && q==0)
		{
			nums=reverseArr(nums,0,nums.length-1);
		}
		else{
			int temp=nums[p];
			nums[p]=nums[q];
			nums[q]=temp;
			p++;
			nums=reverseArr(nums,p,nums.length-1);
		}
		System.out.println(Arrays.toString(nums));
	}
	private static int[] reverseArr(int[] nums, int p, int q) {
		while(p<q){
			int temp=nums[p];
			nums[p]=nums[q];
			nums[q]=temp;
			p++;
			q--;
		}
		return nums;
	}
}

