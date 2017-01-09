package PracticeLeetCode;

import java.util.Arrays;

public class _016ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{0,0,0},1));
		System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
		
	}

	public static int threeSumClosest(int[] nums, int target) {
		if(nums==null||nums.length<2)
			return -1;
		Arrays.sort(nums);
		int closestSum=Integer.MAX_VALUE;
		int prevDiff=Integer.MAX_VALUE;
		for (int i = 0; i < nums.length-2; i++) {
			if(i==0||nums[i]>nums[i-1])
			{
				int j=i+1;
				int k=nums.length-1;
				while(j<k)
				{
					int sum=nums[i]+nums[j]+nums[k];
					int diff=sum-target;
					if(diff==0)
					{
						return sum;
					}
					else if(diff>0)
					{
						if(diff<prevDiff){
							prevDiff=diff;
							closestSum=sum;
						}
						k--;
					}
					else{
						if(Math.abs(diff)<prevDiff){
							prevDiff=Math.abs(diff);
							closestSum=sum;
						}
						j++;
					}
				}
			}
		}
		return closestSum;
	}
}
