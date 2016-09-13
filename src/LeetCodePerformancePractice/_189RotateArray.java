package LeetCodePerformancePractice;

import java.util.Arrays;

public class _189RotateArray {
	public static void main(String[] args) {
		rotate(new int[]{1,2,3},4);//5,6,7,1,2,3,4
	}
	public static void rotate(int[] nums, int k) {
		if(nums==null||nums.length<=1)
			return ;
		k=k>nums.length?k%nums.length:k;
		k=nums.length-k;
		nums=reverse(0,k-1,nums);
		nums=reverse(k,nums.length-1,nums);
		nums=reverse(0,nums.length-1,nums);
		System.out.println(Arrays.toString(nums));
	}
	private static int[] reverse(int i, int k,int[] nums) {
		if(i>k)
			return nums;
		while(i<k && i>=0 && k<nums.length)
		{
			int temp=nums[i];
			nums[i]=nums[k];
			nums[k]=temp;
			i++;k--;
		}
		return nums;
	}

}