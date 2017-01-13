package PracticeLeetCode;

import java.util.Arrays;

public class _026RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1}));
	}
    public static int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
        	return 0;
        int index=0;
        for (int i = 1; i < nums.length; i++) {
			if(nums[i]!=nums[index])
			{
				nums[++index]=nums[i];
			}
		}
        System.out.println(Arrays.toString(nums));
        return index+1;
    }

}

