package LeetCodePerformancePractice;

public class _162FindPeakElement {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[]{1,2}));
	}
	public static int findPeakElement(int[] nums) {
		if(nums==null||nums.length<=1)
			return 0;
		if(nums.length==2)
		{
			if(nums[0]>nums[1])
				return 0;
			else
				return 1;
		}
		int left=0,right=nums.length-1;
		while(left<right)
		{	
			int mid=(left+(right-left)/2);
			if((mid==nums.length-1 || nums[mid]>=nums[mid+1] ) && (mid==0||nums[mid]>=nums[mid-1])){
				return mid;
			}
			else if(mid>0 && nums[mid]>nums[mid-1])
			{
				left=mid+1;
			}
			else
				right=mid-1;
		}
		return -1;
	}
}
