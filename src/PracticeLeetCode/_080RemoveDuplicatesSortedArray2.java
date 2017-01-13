package PracticeLeetCode;

import java.util.Arrays;

public class _080RemoveDuplicatesSortedArray2 {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,1,1,2,3}));
	}
	public static int removeDuplicates(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		if(nums.length<=2)
			return nums.length;
		int index=1;
		int prev=nums[0];
		int count=1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]==prev && count==1)
			{
				nums[index]=nums[i];
				count++;
				index++;
			}
			else if(nums[i]!=prev)
			{
				nums[index]=nums[i];
				prev=nums[i];
				index++;
				count=1;
			}
		}
		System.out.println(Arrays.toString(nums));
		return index;
	}
}
