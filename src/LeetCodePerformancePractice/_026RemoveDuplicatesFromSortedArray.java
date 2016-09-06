package LeetCodePerformancePractice;

public class _026RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,2,3}));
	}
	public static int removeDuplicates(int[] nums) {
		if(nums==null||nums.length<=1)
			return nums==null?0:nums.length;
		int index=1;
		int number=nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(number!=nums[i])
			{
				nums[index]=nums[i];
				index++;
				number=nums[i];
			}
		}
		return index;
	}




}

