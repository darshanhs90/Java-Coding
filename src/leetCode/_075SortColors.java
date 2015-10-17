package leetCode;

import java.util.Arrays;

/*
 * Link : https://leetcode.com/problemset/algorithms/
 */

public class _075SortColors {
	public static void sortColors(int[] nums) {
		int zeroCount=0,oneCount=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0)
				zeroCount++;
			else if(nums[i]==1)
				oneCount++;
		}
		for (int i = 0; i < nums.length; i++) {

			if(i<zeroCount)
				nums[i]=0;
			else if(i>=zeroCount&& i<zeroCount+oneCount)
				nums[i]=1;
			else
				nums[i]=2;
		}
	}

	public static void main(String[] args) {
		int nums[]=new int[]{1,2,0,2,1,2,0,0,2,1};
		System.out.println(Arrays.toString(nums));
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}