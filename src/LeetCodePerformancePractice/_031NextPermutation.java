package LeetCodePerformancePractice;

import java.util.Arrays;

public class _031NextPermutation {
	public static void main(String[] args) {
		nextPermutation(new int[]{1,2,3,5,4});
		nextPermutation(new int[]{3,1,2});
	}
	public static void nextPermutation(int[] nums) {
		if(nums==null||nums.length<2)
			return;
		int p=0,q=0;
		for (int i = nums.length-2; i >=0; i--) {
			if(nums[i]<nums[i+1]){
				p=i;
				break;
			}
		}
		for (int i = nums.length-1; i >=0; i--) {
			if(nums[i]>nums[p]){
				q=i;
				break;
			}
		}
		if(p==0 && q==0)
		{
			nums=performSwap(nums,0,nums.length-1);
		}
		else{
			int temp=nums[p];
			nums[p]=nums[q];
			nums[q]=temp;
			p++;
			q=nums.length-1;
			nums=performSwap(nums,p,q);	
		}
		System.out.println(Arrays.toString(nums));
	}
	private static int[] performSwap(int[] nums, int p, int q) {
		while(p<q)
		{
			int temp=nums[p];
			nums[p]=nums[q];
			nums[q]=temp;
			p++;
			q--;
		}
		return nums;

	}

}

