package PracticeLeetCode;

import java.util.Arrays;

public class _027RemoveElement {
	public static void main(String[] args) {
		System.out.println(removeElement(new int[]{3,2,2,3},3));
	}
    public static int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0)
        	return 0;
        int index=0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=val)
			{
				nums[index]=nums[i];
				index++;
			}
		}
        System.out.println(Arrays.toString(nums));
        return index;
    }
}

