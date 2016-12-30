package PracticeLeetCode;

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

		List<Integer> list;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-2; i++) {
			if(i==0||nums[i]>nums[i-1])
			{
				int j=i+1;
				int k=nums.length-1;
				while(j<k)
				{
					int sum=nums[i]+nums[j]+nums[k];
					if(sum==0)
					{
						list=new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						outputList.add(list);
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
					}else if(sum>0)
						k--;
					else
						j++;
				}
			}
		}
		return outputList;
	}
}
