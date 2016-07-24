package eBayPrep;

import java.util.Arrays;

public class _033SearchInRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(search(new int[]{4,5,6,7,0,1,2}, 1));
		System.out.println(search(new int[]{1,3}, 3));
	}

	public static int search(int[] nums, int target) {
		return searchIndex(nums,0,nums.length-1,target);
	}

	private static int searchIndex(int[] arr, int low, int high, int target) {
		if(low>high)
			return -1;
		int mid=(low+high)/2;
		if(arr[mid]==target)
			return mid;
		if(arr[mid]>=arr[low]){
			if(target>=arr[low] && target<arr[mid]){
				return searchIndex(arr, low,mid-1, target);
			}else{
				return searchIndex(arr, mid+1, high, target);				
			}
		}		
		else
		{
			if(target>arr[mid] && target<=arr[high]){
				return searchIndex(arr, mid+1, high, target);
			}else{
				return searchIndex(arr, low, mid-1, target);				
			}
		}
	}
}
