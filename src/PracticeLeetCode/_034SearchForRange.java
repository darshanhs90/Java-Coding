package PracticeLeetCode;

import java.util.Arrays;

public class _034SearchForRange {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[]{1,1,2}, 1)));
		System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));
		
	}
	public static int[] searchRange(int[] nums, int target) {
		if(nums==null||nums.length==0)
			return new int[]{-1,-1};
		int start=findStart(nums,target);
		int end=findEnd(nums,target);
		return new int[]{start,end};
	}
	private static int findStart(int[] nums, int target) {
		int left=0,right=nums.length-1;
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(nums[mid]==target &&(mid==0||nums[mid-1]!=target))
				return mid;
			else if(nums[mid]<target)
				left=mid+1;
			else
				right=mid-1;
		}
		return -1;
	}
	private static int findEnd(int[] nums, int target) {
		int left=0,right=nums.length-1;
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(nums[mid]==target &&(mid==nums.length-1||nums[mid+1]!=target))
				return mid;
			else if(nums[mid]>target)
				right=mid-1;
			else
				left=mid+1;
		}
		return -1;
	}
}

