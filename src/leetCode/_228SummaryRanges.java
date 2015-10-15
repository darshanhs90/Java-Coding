package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Link : https://leetcode.com/problems/summary-ranges/
 */

public class _228SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> outputList=new ArrayList<>();
		int count=-100;
		int start=0;
		for (int i = 0; i < nums.length; i++) {
			if(count==-100)
			{
				start=count=nums[i];
			}
			else{
				if(nums[i]==(count+1))
				{
					count++;
				}
				else{
					if(start!=nums[i-1])
						outputList.add(start+"->"+nums[i-1]);
					else
						outputList.add(start+"");
					start=nums[i];
					count=nums[i];
				}
			}
		}
		if(count==start)
			outputList.add(count+"");
		else if(count!=-100)
		{
			outputList.add(start+"->"+nums[nums.length-1]);
		}
		return outputList;
	}
	public static void main(String[] args) {
		int input[]=new int[]{0,1,2,4,5,7};
		System.out.println(Arrays.toString(summaryRanges(input).toArray()));
	}
}