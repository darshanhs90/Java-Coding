package PracticeLeetCode;

public class _153MinimumInRotatedSortedArray {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
	}
	public static int findMin(int[] nums) {
		if(nums==null||nums.length==0)
			return -1;
		int left=0,right=nums.length-1;
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(nums[left]<=nums[right])
				return nums[left];
			if(nums[mid]>nums[left])
				left=mid+1;
			else
				right=mid-1;
		}
		return -1;
	}
}
