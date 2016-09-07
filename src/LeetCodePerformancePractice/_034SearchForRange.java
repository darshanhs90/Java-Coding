package LeetCodePerformancePractice;

import java.util.Arrays;

public class _034SearchForRange {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));
	}
	public static int[] searchRange(int[] nums, int target) {
		if(nums==null||nums.length==0)
			return new int[]{-1,-1};
		int start=findStart(nums,0,nums.length-1,target);
		int end=findEnd(nums,0,nums.length-1,target);
		return new int[]{start,end};
	}
	private static int findEnd(int[] arr, int left, int right, int target) {
		if(left<=right)
		{
			int mid=(left+right)/2;
			if(arr[mid]==target &&(mid==arr.length-1||arr[mid+1]!=target))
				return mid;
			else if(arr[mid]>target)
			{
				return findEnd(arr, left, mid-1, target);
			}
			else{	
				return findEnd(arr, mid+1, right, target);
			}
		}
		return -1;
	}
	private static int findStart(int[] arr, int left, int right, int target) {
		if(left<=right)
		{
			int mid=(left+right)/2;
			if(arr[mid]==target &&(mid==0||arr[mid-1]!=target))
				return mid;
			else if(arr[mid]<target)
			{
				return findStart(arr, mid+1, right, target);
			}
			else{	
				return findStart(arr, left, mid-1, target);
			}
		}
		return -1;
	}

}

