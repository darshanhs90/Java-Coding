package PracticeLeetCode;

public class _167InputArraySortedSum {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {

	}
	public int[] twoSum(int[] nums, int target) {
		if(nums==null||nums.length==0)
			return null;
		int left=0,right=nums.length-1;
		while(left<right)
		{
			int sum=nums[left]+nums[right];
			if(sum==target)
				return new int[]{left+1,right+1};
			else if(sum>target)
				right--;
			else
				left++;
		}
		return null;
	}
}
