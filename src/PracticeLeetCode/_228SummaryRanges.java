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
		long start=Long.MIN_VALUE,end=Long.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if(start==Long.MIN_VALUE)
			{
				start=nums[i];
				end=nums[i];
			}
			else{
				if(nums[i]==end+1)
				{
					end=nums[i];
				}else{
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