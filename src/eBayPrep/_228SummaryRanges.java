package LeetCodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _228SummaryRanges{
	public static void main(String[] args) {
		List<String> outputList=summaryRanges(new int[]{-1000000000,-9999,0,1,2,10,100,1000,999999999,1000000000});
		System.out.println(Arrays.toString(outputList.toArray()));

	}
	public static List<String> summaryRanges(int[] nums) {
		if(nums.length<1)
			return new ArrayList<>();
		List<String> outputList=new ArrayList<>();
		if(nums.length==1){
			outputList.add(nums[0]+"");
			return outputList;
		}
		int prev=nums[0],end=nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]==end+1)
			{
				end=nums[i];
			}
			else{
				if(prev!=end)
					outputList.add(prev+"->"+end);
				else
					outputList.add(prev+"");
				prev=end=nums[i];
			}
		}
		if(prev!=end)
			outputList.add(prev+"->"+end);
		else
			outputList.add(prev+"");
		return outputList;
	}

}

