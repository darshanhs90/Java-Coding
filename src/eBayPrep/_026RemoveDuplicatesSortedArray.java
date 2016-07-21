package LeetCodePractice;

public class _026RemoveDuplicatesSortedArray {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,2,2,2,2,2,2,3}));
	}

	public static int removeDuplicates(int[] nums) {
		if(nums.length<2)
			return nums.length;
		int pointer=0;
		for (int i = 0; i < nums.length; i++) {
			if(i!=0)
			{
				if(nums[i]!=nums[i-1])
				{
					nums[pointer]=nums[i];
					pointer++;
				}
			}
			else{
				pointer++;
			}
		}
		return pointer;
	}
}
