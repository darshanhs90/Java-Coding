package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _228SummaryRanges {
	public static void main(String[] args) {
		System.out.println(summaryRanges(new int[]{0,2}));
	}
	public static List<String> summaryRanges(int[] nums) {
		List<String> outputList=new ArrayList<>();
		if(nums==null||nums.length==0)
			return outputList;
		int start=nums[0],end=nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]==end+1)
			{
				end=nums[i];
			}
			else{
				if(start==end)
				{
					outputList.add(start+"");
				}
				else{
					outputList.add(start+"->"+end);
				}
				start=nums[i];
				end=nums[i];
			}
		}
		if(start==end)
		{
			outputList.add(start+"");
		}
		else{
			outputList.add(start+"->"+end);
		}
		return outputList;

	}
}