package PracticeLeetCode;

import java.util.Arrays;

public class _080RemoveDuplicatesSortedArray2 {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
	}
	public static int removeDuplicates(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		if(nums.length<2)
			return 1;
		int prev=nums[0],index=1,count=1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]==prev && count==1)
			{
				nums[index]=prev;
				index++;
				count++;
			}
			else if(nums[i]!=prev)
			{
				prev=nums[i];
				nums[index]=prev;
				index++;
				count=1;
			}
		}
		System.out.println(Arrays.toString(nums));
		return index;
	}
}
