package LeetCodePerformancePractice;

import java.util.Arrays;

public class _016ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{-1,2,1 ,4},1));
	}

	private static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int maxDiff=Integer.MAX_VALUE;
		int maxValue=0;
		for (int i = 0; i < nums.length-2; i++) {
			if(i==0||nums[i]>nums[i-1])
			{
				int j=i+1;
				int k=nums.length-1;
				while(j<k)
				{
					int value=nums[i]+nums[j]+nums[k];
					int diff=Math.abs(target-value);
					if(diff==0)
						return target;
					if(diff<maxDiff)
					{
						maxValue=value;
						maxDiff=diff;
					}
					if(value>target)
						k--;
					else
						j++;
				}
			}
		}
		return maxValue;
	}
	
}
