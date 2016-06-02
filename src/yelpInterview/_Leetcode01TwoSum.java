package yelpInterview;

import java.util.Arrays;

public class _Leetcode01TwoSum {

	public static void main(String a[]){
		System.out.println(Arrays.toString(twoSumSortedArray(new int[]{2, 7, 11, 15},9)));
		System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15},9)));


	}

	private static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if(j!=i)
				{
					if(nums[i]+nums[j]==target)
					{
						return new int[]{i,j};
					}
				}
			}
		}
		return null;
	}

	public static int[] twoSumSortedArray(int[] nums, int target) {
		int left=0,right=nums.length-1;
		int index1=-1,index2=-1;
		while(left<right)
		{
			int sum=nums[left]+nums[right];
			if(sum==target)
			{
				index1=left;
				index2=right;
				break;
			}
			else if(sum>target)
				right--;
			else
				left++;
		}
		return new int[]{index1,index2};
	}

}

