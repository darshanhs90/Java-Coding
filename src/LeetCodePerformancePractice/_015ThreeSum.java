package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _015ThreeSum {

	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> outputList=new ArrayList<List<Integer>>();
		if(nums==null||nums.length==0)
			return outputList;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-2; i++) {
			if(i==0 || nums[i]>nums[i-1])
			{
				int j=i+1;
				int k=nums.length-1;
				while(j<k)
				{
					if(nums[i]+nums[j]+nums[k]==0)
					{
						List<Integer> aList=new ArrayList<>();
						aList.add(nums[i]);
						aList.add(nums[j]);
						aList.add(nums[k]);
						outputList.add(aList);
						j++;
						k--;
						while(j<k && nums[j]==nums[j-1])
						{
							j++;
						}
						while(j<k && nums[k]==nums[k+1])
						{
							k--;
						}
					}
					else if(nums[i]+nums[j]+nums[k]>0)
						k--;
					else
						j++;
				}
			}
		}
		return outputList;
	}
}
