package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _016ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{-1,2,1 ,4},1));
	}

	private static int threeSumClosest(int[] nums, int target) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(nums==null||nums.length==0)
			return 0;
		Arrays.sort(nums);
		int closestSum=Integer.MAX_VALUE;
		int minDiff=Integer.MAX_VALUE;
		for (int i = 0; i < nums.length-2; i++) {
			if(i==0||nums[i]>nums[i-1])
			{
				int j=i+1,k=nums.length-1;
				while(j<k)
				{
					int sum=nums[i]+nums[j]+nums[k];
					int diff=Math.abs(target-sum);

					if(diff==0)
					{
						return target;
					}
					if(diff<minDiff)
					{
						closestSum=sum;
						minDiff=diff;
					}
					if(sum>target)
					{
						k--;
					}
					else{
						j++;
					}
				}
			}
		}
		return closestSum;
	}
}
