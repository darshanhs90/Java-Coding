package LeetCodePerformancePractice;

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
		int left=0,right=nums.length-1;
		while(left<right)
		{
			if(nums[left]+nums[right]==target)
				return new int[]{left+1,right+1};
			else if(nums[left]+nums[right]>target)
				right--;
			else
				left++;
		}
		return null;
	}
}
