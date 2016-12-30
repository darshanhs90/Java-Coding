package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _018FourSum {

	public static void main(String[] args) {
		System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
	}
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(nums==null||nums.length==0)
			return outputList;
		List<Integer> list;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-3; i++) {
			if(i==0||nums[i]>nums[i-1])
			{
				for (int j = i+1; j < nums.length-2; j++) {
					if(j==i+1||nums[j]>nums[j-1])
					{
						int k=j+1;
						int l=nums.length-1;
						while(k<l)
						{
							int sum=nums[i]+nums[j]+nums[k]+nums[l];
							if(sum==target)
							{
								list=new ArrayList<>();
								list.add(nums[i]);
								list.add(nums[j]);
								list.add(nums[k]);
								list.add(nums[l]);
								outputList.add(list);
								k++;
								l--;
								while(k<l && nums[k]==nums[k-1])
								{
									k++;
								}
								while(k<l && nums[l]==nums[l+1])
								{
									l--;
								}
							}
							else if(sum>target)
							{
								l--;
							}else
							{
								k++;
							}
						}
					}
				}
			}
		}
		return outputList;
	}
}
