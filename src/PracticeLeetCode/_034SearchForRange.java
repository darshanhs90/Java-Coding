package PracticeLeetCode;

import java.util.Arrays;

public class _034SearchForRange {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[]{1,1,1,1,1,2}, 1)));
		System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));
		System.out.println(Arrays.toString(searchRange(new int[]{1,4}, 4)));


	}
	public static int[] searchRange(int[] nums, int target) {
		if(nums==null||nums.length==0)
			return new int[]{-1,-1};
		int start=findStart(0,nums.length-1,nums,target);
		int end=findEnd(0,nums.length-1,nums,target);
		return new int[]{start,end};
	}
	private static int findEnd(int left, int right, int[] nums, int target) {
		if(left>right)
			return -1;
		int mid=(left+right)/2;
		if(nums[mid]==target && (mid==nums.length-1||nums[mid+1]!=target))
			return mid;
		else if(nums[mid]>target)
			return findEnd(left, mid-1, nums, target);
		else
			return findEnd(mid+1,right, nums, target);
	}
	private static int findStart(int left, int right, int[] nums, int target) {
		if(left>right)
			return -1;
		int mid=(left+right)/2;
		if(nums[mid]==target && (mid==0||nums[mid-1]!=target))
			return mid;
		else if(nums[mid]>=target)
			return findStart(left, mid-1, nums, target);
		else
			return findStart(mid+1,right, nums, target);
	}
}

