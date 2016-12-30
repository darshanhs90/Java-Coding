package PracticeLeetCode;

import java.util.Arrays;

public class _016ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{0,0,0},1));
	}

	private static int threeSumClosest(int[] nums, int target) {
		if(nums==null||nums.length==0)
			return -1;
		Arrays.sort(nums);
		int closestSum=Integer.MAX_VALUE;
		int closerSum=closestSum;
		for (int i = 0; i < nums.length-2; i++) {
			if(i==0||nums[i]>nums[i-1])
			{
				int j=i+1;
				int k=nums.length-1;
				while(j<k)
				{
					int sum=nums[i]+nums[j]+nums[k];
					int sumVal=sum-target;
					if(sumVal==0)
					{
						return target;
					}else if(sumVal>0){
						if(sumVal<closestSum)
						{
							closestSum=sumVal;
							closerSum=sum;
						}
						k--;
					}
					else{
						sumVal=Math.abs(sumVal);
						if(sumVal<closestSum)
						{
							closestSum=sumVal;
							closerSum=sum;
						}	
						j++;
					}
				}
			}
		}
		return closerSum;
	}
}
