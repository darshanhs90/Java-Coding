package PracticeLeetCode;

import java.util.Arrays;

public class _189RotateArray {
	public static void main(String[] args) {
		rotate(new int[]{1,2,3},4);//5,6,7,1,2,3,4
		rotate(new int[]{1,2,3,4,5,6,7},4);//5,6,7,1,2,3,4
		rotate(new int[]{1,2},1);//5,6,7,1,2,3,4
		
		
	}
	public static void rotate(int[] nums, int k) {
		int length=nums.length;
		if(k>length)
			k=k%length;
		if(nums==null||nums.length==0||k==0)
			return;
		k=length-k;
		System.out.println(k);
		nums=reverse(0,k-1,nums);
		nums=reverse(k,nums.length-1,nums);
		nums=reverse(0,nums.length-1,nums);
		System.out.println(Arrays.toString(nums));
	}
	private static int[] reverse(int left, int right,int[] nums) {
		while(left<right && left>=0 && right<nums.length)
		{
			int temp=nums[left];
			nums[left]=nums[right];
			nums[right]=temp;
			left++;
			right--;
		}
		return nums;
	}
}