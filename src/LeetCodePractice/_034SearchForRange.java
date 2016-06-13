package LeetCodePractice;

import java.util.Arrays;

public class _034SearchForRange {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[]{2,2,3},3)));
	}

	public static int[] searchRange(int[] nums, int target) {
		int startPos=findStart(nums,target,0,nums.length-1);
		int endPos=findEnd(nums,target,0,nums.length-1);
		return new int[]{startPos,endPos};
	}



	private static int findStart(int[] nums, int target, int start, int end) {
		if(start>end)
			return -1;
		int mid=(start+end)/2;
		if(nums[mid]==target && (mid==0 || nums[mid-1]<target))
		{
			return mid;
		}
		else if(nums[mid]<target){
			return findStart(nums, target, mid+1, end);
		}
		else{
			return findStart(nums, target, start, mid-1);
		}
	}
	
	private static int findEnd(int[] nums, int target, int start, int end) {
		if(start>end)
			return -1;
		int mid=(start+end)/2;
		if(nums[mid]==target && (mid==nums.length-1 ||nums[mid+1]>target))
		{
			return mid;
		}
		else if(nums[mid]>target){
			return findEnd(nums, target, start, mid-1);
		}else {
			return findEnd(nums, target, mid+1, end);
		}
	}
}
