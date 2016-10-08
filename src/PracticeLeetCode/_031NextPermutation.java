package PracticeLeetCode;

import java.util.Arrays;

public class _031NextPermutation {
	public static void main(String[] args) {
		nextPermutation(new int[]{1,2,3,5,4});
		nextPermutation(new int[]{3,1,2});
	}
	public static void nextPermutation(int[] nums) {
		if(nums==null||nums.length<2)
			return ;
		int p=0,q=0;
		for (int i = nums.length-2;i>=0;i--) {
			if(nums[i]<nums[i+1]){
				p=i;
				break;
			}
		}

		for (int i = nums.length-1;i>=0;i--) {
			if(nums[i]>nums[p])
			{
				q=i;
				break;
			}
		}
		if(p==0&&q==0)
		{
			nums=swapArray(0,nums.length-1,nums);
		}else{
			int temp=nums[p];
			nums[p]=nums[q];
			nums[q]=temp;
			p++;
			nums=swapArray(p,nums.length-1,nums);
		}
		System.out.println(Arrays.toString(nums));
	}
	private static int[] swapArray(int left, int right, int[] nums) {
		while(left<right){
			int temp=nums[left];
			nums[left]=nums[right];
			nums[right]=temp;
			left++;
			right--;
		}
		return nums;
	}
}

