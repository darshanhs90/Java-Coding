package eBayPrep;

import java.util.Arrays;

public class _034SearchForRange {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10},8)));
	}

	public static int[] searchRange(int[] nums, int target) {
		int startPosition=findStart(nums,0,nums.length-1,target);
		int endPosition=findEnd(nums,0,nums.length-1,target);
		return new int[]{startPosition,endPosition};
	}

	private static int findStart(int[] arr, int low, int high, int target) {
		if(low>high)
			return -1;
		int mid=(low+high)/2;
		if((arr[mid]==target)&&(mid==0 || arr[mid-1]!=target))
			return mid;
		else if(arr[mid]<target)
		{
			return findStart(arr, mid+1, high, target);
		}
		else		
			return findStart(arr, low, mid-1, target);
	}

	private static int findEnd(int[] arr, int low, int high, int target) {
		if(low>high)
			return -1;
		int mid=(low+high)/2;
		if((arr[mid]==target)&&(mid==arr.length-1 || arr[mid+1]!=target))
			return mid;
		else if(arr[mid]>target)
		{		
			return findEnd(arr, low, mid-1, target);
		}
		else
			return findEnd(arr, mid+1, high, target);
	}

}
