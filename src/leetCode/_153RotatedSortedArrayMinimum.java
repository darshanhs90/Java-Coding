package leetCode;

/*
 * Link : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/	
 */

public class _153RotatedSortedArrayMinimum {
	public static int findMin(int[] nums) {
		if(nums.length<1)
			return 0;
		else if(nums.length==1)
			return nums[0];
		else{
			int start=0;
			int end=nums.length-1;
			while(start<end)
			{
				int mid=(start+end)/2;

				if(mid-1>=0 && nums[mid-1]>nums[mid]){
					return nums[mid];
				}
				else{
					if(nums[mid]>nums[end])
						start=mid+1;
					else
						end=mid-1;
				}
			}
			return nums[start];
		}
	}
	public static void main(String[] args) {
		System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
	}

}