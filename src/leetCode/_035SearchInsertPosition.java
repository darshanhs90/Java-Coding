package leetCode;

/*
 * Link : https://leetcode.com/problems/implement-strstr/
 */

public class _035SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {		
		int start=0;
		int end=nums.length-1;
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(nums[mid]<target)
				start=mid+1;
			else if(nums[mid]>target)
				end=mid-1;
			else
				return mid;
				
		}		
		if(start>nums.length-1)
			return start;
		return end>=0?end+1:0;
	}

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[]{1,3,5,6},5));
		System.out.println(searchInsert(new int[]{1,3,5,6},2));
		System.out.println(searchInsert(new int[]{1,3,5,6},7));
		System.out.println(searchInsert(new int[]{1,3,5,6},0));
		
	}
}