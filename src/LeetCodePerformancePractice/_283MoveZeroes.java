package LeetCodePerformancePractice;

import java.util.Arrays;

public class _283MoveZeroes {
	public static void main(String[] args) {
		moveZeroes(new int[]{1, 0, 0, 3, 12});
		moveZeroes(new int[]{0, 1, 0, 3, 12});
	}
	public static void moveZeroes(int[] nums) {
		if(nums==null||nums.length<=1)
			return;
		int left=0,right=left+1;
		while(left<nums.length && right<nums.length)
		{
			while(left<nums.length && nums[left]!=0)
			{
				left++;
			}
			right=left+1;
			while(right<nums.length && right>left && nums[right]==0)
			{
				right++;
			}
			if(left<nums.length && right<nums.length)
			{
				int temp=nums[left];
				nums[left]=nums[right];
				nums[right]=temp;
				left++;
				right++;
			}
		}
		System.out.println(Arrays.toString(nums));
	}
	public static void moveZeroes1(int[] nums) {
		if(nums==null||nums.length<=1)
			return;
		int left=0,right=nums.length-1;
		while(left<right)
		{
			if(nums[left]==0 && nums[right]!=0)
			{
				int temp=nums[left];
				nums[left]=nums[right];
				nums[right]=temp;
				left++;
				right--;
			}
			else if(nums[left]!=0)
			{
				left++;
			}
			else{
				right--;
			}
		}
		System.out.println(Arrays.toString(nums));


	}


}
