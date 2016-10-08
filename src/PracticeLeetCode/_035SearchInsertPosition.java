package PracticeLeetCode;

public class _035SearchInsertPosition {
	public static void main(String[] args) {
		System.out.println(searchInsert(new int[]{1,3,5,6}, 5));//2
		System.out.println(searchInsert(new int[]{1,3,5,6}, 2));//1
		System.out.println(searchInsert(new int[]{1,3,5,6}, 7));//4
		System.out.println(searchInsert(new int[]{1,3,5,6}, 0));//0
	}
	public static int searchInsert(int[] nums, int target) {
		if(nums==null||nums.length==0)
			return -1;
		return findStart(nums,target);	
	}
	private static int findStart(int[] nums, int target) {
		int left=0,right=nums.length-1;
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(nums[mid]==target)
				return mid;
			else if(nums[mid]<target)
				left=mid+1;
			else
				right=mid-1;
		}
		return Math.max(left, right);
	}

}

